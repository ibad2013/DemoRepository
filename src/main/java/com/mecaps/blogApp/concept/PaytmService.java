package com.mecaps.blogApp.concept;


import org.springframework.stereotype.Component;

@Component("paytm")
public class PaytmService implements PaymentService{

    @Override
    public String pay(Double amount) {
        return "";
    }
}
