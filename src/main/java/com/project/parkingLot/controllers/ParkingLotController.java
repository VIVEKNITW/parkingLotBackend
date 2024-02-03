package com.project.parkingLot.controllers;

import com.project.parkingLot.dtos.CreateParkingLotRequestDto;
import com.project.parkingLot.dtos.CreateParkingLotResponseDto;
import com.project.parkingLot.dtos.ResponseDto;
import com.project.parkingLot.models.ParkingLot;
import com.project.parkingLot.services.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ParkingLotController {
    private ParkingLotService parkingLotService;

    @Autowired
    public ParkingLotController(ParkingLotService parkingLotService) {
        this.parkingLotService = parkingLotService;
    }

    @PostMapping("/addParkingLot")
    public CreateParkingLotResponseDto createParkingLot(@RequestBody CreateParkingLotRequestDto request) {
        String address = "Hyderabad Telangana";
        ParkingLot parkingLot = parkingLotService.createParkingLot(request.getAddress());




        CreateParkingLotResponseDto response = new CreateParkingLotResponseDto();
        return response;
    }

}

/*
ParkingLot:
    private String address;
    @OneToMany
    private List<ParkingFloor> parkingFloors;
    @OneToMany
    private List<Gate> gates;

ParkingFloor:
    @OneToMany
    private List<ParkingSpot> parkingSpots;
    private int floorNumber;
    private Status status;

ParkingSpot
    private int spotNumber;
    @ManyToOne
    private VehicleType vehicleType;
    private ParkingSpotStatus parkingSpotStatus;
    int spotPrice;
 */