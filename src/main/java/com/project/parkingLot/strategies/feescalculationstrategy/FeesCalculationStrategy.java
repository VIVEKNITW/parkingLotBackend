package com.project.parkingLot.strategies.feescalculationstrategy;

import com.project.parkingLot.models.Ticket;

import java.util.Date;

public interface FeesCalculationStrategy {
    double calculateFees(Ticket ticket, Date exitTime);
}
