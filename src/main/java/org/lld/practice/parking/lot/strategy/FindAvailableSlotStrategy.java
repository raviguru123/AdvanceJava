package org.lld.practice.parking.lot.strategy;

import org.lld.practice.parking.lot.ParkingSpot;

import java.util.List;

public interface FindAvailableSlotStrategy {
    public int findAvailableSpots(List<ParkingSpot> parkingSpotList);
}
