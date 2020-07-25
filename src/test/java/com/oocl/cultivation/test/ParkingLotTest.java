package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingCarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ParkingLotTest {
    @Test
    void should_return_parking_ticket_when_store_car_given_car() {
        //given
        Car car = new Car();
        ParkingCarTicket parkingCarTicket;
        ParkingLot parkingLot = new ParkingLot();

        //when
        parkingCarTicket = parkingLot.storeCar(car);

        //then
        assertNotNull(parkingCarTicket);
    }

    @Test
    void should_return_car_when_store_car_after_take_given_parking_car_ticket() {
        //given
        Car car = new Car();
        ParkingCarTicket parkingCarTicket;
        ParkingLot parkingLot = new ParkingLot();

        //when
        parkingCarTicket = parkingLot.storeCar(car);
        Car carFetch = parkingLot.fethCar(parkingCarTicket);

        //then
        Assertions.assertEquals(car, carFetch);
    }
    @Test
    void should_return_fifty_percent_when_get_available_rate_given_five_car() {
        //given

        ParkingLot parkingLot = new ParkingLot();

        //when
        for (int i=0;i<5;i++){
            parkingLot.storeCar(new Car());
        }

        //then
        Assertions.assertEquals(1/(double)2, parkingLot.availableRate());
    }
    @Test
    void should_reurn_5_when_get_avaliable_capacity_given_five_car(){
        //given
        ParkingLot parkingLot = new ParkingLot();

        //when
        for (int i=0;i<5;i++){
            parkingLot.storeCar(new Car());
        }

        //then
        Assertions.assertEquals(5, parkingLot.availableCapacity());
    }
}
