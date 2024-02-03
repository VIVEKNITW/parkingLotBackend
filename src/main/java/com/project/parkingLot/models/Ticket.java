package com.project.parkingLot.models;

import java.util.Date;

public class Ticket extends BaseModel{
    private Date entryTime;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private Operator generatedBy;

    private ParkingLot parkingLot;
    private Gate entryGate;
    private String ownerName;
}
