package org.lld.practice.parking.lot;

public class Driver {
    public static void main(String[] args) throws Exception {
        int level = 1, num_rows = 1, spots_per_row = 25;
        ParkingLot parkingLot = new ParkingLot(level, num_rows, spots_per_row);
        System.out.println(parkingLot.parkVehicle(new MotorCycle("Motorcycle_1"))); // return true
        System.out.println(parkingLot.parkVehicle(new Car("Car_1")));
        System.out.println(parkingLot.parkVehicle(new Car("Car_2")));
        System.out.println(parkingLot.parkVehicle(new Car("Car_3")));
        System.out.println(parkingLot.parkVehicle(new Car("Car_4")));
        System.out.println(parkingLot.parkVehicle(new Car("Car_5")));
        System.out.println(parkingLot.parkVehicle(new Car("Car_6")));
        System.out.println(parkingLot.parkVehicle(new Car("Car_7")));
        System.out.println(parkingLot.parkVehicle(new Car("Car_8")));
        System.out.println(parkingLot.parkVehicle(new Car("Car_9")));
        System.out.println(parkingLot.parkVehicle(new Car("Car_10")));
        System.out.println(parkingLot.parkVehicle(new Car("Car_11")));
        System.out.println(parkingLot.parkVehicle(new Car("Car_12")));
        System.out.println(parkingLot.parkVehicle(new Bus("Bus_1")));
        System.out.println(parkingLot.parkVehicle(new Bus("Bus_3")));
        parkingLot.print();
        System.out.println("This must be Failed :" + parkingLot.parkVehicle(new Car("Car_13")));
        System.out.println(parkingLot.unParkVehicle("Car_5"));

        parkingLot.print();
        parkingLot.unParkVehicle("Car_3");
        parkingLot.unParkVehicle("Car_4");
        parkingLot.unParkVehicle("Car_5");
        parkingLot.print();
        System.out.println("Last Bus " + parkingLot.parkVehicle(new Bus("Bus_2")));
    }
}
