package com.project.parkingLot.strategies.feescalculationstrategy;


public class SimpleFeesCalculationStrategy implements FeesCalculationStrategy{
    @Override
    public double calculateFees(Long ticketId) {
        return 0;
    }
}
