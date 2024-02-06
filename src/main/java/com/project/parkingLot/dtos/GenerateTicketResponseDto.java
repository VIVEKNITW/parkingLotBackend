package com.project.parkingLot.dtos;

import lombok.Data;

@Data
public class GenerateTicketResponseDto {
    private long ticketId;
    private String entryTime;
    private String vehicleNumber;
    private int spotNumber;
    private String entryOperatorName;
    private String parkingLotAddress;
    private int gateNo;
    private String ownerName;
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
