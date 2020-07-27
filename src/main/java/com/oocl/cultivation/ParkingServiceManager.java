package com.oocl.cultivation;


import java.util.ArrayList;
import java.util.List;

public class ParkingServiceManager extends ParkingBoy{
    private List<ParkingBoy> parkingBoyList = new ArrayList<ParkingBoy>();
    public ParkingServiceManager() {
        super();
    }

    public ParkingServiceManager(ParkingLot parkingLot) {
        super(parkingLot);
    }

    public ParkingServiceManager(List<ParkingLot> parkingLot) {
        super(parkingLot);
    }

    public void addManageParkingBoy(ParkingBoy parkingBoy) {
        this.parkingBoyList.add(parkingBoy);
    }

    public ParkingBoy specifyParkingBoy(ParkingBoy parkingBoy) {
        return parkingBoy;
    }
}
