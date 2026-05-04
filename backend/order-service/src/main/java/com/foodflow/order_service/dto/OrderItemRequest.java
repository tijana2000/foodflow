package com.foodflow.order_service.dto;

public class OrderItemRequest {
    private Long menuItemId;
    private String menuItemName;
    private Integer quantity;
    private Double price;

    public OrderItemRequest(){

    }

    public Long getMenuItemId(){
        return menuItemId;
    }
    public String getMenuItemName(){
        return menuItemName;
    }
    public Integer getQuantity(){
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setMenuItemId(Long menuItemId) {
        this.menuItemId = menuItemId;
    }

    public void setMenuItemName(String menuItemName) {
        this.menuItemName = menuItemName;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
