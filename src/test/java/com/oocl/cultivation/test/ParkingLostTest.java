package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingCarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLostTest {
    @Test
    void should_return_parking_ticket_when_store_car_given_car(){
        //given
        Car car = new Car();
        ParkingCarTicket parkingCarTicket;
        ParkingLot parkingLot = new ParkingLot();

        //when
        parkingCarTicket = parkingLot.storeCar(car);

        //then
        assertNotNull(parkingCarTicket);
    }
}
