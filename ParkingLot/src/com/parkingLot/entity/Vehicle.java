package com.parkingLot.entity;

public class Vehicle { // 5 fields
    VehicleType vehicleType;
    ParkingSlot parkingSlot; // taki jab vehicle ko jab unpark karenge tab wo slot free kar sake
    String ticketId;
    String color;
    String vehicleRegNo;

    public Vehicle(VehicleType vehicleType , ParkingSlot parkingSlot , String color , String vehicleRegNo){
        this.vehicleType = vehicleType;
        this.parkingSlot = parkingSlot;
        this.color = color;
        this.vehicleRegNo = vehicleRegNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVehicleRegNo() {
        return vehicleRegNo;
    }

    public void setVehicleRegNo(String vehicleRegNo) {
        this.vehicleRegNo = vehicleRegNo;
    }
}
