package univ.lecture.riotapi.calc;

/**
 * Created by corona10 on 2017. 4. 5..
 */

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Created by corona10 on 2017. 4. 5..
 */
public class OperatorTest extends TestCase {
    public OperatorTest(String testName) {
        super(testName);
    }

    public static Test suite() {
        return new TestSuite(OperatorTest.class);
    }

    public void testOperatorException() {
        boolean failed = false;

        Operator op = Operator.findOperator("abcd");
        assertNull(op);

    }

    public void testOperatorEvaluate1() {
        Operator op = Operator.findOperator("+");
        double result = op.evaluate(1, 1);
        assertEquals(2.0, result);
    }

    public void testOperatorEvaluate2() {
        Operator op = Operator.findOperator("*");
        double result = op.evaluate(3, 4);
        assertEquals(12.0, result);
    }

    public void testOperatorEvaluate3() {
        Operator op = Operator.findOperator("/");
        double result = op.evaluate(8, 4);
        assertEquals(2.0, result);
    }

    public void testOperatorEvaluate4() {
        Operator op = Operator.findOperator("-");
        double result = op.evaluate(8, 4);
        assertEquals(4.0, result);
    }

    public void testCompareTo() {
        Operator op = Operator.ADD;
        int c = op.compareTo("*");
        assertTrue(c < 0);
    }

    public void testCompareTo2() {
        Operator op = Operator.ADD;
        int c = op.compareTo("-");
        assertTrue(c == 0);
    }

    public void testCompareTo3() {
        Operator op = Operator.DIV;
        int c = op.compareTo("+");
        assertTrue(c > 0);
    }
}
