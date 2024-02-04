package com.project.parkingLot.services;


import com.project.parkingLot.models.Operator;
import com.project.parkingLot.repositories.OperatorRepository;
import org.springframework.stereotype.Service;

@Service
public class OperatorService {
    OperatorRepository operatorRepository;

    public OperatorService(OperatorRepository operatorRepository) {
        this.operatorRepository = operatorRepository;
    }

    public Operator addOperator(String name, String phoneNo, String email){
        Operator savedOperator = operatorRepository.save(new Operator(name, phoneNo,email));
        return savedOperator;
    }
}
