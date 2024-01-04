package seminars.third.tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoodAnalyserTest {

    private final MoodAnalyser moodAnalyser = new MoodAnalyser();

    @Test
    void moodTestGood() {
        assertEquals("Good", moodAnalyser.analyseMood("Сегодня был просто отличный день!"));
    }

    @Test
    void moodTestBad() {
        assertEquals("Bad", moodAnalyser.analyseMood("Он оказался плохим человеком"));
    }

    @Test
    void moodTestNormal() {
        assertEquals("Normal", moodAnalyser.analyseMood("Сегодня кодим по-тихоньку"));
    }
}
