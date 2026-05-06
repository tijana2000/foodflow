package com.foodflow.order_service.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class CreateOrderRequest {
    @NotNull(message = "Restaurant id is required")
    private Long restaurantId;

    @Valid
    @NotNull(message = "Items are required")
    private List<OrderItemRequest> items;

    @NotNull(message = "Payment method is required")
    private String paymentMethod;

    public CreateOrderRequest(){

    }
    public Long getRestaurantId(){
        return restaurantId;
    }

    public List<OrderItemRequest> getItems(){
        return items;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
