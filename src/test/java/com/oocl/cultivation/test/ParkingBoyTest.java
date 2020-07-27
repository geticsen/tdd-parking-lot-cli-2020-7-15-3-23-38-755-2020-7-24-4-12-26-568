package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingBoy;
import com.oocl.cultivation.ParkingCarTicket;
import com.oocl.cultivation.ParkingLot;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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
        fetchCar = parkingBoy.fetchCar(parkingCarTicket);

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
        fetchCar = parkingBoy.fetchCar(parkingCarTicket2);

        //then
        Assertions.assertEquals(car2, fetchCar);
    }

    @Test
    void should_return_null_when_fetch_car_given_wrong_or_not_take_parking_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        ParkingCarTicket parkingCarTicket = new ParkingCarTicket();
        Car fetchCar1;
        Car fetchCar2;

        //when
        ParkingCarTicket parkingCarTicket1 = parkingBoy.park(car1);
        ParkingCarTicket parkingCarTicket2 = parkingBoy.park(car2);
        ParkingCarTicket parkingCarTicket3 = parkingBoy.park(car3);
        fetchCar1 = parkingBoy.fetchCar(parkingCarTicket);
        fetchCar2 = parkingBoy.fetchCar(null);
        //then
        Assertions.assertEquals(null, fetchCar1);
        Assertions.assertEquals(null, fetchCar2);
    }

    @Test
    void should_return_null_when_fetch_car_given_uesed_parking_car_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingCarTicket parkingCarTicket;
        Car fetchCar, fetchCar0;
        //when
        parkingCarTicket = parkingBoy.park(car);
        fetchCar0 = parkingBoy.fetchCar(parkingCarTicket);
        fetchCar = parkingBoy.fetchCar(parkingCarTicket);
        //then
        Assertions.assertEquals(null, fetchCar);
    }

    @Test
    void should_return_null_when_parking_car_given_car_over_10() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingCarTicket parkingCarTicket = new ParkingCarTicket();

        //when
        for (int i = 1; i <= 11; i++) {
            Car car = new Car();
            parkingCarTicket = parkingBoy.park(car);
        }

        //then
        Assertions.assertEquals(null, parkingCarTicket);
    }

    @Test
    void should_return_wrong_message_when_fetch_car_given_wrong_ticket() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingCarTicket parkingCarTicket;
        Car fetchCar;

        //when

        parkingCarTicket = parkingBoy.park(car);
        fetchCar = parkingBoy.fetchCar(parkingCarTicket);
        fetchCar = parkingBoy.fetchCar(parkingCarTicket);
        //then
        Assertions.assertEquals("Unrecognized parking ticket.", parkingCarTicket.getTicketMessage());
    }

    @Test
    void should_return_wrong_message_when_fetch_car_given_none() {
        //Please provide your parking ticket.
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingCarTicket parkingCarTicket;
        String wrongMessage;

        //when
        parkingCarTicket = parkingBoy.park(car);
        wrongMessage = parkingBoy.fetchCar();

        //then
        Assertions.assertEquals("Please provide your parking ticket.", wrongMessage);
    }

    @Test
    void should_return_not_enough_position_when_parking_boy_attempt_parking_car_without_position_given_car() {
        //given
        ParkingLot parkingLot = new ParkingLot();
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car();
        ParkingCarTicket parkingCarTicket;
        String wrongMessage="";

        //when
        for (int i=0; i<10;i++){
            parkingBoy.park(car);
        }
        wrongMessage = parkingBoy.getAvailableParkingLotIndex(car);
        //then
        Assertions.assertEquals("Not enough position.", wrongMessage);
    }
    @Test
    void should_return_right_parking_lot_when_parking_boy_has_over_1_parking_lot_given_parking_car_ticket(){
        //given
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
        parkingLots.add(new ParkingLot());
        parkingLots.add(new ParkingLot());
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when

        for (int i=0;i<10;i++){
            parkingBoy.park(new Car());
        }
        Car myCar = new Car();
        ParkingCarTicket parkingCarTicket = parkingBoy.park(myCar);
        ParkingLot parkingLot = parkingBoy.findParkingLot(parkingCarTicket);
        //then
        Assertions.assertEquals(parkingLots.get(1),parkingLot);

    }

}
