import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class Timeout {
    @Test
    void timeoutNotExceeded() {
        assertTimeout(ofMinutes(1), Service::requestService);
    }

    @Test
    void timeoutNotExceededWithResultStopImmediately() {
        Boolean actualResult = assertTimeoutPreemptively(ofSeconds(1), () -> Service.requestService());
        assertEquals(true, actualResult);
    }

    @Test
    void timeoutNotExceededWithResult() {
        Boolean actualResult = assertTimeout(ofSeconds(1), () -> Service.requestService());
        assertEquals(true, actualResult);
    }
}
