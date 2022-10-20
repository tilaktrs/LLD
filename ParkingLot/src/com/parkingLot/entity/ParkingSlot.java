package com.parkingLot.entity;

public class ParkingSlot{ //5 fields
    //NOTE har parking slot ka ticket generate karne ke liye parking slot ki floor id and uski slot id chaiye (given)
    int floorId; // taki jab unpark karne ke baad jab slot ko free karna ho tab ham uss particular slot se (jo vehicle se milega)
    // floorId nikal ke us floor pe jaake is slot ko free mark sake
    int slotId;
    Vehicle vehicle; //in a parking slot different vehicle and its types will be there
    boolean isFree;
    VehicleType vehicleType;

    public ParkingSlot(VehicleType vehicleType , boolean isFree , int slotId){ //***** takes only three parameters
        this.vehicleType = vehicleType;
        this.isFree = isFree;
        this.slotId = slotId;
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public int getSlotId() {
        return slotId;
    }

    public void setSlotId(int slotId) {
        this.slotId = slotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isFree() {
        return isFree;
    }

    public void setFree(boolean free) {
        isFree = free;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
