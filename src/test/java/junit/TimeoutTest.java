package junit;

import junit.Service;
import org.junit.jupiter.api.Test;

import static java.time.Duration.ofMinutes;
import static java.time.Duration.ofSeconds;
import static org.junit.jupiter.api.Assertions.*;

public class TimeoutTest {
    @Test
    void timeoutNotExceeded() {
        assertTimeout(ofMinutes(1), Service::requestService);
    }

    @Test
    void timeoutNotExceededWithResultStopImmediately() {
        Boolean actualResult = assertTimeoutPreemptively(ofSeconds(5), () -> Service.requestService());
        assertEquals(true, actualResult);
    }

    @Test
    void timeoutNotExceededWithResult() {
        Boolean actualResult = assertTimeout(ofSeconds(5), () -> Service.requestService());
        assertEquals(true, actualResult);
    }
}
