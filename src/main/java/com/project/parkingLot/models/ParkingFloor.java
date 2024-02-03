package com.project.parkingLot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class ParkingFloor extends BaseModel{
    @OneToMany
    private List<ParkingSpot> parkingSpots;
    private int floorNumber;
    private Status status;
}
