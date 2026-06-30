public class InterviewBot {
    String botName;
    String technology;

    InterviewBot(String botName, String technology) {
        this.botName = botName;
        this.technology = technology;
    }

    void conductInterview() {
        System.out.println(botName + " is conducting a " + technology + " interview");
    }

    public static void main(String[] args) {
        InterviewBot bot1 = new InterviewBot("AlphaBot", "Java");
        InterviewBot bot2 = new InterviewBot("NovaBot", "Python");
        InterviewBot bot3 = new InterviewBot("ZenBot", "Data Structures");

        bot1.conductInterview();
        bot2.conductInterview();
        bot3.conductInterview();
    }
}