public class ElectricCar extends Vehicle {
    ElectricCar(String registrationNumber) {
        super(registrationNumber);
    }

    double fuelCost(double km) {
        return km * 2.0;
    }
}