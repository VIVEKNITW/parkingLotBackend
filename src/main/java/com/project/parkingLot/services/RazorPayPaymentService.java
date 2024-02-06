package com.project.parkingLot.services;

import com.project.parkingLot.models.Payment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("RazorPayPaymentService")
public class RazorPayPaymentService implements PaymentService{

    @Override
    public List<Payment> getPaymentData() {
        return null;
    }
}
