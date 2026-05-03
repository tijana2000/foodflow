package com.foodflow.restaurant.dto;

public class CreateMenuItemDTO {

    private String name;
    private Double price;
    private String description;
    private Boolean available;

    public CreateMenuItemDTO() {}

    public String getName() { return name; }
    public Double getPrice() { return price; }
    public String getDescription() { return description; }
    public Boolean getAvailable() { return available; }

    public void setName(String name) { this.name = name; }
    public void setPrice(Double price) { this.price = price; }
    public void setDescription(String description) { this.description = description; }
    public void setAvailable(Boolean available) { this.available = available; }
}