package com.oocl.cultivation;

import java.util.List;

public class SuperParkingBoy extends SmartPakingBoy{
    public SuperParkingBoy(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public SuperParkingBoy(List<ParkingLot> parkingLot) {
        super(parkingLot);
    }
    @Override
    public ParkingLot getAvailableParkingLot() {
        ParkingLot parkingLot;
        try {
            parkingLot = this.getParkingLots().stream().filter(e -> e.isParkingLotFull())
                    .sorted((firstLot,secendLot)->{
                        return (int)((secendLot.availableRate() - firstLot.availableRate())*100);
                    }).findFirst().get();
        } catch (Exception e) {
            parkingLot = null;
        }
        return parkingLot;
    }
}
