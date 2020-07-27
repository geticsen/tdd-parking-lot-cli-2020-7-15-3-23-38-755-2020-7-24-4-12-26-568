package com.oocl.cultivation.test;

import com.oocl.cultivation.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SuperParkingBoyTest extends SmartPakingBoyTest {
    @Test
    void should_return_most_avaliable_capacity_parking_lot_when_super_parking_boy_parking_car_given_car(){
        //given
        ParkingLot parkingLot1 =new ParkingLot(2);
        ParkingLot parkingLot2 =new ParkingLot(3);
        ParkingLot parkingLot3 =new ParkingLot(5);

        parkingLot1.storeCar(new Car());

        parkingLot2.storeCar(new Car());
        parkingLot2.storeCar(new Car());

        parkingLot3.storeCar(new Car());
        parkingLot3.storeCar(new Car());
        parkingLot3.storeCar(new Car());

        List<ParkingLot> parkingLots =new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        Car car = new Car();
        ParkingCarTicket parkingCarTicket;

        //when
        SuperParkingBoy smartPakingBoy =new SuperParkingBoy(parkingLots);
        parkingCarTicket = smartPakingBoy.park(car);
        ParkingLot parkingLot = smartPakingBoy.findParkingLot(parkingCarTicket);

        //then
        Assertions.assertEquals(parkingLot1,parkingLot);
    }
}
