package junit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import junit.Calculator;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class DisableTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() throws Exception {
        calculator = new Calculator();
    }

    @RepeatedTest(5)
    @DisplayName("Ensure correct handling of zero")
    void testMultiplyWithZeroAssume() {
        Assumptions.assumeFalse(System.getProperty("os.name").contains("Linux"));

        assertEquals(calculator.multiply(0,5), 0, "Multiple with zero should be zero");
        assertEquals(calculator.multiply(5,0), 0, "Multiple with zero should be zero");
    }

    @Disabled("Why disabled")
    void testMultiplyWithZeroDisable() {
        Assumptions.assumeFalse(System.getProperty("os.name").contains("Linux"));

        assertEquals(calculator.multiply(0,5), 0, "Multiple with zero should be zero");
        assertEquals(calculator.multiply(5,0), 0, "Multiple with zero should be zero");
    }
}