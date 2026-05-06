package com.foodflow.payment_service.service;

import com.foodflow.payment_service.dto.CreatePaymentRequest;
import com.foodflow.payment_service.model.Payment;
import com.foodflow.payment_service.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public Payment createPayment(CreatePaymentRequest request){
        Payment payment = new Payment();
        payment.setOrderId(request.getOrderId());
        payment.setAmount(request.getAmount());
        payment.setPaymentMethod(request.getPaymentMethod());
        payment.setStatus("SUCCESS");
        payment.setCreatedAt(LocalDateTime.now());

        return paymentRepository.save(payment);
    }

    public List<Payment> getAllPayments(){
        return paymentRepository.findAll();
    }
    public Payment getPaymentById(Long id){
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Payment not found"));
    }
    public List<Payment> getPaymentByOrderId(Long orderId){
        return paymentRepository.findByOrderId(orderId);
    }


}
