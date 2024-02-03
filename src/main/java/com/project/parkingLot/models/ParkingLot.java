package com.project.parkingLot.models;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class ParkingLot extends BaseModel{
    private String address;
    private List<ParkingFloor> parkingFloors;
    private List<Gate> gates;
    private Map<VehicleType, VehicleTypePrice> vehicleTypePriceMap;
}
