package com.project.parkingLot.models;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
public class ParkingSpot extends BaseModel{
    private int spotNumber;
    @Enumerated(EnumType.ORDINAL)
    private VehicleType vehicleType;
    @Enumerated(EnumType.ORDINAL)
    private ParkingSpotStatus parkingSpotStatus;
    int spotPrice;
}
