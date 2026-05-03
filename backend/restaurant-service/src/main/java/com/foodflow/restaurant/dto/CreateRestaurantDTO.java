package com.foodflow.restaurant.dto;

public class CreateRestaurantDTO {

    private String name;
    private String address;
    private String cuisineType;
    private Double rating;
    private Boolean active;

    public CreateRestaurantDTO() {
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
    public String getCuisineType() { return cuisineType; }
    public Double getRating() { return rating; }
    public Boolean getActive() { return active; }

    public void setName(String name) { this.name = name; }
    public void setAddress(String address) { this.address = address; }
    public void setCuisineType(String cuisineType) { this.cuisineType = cuisineType; }
    public void setRating(Double rating) { this.rating = rating; }
    public void setActive(Boolean active) { this.active = active; }
}