package com.project.parkingLot.services;

import com.project.parkingLot.exceptions.NoTicketFoundException;
import com.project.parkingLot.models.*;
import com.project.parkingLot.repositories.GateRepository;
import com.project.parkingLot.repositories.InvoiceRepository;
import com.project.parkingLot.repositories.TicketRepository;
import com.project.parkingLot.strategies.feescalculationstrategy.FeesCalculationStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {
    TicketRepository ticketRepository;
    FeesCalculationStrategy feesCalculationStrategy;
    GateRepository gateRepository;
    PaymentService paymentService;
    InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(TicketRepository ticketRepository,
                          @Qualifier("SimpleFeesCalculationStrategy") FeesCalculationStrategy feesCalculationStrategy,
                          GateRepository gateRepository,
                          @Qualifier("RazorPayPaymentService") PaymentService paymentService) {
        this.ticketRepository = ticketRepository;
        this.feesCalculationStrategy = feesCalculationStrategy;
        this.gateRepository = gateRepository;
        this.paymentService = paymentService;
    }
    public Invoice generateInvoice(long ticketId, int gateNumber, int paymentMethod) throws NoTicketFoundException {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        Ticket ticket = null;
        if(optionalTicket.isPresent()){
            throw new NoTicketFoundException("Ticket with id= "+ticketId+" not found");
        }
        ticket = optionalTicket.get();
        Date exitTime = new Date();
        double amount = feesCalculationStrategy.calculateFees(ticket, exitTime);

        Operator operator = gateRepository.findOperatorIdByGateNumber(gateNumber);

        InvoicePaidStatus invoicePaidStatus = InvoicePaidStatus.PAID;
        PaymentMode paymentMode = null;
        if(paymentMethod == 0){
            paymentMode = PaymentMode.CASH;
        }
        else if(paymentMethod == 1){
            paymentMode = PaymentMode.CREDIT_CARD;
        }
        else if(paymentMethod == 2){
            paymentMode = PaymentMode.DEBIT_CARD;
        }
        else if(paymentMethod == 3){
            paymentMode = PaymentMode.NETBANKING;
        }
        List<Payment> payments = paymentService.getPaymentData();

        Invoice invoice = new Invoice(ticket, amount, exitTime, operator, invoicePaidStatus, payments);
        return invoiceRepository.save(invoice);
    }

}
/*
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
 */
