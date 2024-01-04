package seminars.third.tdd;

public class MoodAnalyser {

    public String analyseMood(String message) {
        String [] goodMoodWords = {"хор", "весел", "отличн"};
        String [] badMoodWords = {"плох", "зло", "парш"};
        for (String badWord: badMoodWords) {
            if (message.contains(badWord)) return "Bad";
        }
        for (String goodWord: goodMoodWords) {
            if (message.contains(goodWord)) return "Good";
        }
        return "Normal";
    }
}