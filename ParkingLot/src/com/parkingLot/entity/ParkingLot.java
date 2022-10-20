package com.parkingLot.entity;

import java.util.ArrayList;

public class ParkingLot { // 4 fields
    String parkingLotId; // ye ek common id hogi jo ticket pe print hogi..ticket bnate waqt iski jaroorat padegi
    int noOfFloors;
    int noOfSlotsPerFloor;
    ArrayList<ParkingFloor> parkingFloor;

    public ParkingLot(String parkingLotId , int noOfFloors , int noOfSlotsPerFloor){
        this.parkingLotId = parkingLotId;
        this.noOfFloors = noOfFloors;
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
        parkingFloor = new ArrayList<>();
    }

    public String getParkingLotId() {
        return parkingLotId;
    }

    public void setParkingLotId(String parkingLotId) {
        this.parkingLotId = parkingLotId;
    }

    public int getNoOfFloors() {
        return noOfFloors;
    }

    public void setNoOfFloors(int noOfFloors) {
        this.noOfFloors = noOfFloors;
    }

    public int getNoOfSlotsPerFloor() {
        return noOfSlotsPerFloor;
    }

    public void setNoOfSlotsPerFloor(int noOfSlotsPerFloor) {
        this.noOfSlotsPerFloor = noOfSlotsPerFloor;
    }

    public ArrayList<ParkingFloor> getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ArrayList<ParkingFloor> parkingFloor) {
        this.parkingFloor = parkingFloor;
    }
}
