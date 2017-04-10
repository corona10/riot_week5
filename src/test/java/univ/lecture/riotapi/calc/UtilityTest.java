package univ.lecture.riotapi.calc;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by corona10 on 2017. 4. 5..
 */
public class UtilityTest extends TestCase {
    public UtilityTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(UtilityTest.class);
    }

    public void testIsOperator(){
        String[] ops = {"+", "-", "*", "/"};
        String[] nonOps = {"123", "3434", "asdasd"};

        for (String op : ops)
        {
            assertEquals(true, Utility.isOperator(op));
        }

        for (String op : nonOps)
        {
            assertEquals(false, Utility.isOperator(op));
        }
    }

    public void testIsHigherPrirorty() {
        assertEquals(true, Utility.isHigherPrirorty("*", "+"));
        assertEquals(true, Utility.isHigherPrirorty("/", "+"));
        assertEquals(false, Utility.isHigherPrirorty("+", "*"));
        assertEquals(false, Utility.isHigherPrirorty("-", "*"));
        assertEquals(false, Utility.isHigherPrirorty("*", "*"));
        assertEquals(true, Utility.isHigherPrirorty("+", "+"));
    }

    public void testIsNumber() {
        String num1 = "13";
        String num2 = "13.5";
        String nonNum = "asdasd";

        assertEquals(true, Utility.isNumber(num1));
        assertEquals(true, Utility.isNumber(num2));
        assertEquals(false, Utility.isNumber(nonNum));
    }
}
