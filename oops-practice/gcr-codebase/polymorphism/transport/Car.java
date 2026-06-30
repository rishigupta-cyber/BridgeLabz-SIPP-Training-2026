public class Car extends Vehicle {
    Car(String registrationNumber) {
        super(registrationNumber);
    }

    double fuelCost(double km) {
        return km * 8.0;
    }
}