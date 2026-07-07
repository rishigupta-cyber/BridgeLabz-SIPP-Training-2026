import java.util.LinkedList;

public class MusicPlaylistRecommendationEngine {
    static LinkedList<String> recentlyPlayed = new LinkedList<>();
    static final int MAX_HISTORY = 10;

    static void playSong(String songName) {
        if (recentlyPlayed.contains(songName)) {
            recentlyPlayed.remove(songName);
        }

        recentlyPlayed.addFirst(songName);

        if (recentlyPlayed.size() > MAX_HISTORY) {
            String removedSong = recentlyPlayed.removeLast();
            System.out.println("Removed oldest song from history: " + removedSong);
        }

        System.out.println("Now playing: " + songName);
    }

    static void searchSong(String songName) {
        if (recentlyPlayed.contains(songName)) {
            System.out.println(songName + " found in recently played history");
        } else {
            System.out.println(songName + " not found in recently played history");
        }
    }

    static void displayRecentlyPlayed() {
        System.out.println("--- Recently Played (latest first) ---");
        int count = 1;
        for (String song : recentlyPlayed) {
            System.out.println(count + ". " + song);
            count++;
        }
    }

    public static void main(String[] args) {
        String[] songs = {
            "Shape of You", "Blinding Lights", "Levitating", "Stay",
            "Bad Habit", "Flowers", "Calm Down", "As It Was",
            "Anti-Hero", "Unholy", "Kill Bill"
        };

        for (String song : songs) {
            playSong(song);
        }

        System.out.println();
        searchSong("Shape of You");
        searchSong("Bad Habit");

        System.out.println();
        displayRecentlyPlayed();
    }
}