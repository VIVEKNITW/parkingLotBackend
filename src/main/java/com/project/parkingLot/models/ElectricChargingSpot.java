package com.project.parkingLot.models;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class ElectricChargingSpot extends BaseModel{
    private ParkingSpot parkingSpot;
}
