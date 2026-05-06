package com.foodflow.order_service.service;

import com.foodflow.order_service.client.MenuItemResponse;
import com.foodflow.order_service.client.PaymentClient;
import com.foodflow.order_service.client.RestaurantClient;
import com.foodflow.order_service.dto.CreateOrderRequest;
import com.foodflow.order_service.dto.CreatePaymentRequest;
import com.foodflow.order_service.dto.OrderDTO;
import com.foodflow.order_service.dto.OrderItemRequest;
import com.foodflow.order_service.exception.OrderNotFoundException;
import com.foodflow.order_service.mapper.OrderMapper;
import com.foodflow.order_service.model.Order;
import com.foodflow.order_service.model.OrderItem;
import com.foodflow.order_service.model.OrderStatus;
import com.foodflow.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentClient paymentClient;
    private final RestaurantClient restaurantClient;

    public OrderService(OrderRepository orderRepository, RestaurantClient restaurantClient, PaymentClient paymentClient) {
        this.orderRepository = orderRepository;
        this.restaurantClient = restaurantClient;
        this.paymentClient = paymentClient;
    }

    public OrderDTO createOrder(Long customerId, CreateOrderRequest request) {

        Order order = new Order();
        order.setCustomerId(customerId);
        order.setRestaurantId(request.getRestaurantId());
        order.setStatus(OrderStatus.CREATED);
        order.setCreatedAt(LocalDateTime.now());
        List<OrderItem> items = request.getItems()
                .stream()
                .map(itemRequest -> mapToOrderItem(itemRequest, order))
                .collect(Collectors.toCollection(ArrayList::new));
        order.setItems(items);


        double totalPrice = items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        order.setTotalPrice(totalPrice);
        Order savedOrder = orderRepository.save(order);
        CreatePaymentRequest paymentRequest = new CreatePaymentRequest();
        paymentRequest.setOrderId(savedOrder.getId());
        paymentRequest.setAmount(savedOrder.getTotalPrice());
        paymentRequest.setPaymentMethod(request.getPaymentMethod());
        paymentClient.createPayment(paymentRequest);
        savedOrder.setStatus(OrderStatus.CONFIRMED);
        Order confirmedOrder = orderRepository.save(savedOrder);
        return OrderMapper.toOrderDTO(confirmedOrder);
    }

    private OrderItem mapToOrderItem(OrderItemRequest request, Order order) {
        MenuItemResponse menuItem = restaurantClient.getMenuItemById(request.getMenuItemId());


        OrderItem item = new OrderItem();
        item.setMenuItemId(request.getMenuItemId());
        item.setMenuItemName(menuItem.getName());
        item.setQuantity(request.getQuantity());
        item.setPrice(menuItem.getPrice());
        item.setOrder(order);

        return item;
    }

    public List<OrderDTO> getOrdersByCustomer(Long customerId){
        return orderRepository.findByCustomerId(customerId)
                .stream()
                .map(OrderMapper::toOrderDTO)
                .toList();
    }

    public OrderDTO getOrderById(Long id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new OrderNotFoundException(id));
        return OrderMapper.toOrderDTO(order);
    }

    public List<OrderDTO> getAllOrders(){
        return orderRepository.findAll()
                .stream()
                .map(OrderMapper::toOrderDTO)
                .toList();
    }

}
