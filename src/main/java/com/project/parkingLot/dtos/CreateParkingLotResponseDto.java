package com.project.parkingLot.dtos;

import com.project.parkingLot.models.ParkingLot;
import lombok.Data;

@Data
public class CreateParkingLotResponseDto {
    private Long id;
    private String message;
    private String status;
}
