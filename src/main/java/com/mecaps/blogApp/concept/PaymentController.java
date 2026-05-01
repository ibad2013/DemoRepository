package com.mecaps.blogApp.concept;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {


    @Autowired
    @Qualifier("phonePayService")
    private PaymentService paymentService;



    @PostMapping("/createPayment")
    public String pay(@RequestBody Double amount){
       return paymentService.pay(amount);
    }

}
