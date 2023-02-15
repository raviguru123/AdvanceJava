package org.lld.practice.parking.lot.strategy;

import org.lld.practice.parking.lot.ParkingSpot;

import java.util.List;

public class MotorCycleFreeSlotFindingStrategy implements FindAvailableSlotStrategy {
    public int findAvailableSpots(List<ParkingSpot> parkingSpotList) {
        int index = 0;
        for (ParkingSpot parkingSpot : parkingSpotList) {
            if (parkingSpot.isFree()) {
                return index;
            }
            index += 1;
        }
        return -1;
    }
}
