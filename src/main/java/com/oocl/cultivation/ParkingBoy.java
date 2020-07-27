package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

    private static final String NOT_ENOUGH_POSITION = "Not enough position.";
    private static final String UNRECOGNIZED_PARKING_TICKET = "Unrecognized parking ticket.";
    public static final String NO_TICKET = "Please provide your parking ticket.";
    private List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

    public ParkingBoy() {

    }

    public ParkingBoy(ParkingLot parkingLot) {
        this.parkingLots.add(parkingLot);
    }

    public ParkingBoy(List<ParkingLot> parkingLot) {
        this.parkingLots = parkingLot;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public ParkingCarTicket park(Car car) {
        ParkingLot parkingLot  = getAvailableParkingLot();
        if (parkingLot!=null || car != null) {
            return parkingLot.storeCar(car);
        } else {
            return null;
        }
    }

    public Car fetchCar(ParkingCarTicket parkingCarTicket) {
        ParkingLot parkingLot = findParkingLot(parkingCarTicket);
        Car car = null;
        if (parkingLot != null) {
            car = parkingLot.fethCar(parkingCarTicket);
        } else {
            if (null != parkingCarTicket) {
                parkingCarTicket.setTicketMessage(UNRECOGNIZED_PARKING_TICKET);
            }
        }
        return car;
    }

    public String fetchCar() {
        return NO_TICKET;
    }

    public ParkingLot getAvailableParkingLot() {
        ParkingLot parkingLot;
        try {
            parkingLot = this.getParkingLots().stream().filter(e->e.isParkingLotFull()).findFirst().get();
        }catch (Exception e){
            parkingLot = null;
        }
        return parkingLot;
    }

    public ParkingLot findParkingLot(ParkingCarTicket parkingCarTicket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.isCarInParkingLot(parkingCarTicket)) {
                return parkingLot;
            }
        }
        return null;
    }

}
