public class VehicleManagement {

    static class Vehicle {
        double maxSpeed;
        String model;

        Vehicle(double maxSpeed, String model) {
            this.maxSpeed = maxSpeed;
            this.model = model;
        }

        void displayDetails() {
            System.out.println("Model: " + model + " | Max Speed: " + maxSpeed + " km/h");
        }
    }

    interface Refuelable {
        void refuel();
    }

    static class ElectricVehicle extends Vehicle {
        double batteryCapacity;

        ElectricVehicle(double maxSpeed, String model, double batteryCapacity) {
            super(maxSpeed, model);
            this.batteryCapacity = batteryCapacity;
        }

        void charge() {
            System.out.println(model + " is charging. Battery capacity: " + batteryCapacity + " kWh");
        }
    }

    static class PetrolVehicle extends Vehicle implements Refuelable {
        double tankCapacity;

        PetrolVehicle(double maxSpeed, String model, double tankCapacity) {
            super(maxSpeed, model);
            this.tankCapacity = tankCapacity;
        }

        public void refuel() {
            System.out.println(model + " is refueling. Tank capacity: " + tankCapacity + " liters");
        }
    }

    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle(180.0, "Tesla Model 3", 75.0);
        PetrolVehicle pv = new PetrolVehicle(220.0, "Maruti Swift", 45.0);

        ev.displayDetails();
        ev.charge();

        pv.displayDetails();
        pv.refuel();

        System.out.println("pv instanceof Vehicle: " + (pv instanceof Vehicle));
        System.out.println("pv instanceof Refuelable: " + (pv instanceof Refuelable));
    }
}