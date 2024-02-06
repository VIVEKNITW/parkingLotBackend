package com.project.parkingLot.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Invoice extends BaseModel{
    @OneToOne
    private Ticket ticket;
    private double amount;
    private Date exitTime;
    @OneToOne
    private Operator operator;
    @Enumerated(EnumType.ORDINAL)
    private InvoicePaidStatus invoicePaidStatus;
    @OneToMany
    private List<Payment> payments;
}
