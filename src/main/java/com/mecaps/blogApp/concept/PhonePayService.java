package com.mecaps.blogApp.concept;


import org.springframework.stereotype.Component;

@Component
public class PhonePayService implements PaymentService{

    @Override
    public String pay(Double amount) {
        return "";
    }
}
