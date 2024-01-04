package seminars.third.hw;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainHWTest {
    private final MainHW mainHW = new MainHW();

    @ParameterizedTest
    @ValueSource(ints = {0, 2, 6, 24, 56, -66})
    void evenOddNumberPositive(int number) {
        assertTrue(mainHW.evenOddNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 5, 43, 55})
    void evenOddNumberNegative(int number) {
        assertFalse(mainHW.evenOddNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {26, 99, 50})
    void isNumberBetween25to100Positive(int number) {
        assertTrue(mainHW.isNumberBetween25to100(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 0, 100})
    void isNumberBetween25to100Negative(int number) {
        assertFalse(mainHW.isNumberBetween25to100(number));
    }
}