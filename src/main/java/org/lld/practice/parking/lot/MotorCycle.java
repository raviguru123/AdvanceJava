package org.lld.practice.parking.lot;

import org.lld.practice.parking.lot.strategy.MotorCycleFreeSlotFindingStrategy;

public class MotorCycle extends Vehicle {
    public MotorCycle(final String number) {
        super(1, VehicleSize.MOTORCYCLE, new MotorCycleFreeSlotFindingStrategy());
        this.setNumberPlate(number);
    }

    public boolean canFitInSpot(ParkingSpot parkingSpot) {
        return true;
    }

    public void print() {
        System.out.println("MotorCycle");
    }
}
