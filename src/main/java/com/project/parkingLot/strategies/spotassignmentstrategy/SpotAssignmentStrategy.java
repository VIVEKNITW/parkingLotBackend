package com.project.parkingLot.strategies.spotassignmentstrategy;


import com.project.parkingLot.models.*;

public interface SpotAssignmentStrategy {
    ParkingSpot assignSpot(ParkingLot parkingLot,
                           VehicleType vehicleType);
}
