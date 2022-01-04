package junit.auto;

import static org.junit.jupiter.api.Assertions.assertNull;

import junit.Address;
import org.junit.jupiter.api.Test;

class AddressTest {

  @Test
  void testConstructor() {
    Address actualAddress = new Address();
    assertNull(actualAddress.getFirstName());
    assertNull(actualAddress.getLastName());
  }
}

