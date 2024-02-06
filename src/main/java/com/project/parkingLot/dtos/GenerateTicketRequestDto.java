package com.project.parkingLot.dtos;

import lombok.Data;

@Data
public class GenerateTicketRequestDto {
    private String vehicleNo;
    private String vehicleType;
    private String ownerName;
    private int gateNumber;
    long parkingLotId;

}


/*
    private Date entryTime;
    @OneToOne
    private Vehicle vehicle;
    @OneToOne
    private ParkingSpot parkingSpot;
    @ManyToOne
    private Operator generatedBy;
    @ManyToOne
    private ParkingLot parkingLot;
    @OneToOne
    private Gate entryGate;
    private String ownerName;
 */