package com.project.parkingLot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@Entity
public class ParkingLot extends BaseModel{
    private String address;
    @OneToMany
    private List<ParkingFloor> parkingFloors;
    @OneToMany
    private List<Gate> gates;

//    private Map<VehicleType, VehicleTypePrice> vehicleTypePriceMap;
}
