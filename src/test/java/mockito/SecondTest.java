package mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class SecondTest {

  @Mock
  Database databaseMock;

  @Test
  void ensureMockitoReturnsTheConfiguredValue() {
    when(databaseMock.getUniqueId()).thenReturn(46);
    Service service = new Service(databaseMock);
    assertEquals(service.toString(), "Using database with id: 46");
  }

}