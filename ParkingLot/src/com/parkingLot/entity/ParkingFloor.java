package com.parkingLot.entity;

import java.util.ArrayList;

public class ParkingFloor { // 1 field
  ArrayList<ParkingSlot> parkingSlots = null;

   public ParkingFloor(ArrayList<ParkingSlot> parkingSlots){
       this.parkingSlots = parkingSlots;
   }

    public ArrayList<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public void setParkingSlots(ArrayList<ParkingSlot> parkingSlots) {
        this.parkingSlots = parkingSlots;
    }
}
