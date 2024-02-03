package com.project.parkingLot.models;

import java.util.Date;

public class Payment extends BaseModel{
    private String referenceNumber;
    private double amount;
    private Date timeOfPayment;
    private Invoice invoice;
    private PaymentStatus paymentStatus;
    private PaymentMode paymentMode;
}
