package org.lld.practice.parking.lot;

import lombok.Getter;
import lombok.Setter;
import org.lld.practice.parking.lot.strategy.FindAvailableSlotStrategy;

import java.util.ArrayList;
import java.util.List;


@Getter
public abstract class Vehicle {

    @Setter
    private final FindAvailableSlotStrategy findAvailableSlotStrategy;
    private final Integer spotNeeded;

    @Setter
    private String numberPlate;

    private final VehicleSize vehicleSize;

    private List<ParkingSpot> parkingSpotList;

    public Vehicle(Integer spotNeeded, VehicleSize vehicleSize, FindAvailableSlotStrategy findAvailableSlotStrategy) {
        this.spotNeeded = spotNeeded;
        this.vehicleSize = vehicleSize;
        this.parkingSpotList = new ArrayList<>();
        this.findAvailableSlotStrategy = findAvailableSlotStrategy;
    }

    public void addSpot(ParkingSpot parkingSpot) {
        this.parkingSpotList.add(parkingSpot);
    }

    public void clearSpot() {
        for (ParkingSpot parkingSpot : parkingSpotList) {
            parkingSpot.clear();
        }
    }

    public abstract boolean canFitInSpot(ParkingSpot parkingSpot);

    public abstract void print();
}
