package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {
    private Map<ParkingCarTicket, Car> parkingCarList = new HashMap<ParkingCarTicket, Car>();

    public ParkingBoy(ParkingLot parkingLot) {
    }

    public ParkingCarTicket park(Car car) {

        ParkingCarTicket parkingCarTicket = new ParkingCarTicket();
        this.parkingCarList.put(parkingCarTicket, car);
        return parkingCarTicket;
    }

    public Car fetchCarByParkingTicket(ParkingCarTicket parkingCarTicket) {
        return this.parkingCarList.get(parkingCarTicket);
    }
}
