package org.lld.practice.parking.lot.strategy;

import org.lld.practice.parking.lot.ParkingSpot;
import org.lld.practice.parking.lot.VehicleSize;

import java.util.List;

public class CarFreeSlotFindingStrategy implements FindAvailableSlotStrategy {
    public int findAvailableSpots(List<ParkingSpot> parkingSpotList) {
        int index = 0;
        for (ParkingSpot parkingSpot : parkingSpotList) {
            if (parkingSpot.isFree() && (parkingSpot.getVehicleSize() == VehicleSize.COMPACT || parkingSpot.getVehicleSize() == VehicleSize.LARGE)) {
                return index;
            }
            index += 1;
        }
        return -1;
    }
}
