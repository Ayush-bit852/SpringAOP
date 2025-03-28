package com.example.Spring.Initializer.service;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public String makePayment(String accountNumber) {
        System.out.println("Processing payment for account: " + accountNumber);
        return "Payment Successful for Account: " + accountNumber;
    }
}
