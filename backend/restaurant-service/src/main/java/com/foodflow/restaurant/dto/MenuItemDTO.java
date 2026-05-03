package com.foodflow.restaurant.dto;

public class MenuItemDTO {

    private Long id;
    private String name;
    private Double price;
    private String description;
    private Boolean available;
    private Long restaurantId;

    public MenuItemDTO() {
    }

    public MenuItemDTO(Long id, String name, Double price, String description, Boolean available, Long restaurantId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.available = available;
        this.restaurantId = restaurantId;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public Double getPrice() { return price; }
    public String getDescription() { return description; }
    public Boolean getAvailable() { return available; }
    public Long getRestaurantId() { return restaurantId; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(Double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setAvailable(Boolean available) { this.available = available; }
    public void setRestaurantId(Long restaurantId) { this.restaurantId = restaurantId; }
}