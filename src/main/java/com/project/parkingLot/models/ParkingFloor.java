package com.project.parkingLot.models;

import lombok.Data;

import java.util.List;

@Data
public class ParkingFloor extends BaseModel{
    private List<ParkingSpot> parkingSpots;
    private int floorNumber;

}
