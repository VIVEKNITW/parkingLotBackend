package com.project.parkingLot.controllers;

import com.project.parkingLot.dtos.AddOperatorRequestDto;
import com.project.parkingLot.dtos.AddOperatorResponseDto;
import com.project.parkingLot.models.Operator;
import com.project.parkingLot.services.OperatorService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OperatorController {
    OperatorService operatorService;

    public OperatorController(OperatorService operatorService) {
        this.operatorService = operatorService;
    }

    @PostMapping("/addOperator")
    public AddOperatorResponseDto addOperator(@RequestBody AddOperatorRequestDto requestDto){
        Operator operator = operatorService.addOperator(requestDto.getName(), requestDto.getPhoneNo(), requestDto.getEmail());
        AddOperatorResponseDto responseDto = new AddOperatorResponseDto();
        responseDto.setOperatorId(operator.getId());
        responseDto.setStatus("SUCCESS");
        responseDto.setMessage("added the user");

        return responseDto;
    }
}
