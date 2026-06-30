interface StreamingService {
    void streamMovie(String movieName);

    default void showSubscriptionDetails() {
        System.out.println("Streaming subscription: Premium plan, 4K access included");
    }
}

interface GamingService {
    void playGame(String gameName);

    default void showSubscriptionDetails() {
        System.out.println("Gaming subscription: Pro plan, cloud gaming enabled");
    }
}

public class SmartTV implements StreamingService, GamingService {
    String[] movies = {"Inception", "Interstellar", "The Matrix"};
    String[] games = {"FIFA 26", "Call of Duty", "Minecraft"};

    public void streamMovie(String movieName) {
        System.out.println("Now streaming: " + movieName);
    }

    public void playGame(String gameName) {
        System.out.println("Now playing: " + gameName);
    }

    public void showSubscriptionDetails() {
        System.out.println("Smart TV combined subscription: Premium streaming + Pro gaming bundle");
    }

    public static void main(String[] args) {
        SmartTV tv = new SmartTV();

        System.out.println("--- Available Movies ---");
        for (String movie : tv.movies) {
            tv.streamMovie(movie);
        }

        System.out.println("\n--- Available Games ---");
        for (String game : tv.games) {
            tv.playGame(game);
        }

        System.out.println();
        tv.showSubscriptionDetails();
    }
}