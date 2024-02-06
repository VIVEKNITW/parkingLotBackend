package com.project.parkingLot.services;

import com.project.parkingLot.models.ParkingSpot;
import com.project.parkingLot.models.VehicleType;

public interface ParkingSpotStrategy {
    ParkingSpot getParkingSpot(VehicleType vehicleType);
}
