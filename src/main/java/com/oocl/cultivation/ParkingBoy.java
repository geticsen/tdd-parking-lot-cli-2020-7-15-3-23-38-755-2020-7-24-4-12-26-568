package com.oocl.cultivation;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {

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
        String attempt = attemptPark(car);
        if (!attempt.equals("Not enough position.") || car == null) {
            return parkingLots.get(Integer.parseInt(attempt)).storeCar(car);
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
                parkingCarTicket.setTicketMessage("Unrecognized parking ticket.");
            }
        }
        return car;
    }

    public String fetchCar() {
        return "Please provide your parking ticket.";
    }

    public String attemptPark(Car car) {
        int firstHaveCapacityParkingLot = -1;
        for (int i = 0; i < parkingLots.size(); i++) {
            if (!parkingLots.get(i).isParkingLotFull()) {
                firstHaveCapacityParkingLot = i;
                break;
            }
        }
        boolean isValid = firstHaveCapacityParkingLot != -1;
        return isValid ? String.valueOf(firstHaveCapacityParkingLot) : "Not enough position.";

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
