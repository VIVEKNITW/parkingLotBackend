package com.project.parkingLot.strategies.feescalculationstrategy;


import com.project.parkingLot.models.Ticket;
import com.project.parkingLot.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component("SimpleFeesCalculationStrategy")
public class SimpleFeesCalculationStrategy implements FeesCalculationStrategy{
    @Override
    public double calculateFees(Ticket ticket, Date exitTime) {


        Date entryTime = ticket.getEntryTime();

        long timeDifferenceInMillis = exitTime.getTime() - entryTime.getTime();
        double hoursDifference = (timeDifferenceInMillis*1.0) / (1000 * 60 * 60); // 1 hour = 1000 milliseconds * 60 seconds * 60 minutes

        return Math.ceil(hoursDifference)*ticket.getParkingSpot().getSpotPrice();
//        return 0;
    }
}
