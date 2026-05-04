package com.foodflow.order_service.dto;
import com.foodflow.order_service.model.OrderStatus;
import java.time.LocalDateTime;
import java.util.List;
public class OrderDTO {

    private Long id;
    private Long customerId;
    private Long restaurantId;
    private Double totalPrice;
    private OrderStatus status;
    private LocalDateTime createdAt;
    private List<OrderItemDTO> items;

    public Long getId() {
        return id;
    }
    public Long getCustomerId() {
        return customerId;
    }
    public Long getRestaurantId() {
        return restaurantId;
    }
    public Double getTotalPrice() {
        return totalPrice;
    }
    public OrderStatus getStatus() {
        return status;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
    public void setStatus(OrderStatus status) {
        this.status = status;
    }
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
    }
}