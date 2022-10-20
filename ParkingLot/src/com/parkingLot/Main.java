package com.parkingLot;

import com.parkingLot.entity.Command;
import com.parkingLot.entity.DisplayType;
import com.parkingLot.entity.ParkingLot;
import com.parkingLot.entity.VehicleType;
import com.parkingLot.service.ParkingLotService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ParkingLotService parkingLotService = new ParkingLotService();

        while(true){

            Scanner sc = new Scanner(System.in);
            Command type = Command.of(sc.next());
            switch(type){ // applying switch case on enums

                case CREATE_PARKING_LOT: parkingLotService.createParkingLot(new ParkingLot(sc.next(), sc.nextInt() ,sc.nextInt()));
                break;
                case PARK_VEHICLE: parkingLotService.parkVehicle(VehicleType.valueOf(sc.next()) , sc.next() , sc.next());
                break;
                case UNPARK_VEHICLE: parkingLotService.unParkVehicle(sc.next());
                break;
                case DISPLAY:parkingLotService.display(DisplayType.of(sc.next()) ,VehicleType.valueOf(sc.next()));
                break;
                case EXIT : return;
            }
        }
    }
}
