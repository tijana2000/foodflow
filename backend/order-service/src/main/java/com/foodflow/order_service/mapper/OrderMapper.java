package com.foodflow.order_service.mapper;

import com.foodflow.order_service.dto.OrderDTO;
import com.foodflow.order_service.dto.OrderItemDTO;
import com.foodflow.order_service.model.Order;
import com.foodflow.order_service.model.OrderItem;
import java.util.stream.Collectors;

public class OrderMapper {

    public static OrderDTO toOrderDTO(Order order) {

        OrderDTO dto = new OrderDTO();
        dto.setId(order.getId());
        dto.setCustomerId(order.getCustomerId());
        dto.setRestaurantId(order.getRestaurantId());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setStatus(order.getStatus());
        dto.setCreatedAt(order.getCreatedAt());
        dto.setItems(

                order.getItems()
                        .stream()
                        .map(OrderMapper::toOrderItemDTO)
                        .collect(Collectors.toList())
        );
        return dto;
    }

    private static OrderItemDTO toOrderItemDTO(OrderItem item) {

        OrderItemDTO dto = new OrderItemDTO();
        dto.setId(item.getId());
        dto.setMenuItemId(item.getMenuItemId());
        dto.setMenuItemName(item.getMenuItemName());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getPrice());
        return dto;
    }
}
