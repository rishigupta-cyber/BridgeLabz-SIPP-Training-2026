public class TransportCompany {

    public static void main(String[] args) {
        Vehicle[] fleet = new Vehicle[5];
        fleet[0] = new Car("MH12AB1234");
        fleet[1] = new Bus("MH14CD5678");
        fleet[2] = new Bike("MH16EF9012");
        fleet[3] = new ElectricCar("MH18GH3456");
        fleet[4] = new Car("MH20IJ7890");

        double distance = 100.0;

        for (Vehicle v : fleet) {
            if (v instanceof Car) {
                Car c = (Car) v;
                System.out.println(c.registrationNumber + " is a Car, fuel cost for " + distance + " km: Rs." + c.fuelCost(distance));
            } else if (v instanceof Bus) {
                Bus b = (Bus) v;
                System.out.println(b.registrationNumber + " is a Bus, fuel cost for " + distance + " km: Rs." + b.fuelCost(distance));
            } else if (v instanceof Bike) {
                Bike bk = (Bike) v;
                System.out.println(bk.registrationNumber + " is a Bike, fuel cost for " + distance + " km: Rs." + bk.fuelCost(distance));
            } else if (v instanceof ElectricCar) {
                ElectricCar ec = (ElectricCar) v;
                System.out.println(ec.registrationNumber + " is an ElectricCar, fuel cost for " + distance + " km: Rs." + ec.fuelCost(distance));
            }
        }

        FleetReport.generateReport(fleet, distance);
    }
}