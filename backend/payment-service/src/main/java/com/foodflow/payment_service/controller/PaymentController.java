package com.foodflow.payment_service.controller;

import com.foodflow.payment_service.model.Payment;
import com.foodflow.payment_service.service.PaymentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @PostMapping
    public Payment createPayment(
            @RequestParam Long orderId,
            @RequestParam Double amount){
        return paymentService.createPayment(orderId,amount);
    }
}
