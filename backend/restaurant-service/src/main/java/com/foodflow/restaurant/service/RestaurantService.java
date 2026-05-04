package com.foodflow.restaurant.service;

import com.foodflow.restaurant.dto.CreateMenuItemDTO;
import com.foodflow.restaurant.dto.CreateRestaurantDTO;
import com.foodflow.restaurant.dto.MenuItemDTO;
import com.foodflow.restaurant.dto.RestaurantDTO;
import com.foodflow.restaurant.mapper.RestaurantMapper;
import com.foodflow.restaurant.model.MenuItem;
import com.foodflow.restaurant.model.Restaurant;
import com.foodflow.restaurant.repository.MenuItemRepository;
import com.foodflow.restaurant.repository.RestaurantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final MenuItemRepository menuItemRepository;

    public RestaurantService(RestaurantRepository restaurantRepository,
                             MenuItemRepository menuItemRepository) {
        this.restaurantRepository = restaurantRepository;
        this.menuItemRepository = menuItemRepository;
    }

    public List<RestaurantDTO> getAllRestaurants() {
        return restaurantRepository.findAll()
                .stream()
                .map(RestaurantMapper::toRestaurantDTO)
                .toList();
    }

    public List<MenuItemDTO> getMenuByRestaurantId(Long restaurantId) {
        return menuItemRepository.findByRestaurantId(restaurantId)
                .stream()
                .map(RestaurantMapper::toMenuItemDTO)
                .toList();
    }

    public RestaurantDTO getRestaurantById(Long id){
        return restaurantRepository.findById(id)
                .map(RestaurantMapper::toRestaurantDTO)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
    }

    public RestaurantDTO createRestaurant(CreateRestaurantDTO createRestaurantDTO){
        Restaurant restaurant = RestaurantMapper.toRestaurant(createRestaurantDTO);
        Restaurant savedRestaurant = restaurantRepository.save(restaurant);
        return RestaurantMapper.toRestaurantDTO(savedRestaurant);
    }

    public MenuItemDTO createMenuItem(Long restaurantId, CreateMenuItemDTO createMenuItemDTO) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));

        MenuItem menuItem = RestaurantMapper.toMenuItem(createMenuItemDTO, restaurant);
        MenuItem savedMenuItem = menuItemRepository.save(menuItem);

        return RestaurantMapper.toMenuItemDTO(savedMenuItem);
    }

    public void deleteMenuItem(Long menuItemId) {
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));

        menuItemRepository.delete(menuItem);
    }

    public MenuItemDTO updateMenuItem(Long menuItemId, CreateMenuItemDTO dto) {
        MenuItem menuItem = menuItemRepository.findById(menuItemId)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));

        menuItem.setName(dto.getName());
        menuItem.setPrice(dto.getPrice());
        menuItem.setDescription(dto.getDescription());
        menuItem.setAvailable(dto.getAvailable());

        MenuItem updated = menuItemRepository.save(menuItem);

        return RestaurantMapper.toMenuItemDTO(updated);
    }

    public List<MenuItemDTO> getAllMenuItems() {
        return menuItemRepository.findAll()
                .stream()
                .map(RestaurantMapper::toMenuItemDTO)
                .toList();
    }

    public List<RestaurantDTO> searchRestaurantsByCuisineType(String cuisineType) {
        return restaurantRepository.findByCuisineTypeIgnoreCase(cuisineType)
                .stream()
                .map(RestaurantMapper::toRestaurantDTO)
                .toList();
    }

    public List<RestaurantDTO> searchRestaurantsByName(String name) {
        return restaurantRepository.findByNameContainingIgnoreCase(name)
                .stream()
                .map(RestaurantMapper::toRestaurantDTO)
                .toList();
    }

    public List<RestaurantDTO> searchRestaurantsByCuisineTypeAndMinRating(String cuisineType, Double minRating) {
        return restaurantRepository
                .findByCuisineTypeIgnoreCaseAndRatingGreaterThanEqual(cuisineType, minRating)
                .stream()
                .map(RestaurantMapper::toRestaurantDTO)
                .toList();
    }
    public MenuItemDTO getMenuItemById(Long id){
        MenuItem menuItem = menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Menu item not found"));
        return RestaurantMapper.toMenuItemDTO(menuItem);
    }
}