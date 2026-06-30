public class SpaceTourist {
    static int totalReservations = 0;
    static String missionName = "Orion Voyage";

    String touristName;
    int seatNumber;

    SpaceTourist(String touristName, int seatNumber) {
        this.touristName = touristName;
        this.seatNumber = seatNumber;
        totalReservations++;
    }

    SpaceTourist updateSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
        return this;
    }

    void displayDetails() {
        System.out.println("Mission: " + missionName + " | Tourist: " + touristName + " | Seat: " + seatNumber);
    }

    public static void main(String[] args) {
        SpaceTourist tourist1 = new SpaceTourist("Arjun Mehta", 5);
        SpaceTourist tourist2 = new SpaceTourist("Pooja Iyer", 8);

        tourist1.updateSeatNumber(10).updateSeatNumber(15);
        tourist2.updateSeatNumber(20);

        tourist1.displayDetails();
        tourist2.displayDetails();

        System.out.println("Total reservations: " + totalReservations);
    }
}