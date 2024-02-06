package com.project.parkingLot.strategies.spotassignmentstrategy;

import com.project.parkingLot.models.*;
import org.springframework.stereotype.Component;

@Component("RandomSpotAssignmentStrategy")
public class RandomSpotAssignmentStrategy implements SpotAssignmentStrategy {

    @Override
    public ParkingSpot assignSpot(ParkingLot parkingLot, VehicleType vehicleType) {
        for (ParkingFloor parkingFloor: parkingLot.getParkingFloors()) {
            for (ParkingSpot parkingSpot: parkingFloor.getParkingSpots()) {
                if (parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.AVAILABLE)
                && parkingSpot.getVehicleType().equals(vehicleType)) {
                    parkingSpot.setParkingSpotStatus(ParkingSpotStatus.UNAVAILABLE);
                    return parkingSpot;
                }
            }
        }

        return null;
    }
}
