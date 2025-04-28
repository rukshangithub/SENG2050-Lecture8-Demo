package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service("paypal")
public class PayPalPaymentService implements PaymentService{

    public void processPayment(double amount)
    {
        System.out.println("PayPal");
        System.out.println("Amount: " + amount);
    }
}
