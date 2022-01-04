import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    User user;

    @BeforeEach
    void setUp() {
        user = new User();
    }

    @Test
    void exceptionTesting() {
        // set up user
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> user.setAge("23"));
        assertEquals("Age must be an Integer.", exception.getMessage());
    }
}