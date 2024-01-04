package seminars.third.coverage;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class SomeServiceTest {
    private final SomeService service = new SomeService();

    @Test
    void testFizzBuzzWhenMultipleThree() {
        assertEquals("Fizz", service.fizzBuzz(9));
    }

    @Test
    void testFizzBuzzWhenMultipleFive() {
        assertEquals("Buzz", service.fizzBuzz(10));
    }

    @Test
    void testFizzBuzzWhenMultipleThreeAndFive() {
        assertEquals("FizzBuzz", service.fizzBuzz(15));
    }

    @Test
    void testFizzBuzzWhenNotMultipleEitherThreeAndFive() {
        assertEquals("13", service.fizzBuzz(13));
    }

    @Test
    void testFirstLastSixIfFirstIsSix() {
        assertTrue(service.firstLast6(new int[]{6, 5, 3, 5, 2, 3}));
    }

    @Test
    void testFirstLastSixIfLastIsSix() {
        assertTrue(service.firstLast6(new int[]{0, 3, 4, 12, 5, 6}));
    }

    @Test
    void testFirstLastSixIfNeitherFirstLastSix() {
        assertFalse(service.firstLast6(new int[]{5, 6, 6, 6, 7}));
    }

    @Test
    void testCalculatingDiscountPositive1() {
        assertEquals(20, service.calculatingDiscount(100, 80));
    }

    @Test
    void testCalculatingDiscountPositive2() {
        assertEquals(100, service.calculatingDiscount(100, 0));
    }

    @Test
    void testCalculatingDiscountNegativePurchaseAmount() {
        assertThatThrownBy(() -> service.calculatingDiscount(-100, 80)).isInstanceOf(ArithmeticException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 101})
    void testCalculatingDiscountNegativeDiscountAmount(int value) {
        assertThatThrownBy(() -> service.calculatingDiscount(-100, value)).isInstanceOf(ArithmeticException.class);
    }

    @Test
    void testLuckySumWhenThereIsNo13() {
        assertEquals(36, service.luckySum(10, 12, 14));
    }

    @Test
    void testLuckySumWhenThereIs13() {
        assertEquals(23, service.luckySum(11, 12, 13));
    }
}