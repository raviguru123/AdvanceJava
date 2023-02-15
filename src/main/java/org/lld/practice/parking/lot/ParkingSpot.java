package org.lld.practice.parking.lot;

import lombok.Getter;

@Getter
public class ParkingSpot {
    Vehicle vehicle;
    VehicleSize vehicleSize;
    private Level level;

    private final int spotNumber;

    private final int row;

    public ParkingSpot(Level level, int row, int spotNumber, VehicleSize vehicleSize) {
        this.vehicleSize = vehicleSize;
        this.level = level;
        this.spotNumber = spotNumber;
        this.row = row;
    }

    public void clear() {
        vehicle = null;
    }

    public void addVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isFree() {
        return this.vehicle == null;
    }

    public void print() {
        if (vehicle == null) {
            if (vehicleSize == VehicleSize.COMPACT) {
                System.out.print("c");
            } else if (vehicleSize == VehicleSize.LARGE) {
                System.out.print("l");
            } else if (vehicleSize == VehicleSize.MOTORCYCLE) {
                System.out.print("m");
            }
        } else {
            vehicle.print();
        }
    }

}
