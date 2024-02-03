package com.project.parkingLot.models;

import lombok.Data;

@Data
public class Gate extends BaseModel{
    private int number;
    private GateType gateType;
    private Operator operator;
    private GateStatus gateStatus;
}
