package com.project.parkingLot.models;

import lombok.Data;

@Data
public class Vehicle extends BaseModel{
    private  String number;
    private VehicleType vehicleType;
}
