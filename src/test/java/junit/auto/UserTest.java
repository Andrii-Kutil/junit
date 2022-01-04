package junit.auto;

import static org.junit.jupiter.api.Assertions.assertThrows;

import junit.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {

  @Test
  void testSetAge() throws IllegalArgumentException {
    assertThrows(IllegalArgumentException.class, () -> (new User()).setAge("Age"));
  }

  @Test
  void testSetAge2() throws IllegalArgumentException {
    User user = new User();
    user.setAge(0);
    Assertions.assertEquals(0, user.getAge());
  }

  @Test
  void testConstructor() {
    Assertions.assertEquals(0, (new User()).getAge());
  }
}

