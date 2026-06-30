public class Bike extends Vehicle {
    Bike(String registrationNumber) {
        super(registrationNumber);
    }

    double fuelCost(double km) {
        return km * 3.0;
    }
}