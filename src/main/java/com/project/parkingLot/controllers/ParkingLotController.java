package com.project.parkingLot.controllers;


import com.project.parkingLot.dtos.CreateParkingLotRequestDto;
import com.project.parkingLot.dtos.CreateParkingLotResponseDto;
import com.project.parkingLot.dtos.ResponseDto;
import com.project.parkingLot.models.ParkingLot;
import com.project.parkingLot.services.ParkingLotService;


public class ParkingLotController {
    private ParkingLotService parkingLotService = new ParkingLotService();
//
//    public ParkingLotController(ParkingLotService parkingLotService) {
//        this.parkingLotService = parkingLotService;
//    }

    public ResponseDto<CreateParkingLotResponseDto> createParkingLot(CreateParkingLotRequestDto request) {
        ParkingLot parkingLot = parkingLotService.createParkingLot(request.getAddress());

        CreateParkingLotResponseDto response = new CreateParkingLotResponseDto();
        response.setParkingLot(parkingLot);

        ResponseDto<CreateParkingLotResponseDto> baseResponse = new ResponseDto<>();
        baseResponse.setStatus("Success");
        baseResponse.setData(response);

        return baseResponse;
    }

}

// address
// dto -> Data Transfer Objects
// - request params as well as well as Response
// COntrollers should be lightweight
// {
//   status:
//   data: {
//      parkingLot: ,
//      daysSinceExistence: ,
//   }
// }