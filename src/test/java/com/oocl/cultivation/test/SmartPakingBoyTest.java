package com.oocl.cultivation.test;

import com.oocl.cultivation.Car;
import com.oocl.cultivation.ParkingCarTicket;
import com.oocl.cultivation.ParkingLot;
import com.oocl.cultivation.SmartPakingBoy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SmartPakingBoyTest extends ParkingBoyTest{
    @Test
    void should_return_most_suitable_parking_lot_when_smart_parking_boy_parking_car_given_car(){
        //given
        ParkingLot parkingLot1 =new ParkingLot(10);
        ParkingLot parkingLot2 =new ParkingLot(10);
        ParkingLot parkingLot3 =new ParkingLot(10);

        parkingLot1.storeCar(new Car());
        parkingLot1.storeCar(new Car());

        parkingLot2.storeCar(new Car());
        parkingLot2.storeCar(new Car());

        parkingLot3.storeCar(new Car());

        List<ParkingLot> parkingLots =new ArrayList<ParkingLot>();
        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);
        parkingLots.add(parkingLot3);
        Car car = new Car();
        ParkingCarTicket parkingCarTicket;

        //when
        SmartPakingBoy smartPakingBoy =new SmartPakingBoy(parkingLots);
        parkingCarTicket = smartPakingBoy.park(car);
        ParkingLot parkingLot = smartPakingBoy.findParkingLot(parkingCarTicket);

        //then
        Assertions.assertEquals(parkingLot3,parkingLot);
    }
}
