package com.foodflow.order_service.dto;

import java.util.List;

public class CreateOrderRequest {
    private Long restaurantId;
    private List<OrderItemRequest> items;
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
