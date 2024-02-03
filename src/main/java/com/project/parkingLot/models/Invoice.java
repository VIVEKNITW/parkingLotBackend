package com.project.parkingLot.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Invoice extends BaseModel{
    private Ticket ticket;
    private double amount;
    private Date exitTime;
    private Operator operator;
    private InvoicePaidStatus invoicePaidStatus;
    private List<Payment> payments;
}
