public class OnlineQuizApplication {
    public static void main(String[] args) {
        String answers[] = {"A", "B", "C", "D"};
        String correctAnswer = "A";

        for (int i = 0; i <= 5; i++) {
            try {
                if (answers[i] == null) {
                    throw new NullPointerException("Answer at index " + i + " is null.");
                }
                if (answers[i].equals(correctAnswer)) {
                    System.out.println("Index " + i + ": Correct!");
                } else {
                    System.out.println("Index " + i + ": Wrong! (Got " + answers[i] + ")");
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Index " + i + ": Error - Index out of bounds. No answer exists at this position.");
            } catch (NullPointerException e) {
                System.out.println("Index " + i + ": Error - " + e.getMessage());
            }
        }
    }
}