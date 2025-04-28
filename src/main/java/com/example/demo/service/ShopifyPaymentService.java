package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service("shopify")
public class ShopifyPaymentService implements PaymentService
{
    public void processPayment(double amount)
    {
        System.out.println("Shopify");
        System.out.println("Amount: " + amount);
    }
}
