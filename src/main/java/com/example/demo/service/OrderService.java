package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;

@Service
public class OrderService {

    private PaymentService paymentService;

    public OrderService()
    {
        this.paymentService = null;
    }

    @PostConstruct
    public void init()
    {
        System.out.println("OrderService: Good place to initialise after the constructor");
    }

    @Autowired
    public OrderService(@Qualifier("paypal") PaymentService paymentService)
    {
        this.paymentService = paymentService;
    }

    public void placeOrder()
    {
        paymentService.processPayment(100);
    }

}
