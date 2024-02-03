package com.project.parkingLot.models;

import lombok.Data;

@Data
public class ParkingSpot extends BaseModel{
    private int spotNumber;
    private VehicleType vehicleType;
    private ParkingSpotStatus parkingSpotStatus;

}
