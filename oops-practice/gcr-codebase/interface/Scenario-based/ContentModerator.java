interface TextModeration {
    boolean isOffensive(String post);

    default void displayModerationPolicy() {
        System.out.println("Text moderation policy: Posts with offensive language will be flagged and removed");
    }
}

interface SpamDetection {
    boolean isSpam(String post);

    default void displayModerationPolicy() {
        System.out.println("Spam detection policy: Repetitive promotional content will be marked as spam");
    }

    static boolean containsRestrictedWords(String post) {
        String[] restrictedWords = {"idiot", "stupid", "hate", "buy now", "free money", "click here"};
        String lowerPost = post.toLowerCase();
        for (String word : restrictedWords) {
            if (lowerPost.contains(word)) {
                return true;
            }
        }
        return false;
    }
}

public class ContentModerator implements TextModeration, SpamDetection {

    public boolean isOffensive(String post) {
        String lowerPost = post.toLowerCase();
        return lowerPost.contains("idiot") || lowerPost.contains("stupid") || lowerPost.contains("hate");
    }

    public boolean isSpam(String post) {
        String lowerPost = post.toLowerCase();
        return lowerPost.contains("buy now") || lowerPost.contains("free money") || lowerPost.contains("click here");
    }

    public void displayModerationPolicy() {
        System.out.println("Combined policy: Posts are checked for both offensive language and spam content");
    }

    public static void main(String[] args) {
        String[] posts = {
            "Had a great day at the park with friends!",
            "You are such an idiot, nobody likes you",
            "Click here to win free money instantly!!!",
            "Just finished reading a wonderful book on Java programming",
            "Buy now and get 50% off, limited time offer"
        };

        ContentModerator moderator = new ContentModerator();

        moderator.displayModerationPolicy();
        System.out.println();

        for (String post : posts) {
            boolean spam = moderator.isSpam(post);
            boolean offensive = moderator.isOffensive(post);
            boolean restricted = SpamDetection.containsRestrictedWords(post);

            if (spam) {
                System.out.println("[SPAM] " + post);
            } else if (offensive || restricted) {
                System.out.println("[OFFENSIVE] " + post);
            } else {
                System.out.println("[VALID] " + post);
            }
        }
    }
}