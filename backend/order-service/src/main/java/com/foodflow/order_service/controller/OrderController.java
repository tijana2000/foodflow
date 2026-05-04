package com.foodflow.order_service.controller;

import com.foodflow.order_service.dto.CreateOrderRequest;
import com.foodflow.order_service.dto.OrderDTO;
import com.foodflow.order_service.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    public OrderDTO createOrder(
            @RequestParam Long customerId,
            @RequestBody CreateOrderRequest request){
        return orderService.createOrder(customerId,request);
    }

    @GetMapping
    public List<OrderDTO> getOrdersByCustomer(@RequestParam Long customerId){
        return orderService.getOrdersByCustomer(customerId);
    }

    @GetMapping("/{id}")
    public OrderDTO getOrderById(@PathVariable Long id){
        return orderService.getOrderById(id);
    }


}
