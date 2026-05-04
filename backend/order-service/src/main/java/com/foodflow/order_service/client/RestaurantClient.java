package com.foodflow.order_service.client;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestaurantClient {
    private final RestTemplate restTemplate = new RestTemplate();

    public MenuItemResponse getMenuItemById(Long menuItemId){
        return restTemplate.getForObject(
                "http://localhost:8081/restaurants/menu-items/" + menuItemId, MenuItemResponse.class
        );
    }
}
