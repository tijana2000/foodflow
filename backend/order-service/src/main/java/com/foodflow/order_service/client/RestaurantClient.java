package com.foodflow.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "RESTAURANT-SERVICE")
public interface RestaurantClient {
    @GetMapping("/restaurants/menu-items/{menuItemId}")
    MenuItemResponse getMenuItemById(@PathVariable Long menuItemId);
}
