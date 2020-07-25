package com.oocl.cultivation;

import java.util.List;

public class SmartPakingBoy extends ParkingBoy {
    public SmartPakingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartPakingBoy(List<ParkingLot> parkingLot) {
        super(parkingLot);
    }

    @Override
    public String attemptPark(Car car) {
        double maxAvilableRate = 0;
        int parkingLotIndex = -1;
        for (int i = 0; i < this.getParkingLots().size(); i++) {
            if (!this.getParkingLots().get(i).isParkingLotFull()) {
                if (this.getParkingLots().get(i).availableRate()>maxAvilableRate){
                    maxAvilableRate = this.getParkingLots().get(i).availableRate();
                    parkingLotIndex = i;
                }
            }
        }
        boolean isValid = parkingLotIndex != -1;
        return isValid ? String.valueOf(parkingLotIndex) : "Not enough position.";
    }
}
