package com.foodflow.payment_service.controller;

import com.foodflow.payment_service.dto.CreatePaymentRequest;
import com.foodflow.payment_service.model.Payment;
import com.foodflow.payment_service.service.PaymentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payments")
public class PaymentController {
    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @PostMapping
    public Payment createPayment(
            @RequestBody CreatePaymentRequest request){

        return paymentService.createPayment(request);
    }
    @GetMapping
    public List<Payment> getAllPayments(){
        return paymentService.getAllPayments();
    }

    @GetMapping("/{id}")
    public Payment getPaymentById(@PathVariable Long id){
        return paymentService.getPaymentById(id);
    }
    @GetMapping("/order/{orderId}")
    public List<Payment> getPaymentsByOrderId(@PathVariable Long orderId){
        return paymentService.getPaymentByOrderId(orderId);
    }
}
