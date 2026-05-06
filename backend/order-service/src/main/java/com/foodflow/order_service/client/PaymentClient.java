package com.foodflow.order_service.client;

import com.foodflow.order_service.dto.CreatePaymentRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "PAYMENT-SERVICE")
public interface PaymentClient {
    @PostMapping("/payments")
    Object createPayment(@RequestBody CreatePaymentRequest request);
}
