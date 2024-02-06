package com.project.parkingLot.services;

import com.project.parkingLot.models.ParkingSpot;
import com.project.parkingLot.models.ParkingSpotStatus;
import com.project.parkingLot.models.VehicleType;
import org.springframework.stereotype.Component;

@Component("SimpleParkingSpotStrategy")
public class SimpleParkingSpotStrategy implements ParkingSpotStrategy{
    @Override
    public ParkingSpot getParkingSpot(VehicleType vehicleType) {
//        ParkingSpot parkingSpot = new ParkingSpot(2, vehicleType, ParkingSpotStatus.AVAILABLE, 10);
//        return parkingSpot;
        return null;
    }
}


/*public class ParkingSpot extends BaseModel{
    private int spotNumber;
    @Enumerated(EnumType.ORDINAL)
    private VehicleType vehicleType;
    @Enumerated(EnumType.ORDINAL)
    private ParkingSpotStatus parkingSpotStatus;
    int spotPrice;
}
*/
