package com.oocl.cultivation.strategy;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingCarTicket;

public interface ParkingStategy {
    ParkingCarTicket park(Car car);
}
