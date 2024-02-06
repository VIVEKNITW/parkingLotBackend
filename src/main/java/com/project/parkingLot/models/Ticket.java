package com.project.parkingLot.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket extends BaseModel{
    private Date entryTime;
    @OneToOne(cascade = CascadeType.ALL)
    private Vehicle vehicle;
    @OneToOne(cascade = CascadeType.ALL)
    private ParkingSpot parkingSpot;
    @ManyToOne(cascade = CascadeType.ALL)
    private Operator generatedBy;
    @ManyToOne(cascade = CascadeType.ALL)
    private ParkingLot parkingLot;
    @ManyToOne(cascade = CascadeType.ALL)
    private Gate entryGate;
    private String ownerName;
}
