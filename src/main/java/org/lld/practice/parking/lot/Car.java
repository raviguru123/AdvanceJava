package org.lld.practice.parking.lot;

import org.lld.practice.parking.lot.strategy.CarFreeSlotFindingStrategy;

public class Car extends Vehicle {
    public Car(final String number) {
        super(1, VehicleSize.COMPACT, new CarFreeSlotFindingStrategy());
        this.setNumberPlate(number);
    }

    public boolean canFitInSpot(ParkingSpot parkingSpot) {
        return parkingSpot.vehicleSize == VehicleSize.COMPACT || parkingSpot.vehicleSize == VehicleSize.LARGE;
    }

    public void print() {
        System.out.println("Car");
    }
}
