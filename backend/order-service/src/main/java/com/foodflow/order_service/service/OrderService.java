package com.foodflow.order_service.service;

import com.foodflow.order_service.dto.CreateOrderRequest;
import com.foodflow.order_service.dto.OrderDTO;
import com.foodflow.order_service.dto.OrderItemRequest;
import com.foodflow.order_service.mapper.OrderMapper;
import com.foodflow.order_service.model.Order;
import com.foodflow.order_service.model.OrderItem;
import com.foodflow.order_service.model.OrderStatus;
import com.foodflow.order_service.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service

public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
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
                .toList();
        order.setItems(items);

        double totalPrice = items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();

        order.setTotalPrice(totalPrice);
        Order savedOrder = orderRepository.save(order);
        return OrderMapper.toOrderDTO(savedOrder);
    }

    private OrderItem mapToOrderItem(OrderItemRequest request, Order order) {

        OrderItem item = new OrderItem();
        item.setMenuItemId(request.getMenuItemId());
        item.setMenuItemName(request.getMenuItemName());
        item.setQuantity(request.getQuantity());
        item.setPrice(request.getPrice());
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
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return OrderMapper.toOrderDTO(order);
    }

}
