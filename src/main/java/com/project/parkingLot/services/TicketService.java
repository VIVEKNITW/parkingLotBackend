package com.project.parkingLot.services;


import com.project.parkingLot.models.*;
import com.project.parkingLot.repositories.GateRepository;
import com.project.parkingLot.repositories.OperatorRepository;
import com.project.parkingLot.repositories.ParkingLotRepository;
import com.project.parkingLot.repositories.TicketRepository;

import com.project.parkingLot.strategies.spotassignmentstrategy.SpotAssignmentStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class TicketService {
    TicketRepository ticketRepository;
    GateRepository gateRepository;
    OperatorRepository operatorRepository;
    ParkingLotRepository parkingLotRepository;

    SpotAssignmentStrategy spotAssignmentStrategy;


    @Autowired
    public TicketService(TicketRepository ticketRepository,
                         GateRepository gateRepository,
                         OperatorRepository operatorRepository,
                         ParkingLotRepository parkingLotRepository,
                         @Qualifier("RandomSpotAssignmentStrategy") SpotAssignmentStrategy spotAssignmentStrategy) {
        this.ticketRepository = ticketRepository;
        this.gateRepository = gateRepository;
        this.operatorRepository = operatorRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.spotAssignmentStrategy = spotAssignmentStrategy;
    }

    public Ticket generateTicket(String ownerName, int gateNumber, String vehicleNo, String vehicleType, long parkingLotId){
        Date entryTime = new Date();
        System.out.println("datetime = "+entryTime);
        VehicleType vehicleTypeEnum = null;
        if(vehicleType.equals("2W")){
            vehicleTypeEnum = VehicleType.TWO_W;
        }
        else if(vehicleType.equals("4W")){
            vehicleTypeEnum = VehicleType.FOUR_W;
        }
        else if(vehicleType.equals("2WE")){
            vehicleTypeEnum = VehicleType.TWO_WE;
        }
        if(vehicleType.equals("4WE")){
            vehicleTypeEnum = VehicleType.FOUR_WE;
        }
        System.out.println("vehicletype = "+vehicleTypeEnum.name());
        Vehicle vehicle = new Vehicle(vehicleNo, vehicleTypeEnum);

        Operator operator = gateRepository.findOperatorIdByGateNumber(gateNumber);
        Optional<Operator> optionalOperator= operatorRepository.findById(operator.getId());

        Optional<ParkingLot> optionalParkingLot = parkingLotRepository.findById(parkingLotId);
        ParkingLot parkingLot = null;
        if(optionalOperator.isPresent()){
            parkingLot = optionalParkingLot.get();
        }


        ParkingSpot parkingSpot = spotAssignmentStrategy.assignSpot(parkingLot, vehicleTypeEnum);
        System.out.println("spot assigned = "+parkingSpot.getSpotNumber()+" "+parkingSpot.getVehicleType()+" "+parkingSpot.getSpotPrice());
//        long operatorId = gateRepository.findOperatorIdByGateNumber(gateNumber);

//        Operator operator = null;
//        if(optionalOperator.isPresent()){
//            operator = optionalOperator.get();
//        }


        long gateId = gateRepository.findByGateNumber(gateNumber);
        Optional<Gate> optionalGate = gateRepository.findById(gateId);
        Gate gate = null;
        if(optionalGate.isPresent()){
            gate = optionalGate.get();
        }

        Ticket T = new Ticket(entryTime, vehicle, parkingSpot, operator, parkingLot, gate, ownerName);
        System.out.println("ticket generated");
        ticketRepository.save(T);
//        return new Ticket();
        return T;
    }
}

/*
public class Ticket extends BaseModel{
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
}
 */
