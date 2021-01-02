import listeners.HelloEvent;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RunWith(JUnit4.class)
public class HelloEventTest {

    static Logger LOGGER = LoggerFactory.getLogger(HelloEventTest.class);

    HelloEvent testSubect;

    @Before
    public void before() {
        testSubect = new HelloEvent();
    }

    @Test
    public void messageContainsKeywordTest() {
        //given an input message
        String testMessage = "yo !lonerbot do this";

        //when fed this array and processed
        boolean result = testSubect.messageContainsKeyword(testMessage);

        //then - make sure it returns true

        assert (result);
    }

    @Test
    public void messageContainsKeywordTestWithPeriodAtEnd() {
        //given an input message
        String testMessage = "yo !lonerbot. do this";

        //when fed this array and processed
        boolean result = testSubect.messageContainsKeyword(testMessage);

        //then - make sure it returns true
        assert (result);
    }

    @Test
    public void shouldFailBecauseNoExclamationPoint() {
        //given an input message
        String testMessage = "yo lonerbot. do this";

        //when fed this array and processed
        boolean result = testSubect.messageContainsKeyword(testMessage);

        //then - make sure it returns true
        assert (!result);
    }
}
