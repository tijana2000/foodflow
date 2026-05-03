package com.foodflow.restaurant.repository;

import com.foodflow.restaurant.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCuisineTypeIgnoreCase(String cuisineType);

    List<Restaurant> findByNameContainingIgnoreCase(String name);

    List<Restaurant> findByCuisineTypeIgnoreCaseAndRatingGreaterThanEqual(
            String cuisineType,
            Double rating
    );
}