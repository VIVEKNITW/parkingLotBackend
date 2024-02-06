package com.project.parkingLot.controllers;

import com.project.parkingLot.dtos.GenerateTicketRequestDto;
import com.project.parkingLot.dtos.GenerateTicketResponseDto;
import com.project.parkingLot.models.Ticket;
import com.project.parkingLot.services.TicketService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TicketController {
    TicketService ticketService;

    public TicketController(TicketService ticketService){
        this.ticketService=ticketService;
    }

    @PostMapping("/generateTicket")
    public GenerateTicketResponseDto generateTicket(@RequestBody GenerateTicketRequestDto requestDto){
        GenerateTicketResponseDto responseDto = new GenerateTicketResponseDto();

        Ticket T = ticketService.generateTicket(requestDto.getOwnerName(),
                requestDto.getGateNumber(),
                requestDto.getVehicleNo(),
                requestDto.getVehicleType(),
                requestDto.getParkingLotId());

        responseDto.setTicketId(T.getId());
        responseDto.setEntryTime(T.getEntryTime().toString());
        responseDto.setGateNo(T.getEntryGate().getNumber());
        responseDto.setOwnerName(T.getOwnerName());
        responseDto.setVehicleNumber(T.getVehicle().getNumber());
        responseDto.setSpotNumber(T.getParkingSpot().getSpotNumber());
        responseDto.setEntryOperatorName(T.getEntryGate().getOperator().getName());
        responseDto.setParkingLotAddress(T.getParkingLot().getAddress());

        return responseDto;
    }


    @DeleteMapping("/deleteTicket/{ticketId}")
    public String deleteTicket(@PathVariable Long ticketId){
        ticketService.deleteTicket(ticketId);
        return "Success";
    }
}
