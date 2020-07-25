package com.oocl.cultivation;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Map<ParkingCarTicket, Car> parkingCarList = new HashMap<ParkingCarTicket, Car>();
    private int capacity;

    public Map<ParkingCarTicket, Car> getParkingCarList() {
        return parkingCarList;
    }

    public ParkingCarTicket storeCar(Car car) {
        ParkingCarTicket parkingCarTicket = new ParkingCarTicket();
        parkingCarList.put(parkingCarTicket, car);
        return parkingCarTicket;
    }

    public Car fethCar(ParkingCarTicket parkingCarTicket) {
        return parkingCarList.remove(parkingCarTicket);
    }

    public void setParkingCarList(Map<ParkingCarTicket, Car> parkingCarList) {
        this.parkingCarList = parkingCarList;
    }

    public ParkingLot() {
        this.capacity = 10;
    }
    public ParkingLot(int capacity) {
        this.capacity =capacity;
    }

    public boolean isParkingLotFull() {
        return parkingCarList.size() >= capacity;
    }
    public boolean isCarInParkingLot(ParkingCarTicket parkingCarTicket){
        return parkingCarList.get(parkingCarTicket)==null?false:true;
    }
    public int availableCapacity(){
        return capacity -parkingCarList.size();
    }
    public double availableRate() {
        return (capacity - parkingCarList.size())/(double) capacity;
    }
}
