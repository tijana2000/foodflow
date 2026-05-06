package com.foodflow.payment_service.controller;

import com.foodflow.payment_service.dto.CreatePaymentRequest;
import com.foodflow.payment_service.model.Payment;
import com.foodflow.payment_service.service.PaymentService;
import org.springframework.web.bind.annotation.*;

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
}
