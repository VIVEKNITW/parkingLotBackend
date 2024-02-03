package com.project.parkingLot.services;


import com.project.parkingLot.models.ParkingLot;
import com.project.parkingLot.repositories.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot createParkingLot(String address) {
        ParkingLot parkingLot = new ParkingLot();

        return parkingLot;
    }
}


// UserController
// registerUser() {
//  userService.registerUser()
// }
// MCController
// registerMasterclass() {
//  if (!userAccount) {
//      userService.createAccount();
//  }
//  MCService.registerUser();
// }
