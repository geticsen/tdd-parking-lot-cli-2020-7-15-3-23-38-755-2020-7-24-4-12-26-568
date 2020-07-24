package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingCarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;


public class ParkingBoyTest {
    @Test
    void should_return_ticket_when_parking_boy_park_car_given_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        ParkingCarTicket parkingCarTicket= parkingBoy.park(car);

        //then
        assertNotNull(parkingCarTicket);
    }
    @Test
    void should_return_car_when_fetch_car_given_parking_car_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Car fetchCar;
        //when
        ParkingCarTicket parkingCarTicket= parkingBoy.park(car);
        fetchCar = parkingBoy.fetchCarByParkingTicket(parkingCarTicket);
        //then
        Assertions.assertEquals(car,fetchCar);
    }
}
