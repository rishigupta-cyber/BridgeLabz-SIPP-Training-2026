import java.util.Scanner;

public class RockPaperScissorsGame {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter number of games:");
        int numberOfGames = sc.nextInt();

        String[] choices = { "rock", "paper", "scissors" };
        String[][] results = new String[numberOfGames][3];

        int playerWins = 0;
        int computerWins = 0;

        for (int i = 0; i < numberOfGames; i++) {
            System.out.println("Enter your choice (rock/paper/scissors) for game " + (i + 1) + ":");
            String playerChoice = sc.next();
            String computerChoice = getComputerChoice(choices);

            String winner = findWinner(playerChoice, computerChoice);

            results[i][0] = playerChoice;
            results[i][1] = computerChoice;
            results[i][2] = winner;

            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            }
        }

        displayResults(results);

        String[][] stats = calculateStats(playerWins, computerWins, numberOfGames);
        displayStats(stats);

        sc.close();
    }

    public static String getComputerChoice(String[] choices) {
        int index = (int) (Math.random() * choices.length);
        return choices[index];
    }

    public static String findWinner(String playerChoice, String computerChoice) {
        if (playerChoice.equals(computerChoice)) {
            return "Tie";
        }

        if (playerChoice.equals("rock") && computerChoice.equals("scissors")) {
            return "Player";
        } else if (playerChoice.equals("scissors") && computerChoice.equals("rock")) {
            return "Computer";
        } else if (playerChoice.equals("rock") && computerChoice.equals("paper")) {
            return "Computer";
        } else if (playerChoice.equals("paper") && computerChoice.equals("rock")) {
            return "Player";
        } else if (playerChoice.equals("scissors") && computerChoice.equals("paper")) {
            return "Player";
        } else if (playerChoice.equals("paper") && computerChoice.equals("scissors")) {
            return "Computer";
        } else {
            return "Tie";
        }
    }

    public static String[][] calculateStats(int playerWins, int computerWins, int totalGames) {
        String[][] stats = new String[2][3];

        double playerPercentage = ((double) playerWins / totalGames) * 100;
        double computerPercentage = ((double) computerWins / totalGames) * 100;

        stats[0][0] = "Player";
        stats[0][1] = String.valueOf(playerWins);
        stats[0][2] = String.valueOf(playerPercentage) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.valueOf(computerPercentage) + "%";

        return stats;
    }

    public static void displayResults(String[][] results) {
        System.out.println("\nGame Results:");
        System.out.println("Player\t\tComputer\tWinner");
        for (String[] row : results) {
            System.out.println(row[0] + "\t\t" + row[1] + "\t\t" + row[2]);
        }
    }

    public static void displayStats(String[][] stats) {
        System.out.println("\nOverall Stats:");
        System.out.println("Who\t\tWins\tPercentage");
        for (String[] row : stats) {
            System.out.println(row[0] + "\t\t" + row[1] + "\t" + row[2]);
        }
    }
}