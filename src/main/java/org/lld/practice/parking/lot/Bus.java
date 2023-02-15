package org.lld.practice.parking.lot;

import org.lld.practice.parking.lot.strategy.BusFreeSlotFindingStrategy;

public class Bus extends Vehicle {
    public Bus(final String number) {
        super(5, VehicleSize.LARGE, new BusFreeSlotFindingStrategy());
        this.setNumberPlate(number);
    }

    public boolean canFitInSpot(ParkingSpot parkingSpot) {
        return parkingSpot.vehicleSize == this.getVehicleSize();
    }
    public  void print() {
        System.out.println("Bus");
    }
}
