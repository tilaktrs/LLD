package com.parkingLot.repository;

import com.parkingLot.entity.ParkingFloor;
import com.parkingLot.entity.ParkingSlot;
import com.parkingLot.entity.VehicleType;

import java.util.ArrayList;

//consider this as a Dao layer (using in memory db)
public class ParkingDataRepository {
    ArrayList<ParkingFloor> parkingFloorData; // ArrayList
    ArrayList<ParkingSlot> parkingSlotData;

    // har floor mein slots ko initilize karna hia yha
    //parkingFloorData ko bharna hai yha
    public ArrayList<ParkingFloor> initilizeData(int noOfFloors , int noOfSlots){
        parkingFloorData = new ArrayList<>(noOfFloors);
        for(int i=0;i<noOfFloors;i++) {
            initilizeSlots(noOfSlots);
            //now we need to set floorId to each parking slot
            for (ParkingSlot parkingSlot : parkingSlotData) {
                parkingSlot.setFloorId(i);
            }
            parkingFloorData.add(new ParkingFloor(parkingSlotData));   // parking floor ko sirf parking slots chaiye***
        }
        return parkingFloorData;
    }

 // parkingSlotData ko barna hai
    private void initilizeSlots(int noOfSlots) {
        parkingSlotData = new ArrayList<>(noOfSlots);
        if(noOfSlots>=1){
            parkingSlotData.add(getTruckData());
        }
        if(noOfSlots>=3){
            for(int i=1;i<3;i++){
                parkingSlotData.add(getBikeData(i));
            }
        }
        if(noOfSlots>3){
            for(int i=3;i<noOfSlots;i++){
                parkingSlotData.add(getCarData(i));
            }
        }

    }

    private ParkingSlot getCarData(int slotId) {
        return new ParkingSlot(VehicleType.CAR , true , slotId);
    }

    private ParkingSlot getBikeData(int slotId) {
        return new ParkingSlot(VehicleType.BIKE , true , slotId );
    }

    private ParkingSlot getTruckData() {
        return new ParkingSlot(VehicleType.TRUCK , true , 0);
    }



}
