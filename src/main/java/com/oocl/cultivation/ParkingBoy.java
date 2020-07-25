package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingBoy {

    private ParkingLot parkingLot;

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingCarTicket park(Car car) {
        if (parkingLot.isParkingLotFull() || car == null) {
            return null;
        } else {
            return parkingLot.storeCar(car);
        }
    }

    public Car fetchCarByParkingTicket(ParkingCarTicket parkingCarTicket) {
        Car car = parkingLot.fethCar(parkingCarTicket);
        if (car==null){
            parkingCarTicket.setTicketMessage("Unrecognized parking ticket.");
        }
        return car;
    }

    public String fetchCarByParkingTicket() {
        return "Please provide your parking ticket.";
    }
}
