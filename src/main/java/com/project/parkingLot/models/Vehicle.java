package com.project.parkingLot.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle extends BaseModel{
    private  String number;
    @Enumerated(EnumType.ORDINAL)
    private VehicleType vehicleType;
}
