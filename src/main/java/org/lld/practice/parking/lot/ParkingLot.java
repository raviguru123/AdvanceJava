package org.lld.practice.parking.lot;

import org.lld.practice.parking.lot.exception.VehicleNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private Level[] levels;
    private Map<String, Vehicle> vehicleMap;
    private int noOfLevels;

    public ParkingLot(int noOfLevels, int num_rows, int spots_per_row) {
        this.vehicleMap = new HashMap<>();
        levels = new Level[noOfLevels];
        for (int i = 0; i < noOfLevels; i++) {
            levels[i] = new Level(num_rows, spots_per_row, i);
        }
    }


    public boolean parkVehicle(Vehicle vehicle) {
        int level_index = -1;
        int start_pos = -1;
        for (int i = 0; i < levels.length; i++) {
            Level level = levels[i];
            level_index = i;
            start_pos = level.findAvailableSpots(vehicle);
            if (start_pos > 0)
                break;
        }
        if (start_pos < 0)
            return false;
//        System.out.println("start_pos : " + start_pos);
        Level level = this.levels[level_index];
        level.parkVehicle(vehicle, start_pos);
        this.vehicleMap.put(vehicle.getNumberPlate(), vehicle);
        return true;
    }

    public boolean unParkVehicle(final String number) throws Exception {
        if (!this.vehicleMap.containsKey(number)) {
            throw new VehicleNotFoundException("Vehicle not exist in our parking");
        }
        Vehicle vehicle = this.vehicleMap.get(number);
        vehicle.clearSpot();
        return true;
    }

    public void print() {
        for (int i = 0; i < levels.length; i++) {
            levels[i].print();
            System.out.println("\n\n");
        }
    }
}
