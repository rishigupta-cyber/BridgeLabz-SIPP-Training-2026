public class RestaurantManagement {

    static class Person {
        String name;
        int id;

        Person(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    interface Worker {
        void performDuties();
    }

    static class Chef extends Person implements Worker {
        String specialty;

        Chef(String name, int id, String specialty) {
            super(name, id);
            this.specialty = specialty;
        }

        public void performDuties() {
            System.out.println(name + " (Chef, ID: " + id + ") is preparing " + specialty + " dishes in the kitchen");
        }
    }

    static class Waiter extends Person implements Worker {
        int tablesAssigned;

        Waiter(String name, int id, int tablesAssigned) {
            super(name, id);
            this.tablesAssigned = tablesAssigned;
        }

        public void performDuties() {
            System.out.println(name + " (Waiter, ID: " + id + ") is serving " + tablesAssigned + " tables");
        }
    }

    public static void main(String[] args) {
        Chef chef1 = new Chef("Sanjeev Rao", 301, "Italian");
        Waiter waiter1 = new Waiter("Anita Desai", 302, 5);

        chef1.performDuties();
        waiter1.performDuties();

        System.out.println("chef1 instanceof Person: " + (chef1 instanceof Person));
        System.out.println("chef1 instanceof Worker: " + (chef1 instanceof Worker));
        System.out.println("waiter1 instanceof Person: " + (waiter1 instanceof Person));
        System.out.println("waiter1 instanceof Worker: " + (waiter1 instanceof Worker));
    }
}