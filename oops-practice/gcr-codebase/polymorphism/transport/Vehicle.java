public abstract class Vehicle {
    String registrationNumber;

    Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    abstract double fuelCost(double km);
}