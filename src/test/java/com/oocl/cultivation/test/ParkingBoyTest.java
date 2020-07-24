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
    void should_return_ticket_when_parking_boy_park_car_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();

        //when
        ParkingCarTicket parkingCarTicket = parkingBoy.park(car);

        //then
        assertNotNull(parkingCarTicket);
    }

    @Test
    void should_return_car_when_fetch_car_given_parking_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        Car fetchCar;

        //when
        ParkingCarTicket parkingCarTicket = parkingBoy.park(car);
        fetchCar = parkingBoy.fetchCarByParkingTicket(parkingCarTicket);

        //then
        Assertions.assertEquals(car, fetchCar);
    }

    @Test
    void should_return_right_car_when_parking_boy_parking_cars_after_fetch_car_given_correct_parking_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car fetchCar;

        //when
        ParkingCarTicket parkingCarTicket1 = parkingBoy.park(car1);
        ParkingCarTicket parkingCarTicket2 = parkingBoy.park(car2);
        ParkingCarTicket parkingCarTicket3 = parkingBoy.park(car3);
        fetchCar = parkingBoy.fetchCarByParkingTicket(parkingCarTicket2);

        //then
        Assertions.assertEquals(car2, fetchCar);
    }
    @Test
    void should_return_null_when_fetch_car_given_wrong_or_not_take_parking_car_ticket(){
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkingCarTicket parkingCarTicket =new ParkingCarTicket();
        Car fetchCar1;
        Car fetchCar2;

        //when
        ParkingCarTicket parkingCarTicket1 = parkingBoy.park(car1);
        ParkingCarTicket parkingCarTicket2 = parkingBoy.park(car2);
        ParkingCarTicket parkingCarTicket3 = parkingBoy.park(car3);
        fetchCar1 = parkingBoy.fetchCarByParkingTicket(parkingCarTicket);
        fetchCar2 = parkingBoy.fetchCarByParkingTicket();
        //then
        Assertions.assertEquals(null, fetchCar1);
        Assertions.assertEquals(null, fetchCar2);
    }
}
