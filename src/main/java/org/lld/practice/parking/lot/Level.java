package org.lld.practice.parking.lot;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<ParkingSpot> parkingSpotList;
    private int floor;

    private int noOfRows;

    private int noOfFreeSpot;


    public Level(int noOfRows, int noOfSpots, int floor) {
        this.noOfRows = noOfRows;
        this.floor = floor;
        parkingSpotList = new ArrayList<>();

        int numberSpots = 0;

        for (int i = 0; i < noOfRows; i++) {
            for (int j = 0; j < noOfSpots / 4; j++) {
                parkingSpotList.add(new ParkingSpot(this, i, numberSpots, VehicleSize.MOTORCYCLE));
                numberSpots += 1;
            }

            System.out.println("Small numberSpots ===" + numberSpots);
            for (int j = noOfSpots / 4; j < 3 * (noOfSpots / 4); j++) {
                parkingSpotList.add(new ParkingSpot(this, i, numberSpots, VehicleSize.COMPACT));
                numberSpots += 1;
            }
            System.out.println("medium numberSpots ===" + numberSpots);
            for (int j = 3 * (noOfSpots / 4); j < noOfSpots; j++) {
                parkingSpotList.add(new ParkingSpot(this, i, numberSpots, VehicleSize.LARGE));
                numberSpots += 1;
            }
            noOfFreeSpot = numberSpots;
            System.out.println("Large numberSpots ===" + numberSpots);

        }
    }


    public int findAvailableSpots(Vehicle vehicle) {
        int start_pos = vehicle.getFindAvailableSlotStrategy().findAvailableSpots(this.parkingSpotList);
        return start_pos;
    }

    public void parkVehicle(Vehicle vehicle, int start_pos) {
        int index = 0;
        if (vehicle.getVehicleSize() == VehicleSize.MOTORCYCLE || vehicle.getVehicleSize() == VehicleSize.COMPACT) {
            index = 1;
        } else {
            index = 3;
        }

        for (int i = 0; i < index; i++) {
            ParkingSpot parkingSpot = parkingSpotList.get(start_pos);
            parkingSpot.addVehicle(vehicle);
            vehicle.addSpot(parkingSpot);
            start_pos += 1;
        }
    }


    public void print() {
        int lastRow = -1;
        for (int i = 0; i < parkingSpotList.size(); i++) {
            ParkingSpot spot = parkingSpotList.get(i);
            System.out.print(spot.vehicleSize + ":" + spot.isFree() + "     ");
//            if (spot.getRow() != lastRow) {
//                System.out.print("  ");
//                lastRow = spot.getRow();
//            }
//            spot.print();
        }
    }


}
