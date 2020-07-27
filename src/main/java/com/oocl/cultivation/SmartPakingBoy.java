package com.oocl.cultivation;

import java.util.List;

public class SmartPakingBoy extends ParkingBoy {
    public SmartPakingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SmartPakingBoy(List<ParkingLot> parkingLot) {
        super(parkingLot);
    }


    public String getAvailableParkingLot(Car car) {
        int maxAvilable = 0;
        int parkingLotIndex = -1;
        for (int i = 0; i < this.getParkingLots().size(); i++) {
            if (this.getParkingLots().get(i).isParkingLotFull()) {
                if (this.getParkingLots().get(i).availableCapacity()>maxAvilable){
                    maxAvilable = this.getParkingLots().get(i).availableCapacity();
                    parkingLotIndex = i;
                }
            }
        }
        boolean isValid = parkingLotIndex != -1;
        return isValid ? String.valueOf(parkingLotIndex) : "Not enough position.";
    }
}
