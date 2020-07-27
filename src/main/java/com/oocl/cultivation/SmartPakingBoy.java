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
    public ParkingLot getAvailableParkingLot() {
        ParkingLot parkingLot;
        try {
            parkingLot = this.getParkingLots().stream().filter(e -> e.isParkingLotFull())
                    .sorted((firstLot,secendLot)->{
                        return secendLot.availableCapacity() - firstLot.availableCapacity();
                    }).findFirst().get();
        } catch (Exception e) {
            parkingLot = null;
        }
        return parkingLot;
    }
}
