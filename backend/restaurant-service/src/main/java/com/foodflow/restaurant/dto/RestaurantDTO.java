package com.foodflow.restaurant.dto;

public class RestaurantDTO {

    private Long id;
    private String name;
    private String address;
    private String cuisineType;
    private Double rating;
    private Boolean active;

    public RestaurantDTO() {
    }

    public RestaurantDTO(Long id, String name, String address, String cuisineType, Double rating, Boolean active) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cuisineType = cuisineType;
        this.rating = rating;
        this.active = active;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getCuisineType() { return cuisineType; }
    public Double getRating() { return rating; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setCuisineType(String cuisineType) { this.cuisineType = cuisineType; }
    public void setRating(Double rating) { this.rating = rating; }
    public void setActive(Boolean active) { this.active = active; }
}