package testing;

import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;


public class StringCalculatorTest {

    @Test
    public void testAdd() {
        StringCalculator simpleCalculator = new StringCalculator();
        assertEquals(0, simpleCalculator.add(""));
        assertEquals(1, simpleCalculator.add("1"));
        assertEquals(2, simpleCalculator.add("2"));
    }

}

