package com.parkingLot.service;

import com.parkingLot.entity.DisplayType;
import com.parkingLot.entity.ParkingFloor;
import com.parkingLot.entity.ParkingLot;
import com.parkingLot.entity.ParkingSlot;
import com.parkingLot.entity.Vehicle;
import com.parkingLot.entity.VehicleType;
import com.parkingLot.repository.ParkingDataRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ParkingLotService {
    HashMap<String, Vehicle> vehicleHashMap; // for storing ticket and vehicle (kis vehicle ko kaunsa ticket mila)
    ParkingLot parkingLot;
    ParkingDataRepository parkingDataRepository;

    //   input format
//    create_parking_lot <parking_lot_id> <no_of_floors> <no_of_slots_per_floor>
//    park_vehicle <vehicle_type> <reg_no> <color>
//    unpark_vehicle <ticket_id>
//    display <display_type> <vehicle_type>
// -->   Possible values of display_type: free_count, free_slots, occupied_slots
//Exit


    //use to initilaize all the above ones
    public void createParkingLot(ParkingLot parkingLot) {
        vehicleHashMap = new HashMap<>();
        this.parkingLot = parkingLot;
        parkingDataRepository = new ParkingDataRepository();
        //Data intiliaze kardo memory mein
        this.parkingLot.setParkingFloor(parkingDataRepository.initilizeData(parkingLot.getNoOfFloors(), parkingLot.getNoOfSlotsPerFloor()));
        System.out.println("Created parking lot with " + parkingLot.getNoOfFloors() +
                "floors and " + parkingLot.getNoOfSlotsPerFloor() + " slots per floor");
    }

    public void parkVehicle(VehicleType vehicleType, String vehicleRegNo, String color) {
        //find the first available slot to park the vehicle
        ParkingSlot parkingSlot = getFirstAvailableSlot(vehicleType);
        if(parkingSlot == null){
            System.out.println("Parking lot is full");
        }
        else{
            parkingSlot.setFree(false);
            Vehicle vehicle = new Vehicle(vehicleType ,parkingSlot , color , vehicleRegNo);
            String ticketId = generateTicket(parkingSlot);
            vehicleHashMap.put(ticketId , vehicle);
            System.out.println("Parked vehicle . Ticket ID :"+ticketId);
        }
    }

    public void unParkVehicle(String ticketId){
        if(vehicleHashMap.get(ticketId)!=null) { // vehicle exist
            Vehicle vehicle = vehicleHashMap.get(ticketId);
            ParkingSlot parkingSlot = vehicle.getParkingSlot();
            parkingLot.getParkingFloor().get(parkingSlot.getFloorId()).getParkingSlots().get(parkingSlot.getSlotId()).setFree(true);
            vehicleHashMap.remove(ticketId);
            System.out.println("Unparked vehicle with Registration Number:" + vehicle.getVehicleRegNo() +
                    "and Color:" + vehicle.getColor());
        }
        else{
            System.out.println("Invalid Ticket");
        }
    }

    public void display(DisplayType displayType , VehicleType vehicleType){
   if(displayType == DisplayType.FREE_COUNT){
       displayFreeCount(vehicleType);
   }
   else if(displayType == DisplayType.FREE_SLOTS){
       displayFreeSlots(vehicleType);
   }
   else if(displayType == DisplayType.OCCUPIED_SLOTS){
       displayOccupiedSlots(vehicleType);
   }
    }

    private void displayOccupiedSlots(VehicleType vehicleType) {
        //har floor pe iss paritcular vehicle ke occupied slots btane hai
        for(int i=0;i<parkingLot.getParkingFloor().size();i++){
            ParkingFloor parkingFloor = parkingLot.getParkingFloor().get(i);
            List<ParkingSlot> collect = parkingFloor.getParkingSlots().stream().filter(parkingSlot ->
                            parkingSlot.getVehicleType().equals(vehicleType)).
                    filter(parkingSlot -> !parkingSlot.isFree()).collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            sb.append("Occupied slots for ").append(vehicleType).append(" on Floor ").append(i+1).append(" : ");
            for(ParkingSlot parkingSlot : collect){
                sb.append(parkingSlot.getSlotId()+1); //NOTE
                sb.append(",");
            }
            System.out.println(sb);
        }
    }

    private void displayFreeSlots(VehicleType vehicleType) {
        //har floor pe iss paritcular vehicle ke availabe free slots btane hai
        for(int i=0;i<parkingLot.getParkingFloor().size();i++){
            ParkingFloor parkingFloor = parkingLot.getParkingFloor().get(i);
            List<ParkingSlot> collect = parkingFloor.getParkingSlots().stream().filter(parkingSlot ->
                            parkingSlot.getVehicleType().equals(vehicleType)).
                    filter(parkingSlot -> parkingSlot.isFree()).collect(Collectors.toList());
            StringBuilder sb = new StringBuilder();
            sb.append("Free slots for ").append(vehicleType).append(" on Floor ").append(i+1).append(" : ");
            for(ParkingSlot parkingSlot : collect){
                sb.append(parkingSlot.getSlotId()+1); //NOTE
                sb.append(",");
            }
            System.out.println(sb);
        }
    }

    private void displayFreeCount(VehicleType vehicleType) {
    // har floor pe iss partiular vehicle ki free available count btani hai
        for(int i=0;i<parkingLot.getParkingFloor().size();i++){
            ParkingFloor parkingFloor = parkingLot.getParkingFloor().get(i);
            long count = parkingFloor.getParkingSlots().stream().filter(parkingSlot ->
                    parkingSlot.getVehicleType().equals(vehicleType)).filter(parkingSlot -> parkingSlot.isFree()).count();
            System.out.println(" No. of free slots for " +vehicleType+" on Floor "+ (i+1) +" :"+ count);
        }
    }

    private String generateTicket(ParkingSlot parkingSlot) {
        return parkingLot.getParkingLotId()+"_"+(parkingSlot.getFloorId()+1)+"_"+(parkingSlot.getSlotId()+1);
    }

    private ParkingSlot getFirstAvailableSlot(VehicleType vehicleType) {
        ArrayList<ParkingFloor> parkingFloors = parkingLot.getParkingFloor();
        for (ParkingFloor parkingFloor : parkingFloors) {
            List<ParkingSlot> availableVehicleTypeParkingSlot =
                    getAvailableVehicleTypeParkingSlot(parkingFloor.getParkingSlots(), vehicleType);
            for(ParkingSlot parkingSlot : availableVehicleTypeParkingSlot){
                if(parkingSlot.getVehicleType().equals(vehicleType) && parkingSlot.isFree()){
                    return parkingSlot;
                }
            }
        }
        return null;
    }

    //this function will tell ki given vehicle type ke slots available bhi hai ki nahi hai
    private List<ParkingSlot> getAvailableVehicleTypeParkingSlot(ArrayList<ParkingSlot> parkingSlots, VehicleType vehicleType) {
        if (vehicleType.equals(VehicleType.TRUCK) && parkingSlots.size() >= 1) {
            return Arrays.asList(parkingSlots.get(0)); // since arr is fixed size so ham parameter mein array eles de rahe hai aur usse list bna rahe hai
        } else if (vehicleType.equals(VehicleType.BIKE) && parkingSlots.size() >= 3) {
            return Arrays.asList(parkingSlots.get(1), parkingSlots.get(2));
        } else {
            return parkingSlots;
        }
    }
}
