package com.oocl.cultivation;

import java.util.List;

public class SuperParkingBoy extends SmartPakingBoy{
    public SuperParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SuperParkingBoy(List<ParkingLot> parkingLot) {
        super(parkingLot);
    }


    public String getAvailableParkingLot(Car car) {
        int maxAvilableRate = 0;
        int parkingLotIndex = -1;
        for (int i = 0; i < this.getParkingLots().size(); i++) {
            if (this.getParkingLots().get(i).isParkingLotFull()) {
                if (this.getParkingLots().get(i).availableRate()>maxAvilableRate){
                    maxAvilableRate = this.getParkingLots().get(i).availableCapacity();
                    parkingLotIndex = i;
                }
            }
        }
        boolean isValid = parkingLotIndex != -1;
        return isValid ? String.valueOf(parkingLotIndex) : "Not enough position.";
    }
}
