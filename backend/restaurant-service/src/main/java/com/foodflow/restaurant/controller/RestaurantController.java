package com.foodflow.restaurant.controller;

import com.foodflow.restaurant.dto.CreateMenuItemDTO;
import com.foodflow.restaurant.dto.CreateRestaurantDTO;
import com.foodflow.restaurant.dto.MenuItemDTO;
import com.foodflow.restaurant.dto.RestaurantDTO;
import com.foodflow.restaurant.model.MenuItem;
import com.foodflow.restaurant.repository.MenuItemRepository;
import com.foodflow.restaurant.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;
    private final MenuItemRepository menuItemRepository;

    public RestaurantController(RestaurantService restaurantService, MenuItemRepository menuItemRepository) {
        this.restaurantService = restaurantService;
        this.menuItemRepository = menuItemRepository;
    }

    @GetMapping
    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping ("/{id}")
    public RestaurantDTO getRestaurantById(@PathVariable Long id){
        return restaurantService.getRestaurantById(id);
    }

    @GetMapping("/{id}/menu")
    public List<MenuItemDTO> getMenuByRestaurantId(@PathVariable Long id) {
        return restaurantService.getMenuByRestaurantId(id);
    }

    @PostMapping
    public RestaurantDTO createrestaurant(@RequestBody CreateRestaurantDTO createRestaurantDTO){
        return restaurantService.createRestaurant(createRestaurantDTO);
    }

    @PostMapping("/{id}/menu")
    public MenuItemDTO createMenuItem(
            @PathVariable Long id,
            @RequestBody CreateMenuItemDTO createMenuItemDTO) {
        return restaurantService.createMenuItem(id, createMenuItemDTO);
    }

    @DeleteMapping("/menu/{menuItemId}")
    public void deleteMenuItem(@PathVariable Long menuItemId) {
        restaurantService.deleteMenuItem(menuItemId);
    }

    @PutMapping("/menu/{menuItemId}")
    public MenuItemDTO updateMenuItem(
            @PathVariable Long menuItemId,
            @RequestBody CreateMenuItemDTO dto) {
        return restaurantService.updateMenuItem(menuItemId, dto);
    }

    @GetMapping("/menu")
    public List<MenuItemDTO> getAllMenuItems() {
        return restaurantService.getAllMenuItems();
    }

    @GetMapping("/search")
    public List<RestaurantDTO> searchRestaurantsByCuisineType(@RequestParam String cuisineType) {
        return restaurantService.searchRestaurantsByCuisineType(cuisineType);
    }
    @GetMapping("/search/name")
    public List<RestaurantDTO> searchRestaurantsByName(@RequestParam String name) {
        return restaurantService.searchRestaurantsByName(name);
    }

    @GetMapping("/search/filter")
    public List<RestaurantDTO> searchRestaurantsByCuisineTypeAndMinRating(
            @RequestParam String cuisineType,
            @RequestParam Double minRating) {
        return restaurantService.searchRestaurantsByCuisineTypeAndMinRating(cuisineType, minRating);
    }
    @GetMapping("/menu-items/{id}")
    public MenuItem getMenuItemById(@PathVariable Long id){
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
        //return restaurantService.getMenuItemById(id);

    }


}