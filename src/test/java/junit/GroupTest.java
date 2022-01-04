package junit;

import junit.Address;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GroupTest {

    @Test
    void groupedAssertions() {
        Address address = new Address("John", "junit.User");
        assertAll("address name",
                () -> assertEquals("John", address.getFirstName()),
                () -> assertEquals("junit.User", address.getLastName())
        );
    }
}
