package org.lld.practice.parking.lot.strategy;

import org.lld.practice.parking.lot.ParkingSpot;
import org.lld.practice.parking.lot.VehicleSize;

import java.util.List;

public class BusFreeSlotFindingStrategy implements FindAvailableSlotStrategy {
    public int findAvailableSpots(List<ParkingSpot> parkingSpotList) {
        int index = 0;
        int count = 0;
        for (ParkingSpot parkingSpot : parkingSpotList) {
            if (parkingSpot.isFree() && parkingSpot.getVehicleSize() == VehicleSize.LARGE) {
                count += 1;
            } else {
                count = 0;
            }
            index += 1;
            if (count == 3) {
                return index - 3;
            }
        }
        return -1;
    }
}
