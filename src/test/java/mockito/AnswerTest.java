package mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.AbstractList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AnswerTest {

    interface SomeInterface {
        String doSomething(String param);
    }

    @Mock
    SomeInterface someInterface;

    @Test
    public void testThenAnswer() {
        when(someInterface.doSomething(anyString())).thenAnswer(invocation -> invocation.getArguments()[0]);

        assertEquals("someString", someInterface.doSomething("someString"));
        assertEquals("anotherString", someInterface.doSomething("anotherString"));
    }

    @Test
    public void testThenReturn() {
        doAnswer(returnsFirstArg())
               .when(someInterface)
               .doSomething(anyString());

        assertEquals("someString", someInterface.doSomething("someString"));
        assertEquals("anotherString", someInterface.doSomething("anotherString"));
    }

    @Test
    public void whenAddCalledAnswered() {
        MyList myList = mock(MyList.class);
        doAnswer(invocation -> {
            Object arg0 = invocation.getArgument(0);
            Object arg1 = invocation.getArgument(1);

            assertEquals(3, arg0);
            assertEquals("answer me", arg1);
            return null;
        }).when(myList).add(any(Integer.class), any(String.class));
        myList.add(3, "answer me");
    }

    public class MyList {

        public void add(int index, String element) {
            // no-op
        }
    }
}