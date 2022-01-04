package junit.auto;


import junit.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalculatorTest {

  @Test
  void testMultiply() {
    Assertions.assertEquals(1, (new Calculator()).multiply(1, 1));
    Assertions.assertEquals(0, (new Calculator()).multiply(0, 1));
    Assertions.assertEquals(3, (new Calculator()).multiply(3, 1));
    Assertions.assertEquals(-1, (new Calculator()).multiply(-1, 1));
  }
}

