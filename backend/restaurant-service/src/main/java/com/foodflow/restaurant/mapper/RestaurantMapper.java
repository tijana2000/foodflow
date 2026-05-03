package com.foodflow.restaurant.mapper;

import com.foodflow.restaurant.dto.CreateMenuItemDTO;
import com.foodflow.restaurant.dto.CreateRestaurantDTO;
import com.foodflow.restaurant.dto.MenuItemDTO;
import com.foodflow.restaurant.dto.RestaurantDTO;
import com.foodflow.restaurant.model.MenuItem;
import com.foodflow.restaurant.model.Restaurant;


public class RestaurantMapper {

    public static RestaurantDTO toRestaurantDTO(Restaurant restaurant) {
        return new RestaurantDTO(
                restaurant.getId(),
                restaurant.getName(),
                restaurant.getAddress(),
                restaurant.getCuisineType(),
                restaurant.getRating(),
                restaurant.getActive()
        );
    }

    public static MenuItemDTO toMenuItemDTO(MenuItem menuItem) {
        return new MenuItemDTO(
                menuItem.getId(),
                menuItem.getName(),
                menuItem.getPrice(),
                menuItem.getDescription(),
                menuItem.getAvailable(),
                menuItem.getRestaurant().getId()
        );
    }

    public static Restaurant toRestaurant(CreateRestaurantDTO dto){
        Restaurant restaurant = new Restaurant();
        restaurant.setName(dto.getName());
        restaurant.setAddress(dto.getAddress());
        restaurant.setCuisineType(dto.getCuisineType());
        restaurant.setRating(dto.getRating());
        restaurant.setActive(dto.getActive());
        return restaurant;
    }

    public static MenuItem toMenuItem(CreateMenuItemDTO dto, Restaurant restaurant){
        MenuItem menuItem = new MenuItem();
        menuItem.setName(dto.getName());
        menuItem.setPrice(dto.getPrice());
        menuItem.setDescription(dto.getDescription());
        menuItem.setAvailable(dto.getAvailable());
        menuItem.setRestaurant(restaurant);
        return menuItem;
    }


}