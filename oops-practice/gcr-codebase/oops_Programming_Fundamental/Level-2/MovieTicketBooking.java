public class MovieTicketBooking {
    String movieName;
    int seatNumber;
    double price;

    MovieTicketBooking(String movieName) {
        this.movieName = movieName;
        this.seatNumber = 0;
        this.price = 0.0;
    }

    void bookTicket(int seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("Ticket booked for " + movieName + " at seat " + seatNumber);
    }

    void displayDetails() {
        System.out.println("Movie Name: " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price: " + price);
    }

    public static void main(String[] args) {
        MovieTicketBooking ticket = new MovieTicketBooking("Pathaan");
        ticket.bookTicket(24, 350.0);
        ticket.displayDetails();
    }
}