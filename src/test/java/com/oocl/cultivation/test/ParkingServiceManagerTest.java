package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingServiceManagerTest {
    @Test
    void should_return_parking_car_ticket_when_manager_specify_parking_boy_parking_car_given_car(){
        //given
        ParkingServiceManager parkingServiceManager = new ParkingServiceManager();
        ParkingLot parkingLot =new ParkingLot(10,parkingServiceManager);
        ParkingBoy parkingBoy =new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingCarTicket parkingCarTicket;

        //when
        parkingServiceManager.addManageParkingBoy(parkingBoy);

        parkingCarTicket = parkingServiceManager.specifyParkingBoy(parkingBoy).park(car);

        //then
        assertNotNull(parkingCarTicket);
    }
    @Test
    void should_return_car_when_manager_specify_parking_boy_fetch_car_given_parking_car_ticket(){
        //given
        ParkingServiceManager parkingServiceManager = new ParkingServiceManager();
        ParkingLot parkingLot =new ParkingLot(10,parkingServiceManager);
        ParkingBoy parkingBoy =new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingCarTicket parkingCarTicket;
        Car fetchCar;
        //when
        parkingServiceManager.addManageParkingBoy(parkingBoy);

        parkingCarTicket = parkingServiceManager.specifyParkingBoy(parkingBoy).park(car);
        fetchCar = parkingServiceManager.specifyParkingBoy(parkingBoy).fetchCarByParkingTicket(parkingCarTicket);
        //then
        Assertions.assertEquals(car,fetchCar);
    }

}
