public class Bus extends Vehicle {
    Bus(String registrationNumber) {
        super(registrationNumber);
    }

    double fuelCost(double km) {
        return km * 15.0;
    }
}