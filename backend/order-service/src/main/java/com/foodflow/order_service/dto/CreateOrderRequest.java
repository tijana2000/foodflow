package com.foodflow.order_service.dto;

import java.util.List;

public class CreateOrderRequest {
    private Long restaurantId;
    private List<OrderItemRequest> items;

    public CreateOrderRequest(){

    }
    public Long getRestaurantId(){
        return restaurantId;
    }

    public List<OrderItemRequest> getItems(){
        return items;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public void setItems(List<OrderItemRequest> items) {
        this.items = items;
    }
}
