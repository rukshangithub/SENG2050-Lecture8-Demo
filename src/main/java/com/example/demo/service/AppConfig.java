package com.example.demo.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.example.demo.entity.Department;

@Configuration
public class AppConfig {

    @Value("${spring.application.payment-gateway}")
    private String paymentGateway;

    @Bean
    @Lazy
    public PayPalPaymentService paypal()
    {
        System.out.println("Pay Pal bean created");
        return new PayPalPaymentService();
    }

    @Bean
    @Lazy
    public ShopifyPaymentService shopify()
    {
        System.out.println("Shopify bean created");
        return new ShopifyPaymentService();
    }

    @Bean
    @Scope("prototype")
    public OrderService orderService()
    {
        System.out.println("Order Service bean created");
        if (paymentGateway.equals("PayPal"))
            return new OrderService(new PayPalPaymentService());
        else    
            return new OrderService(new ShopifyPaymentService());
    }


}
