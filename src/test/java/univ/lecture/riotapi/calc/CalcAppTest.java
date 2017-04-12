package univ.lecture.riotapi.calc;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple CalcApp.
 */
public class CalcAppTest
        extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public CalcAppTest(String testName) {
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite() {
        return new TestSuite(CalcAppTest.class);
    }

    /**
     * Rigourous Test :-)
     */
    public void testCalc1() {
        CalcApp cal = new CalcApp();
        String[] target = {"13", "+", "5"};
        double result = cal.calc(target);
        double expected = 18.0;
        assertEquals(expected, result);
    }

    public void testCalc2() {
        CalcApp cal = new CalcApp();
        String[] target = {"13", "+", "5", "*", "2"};
        double result = cal.calc(target);
        double expected = 23.0;
        assertEquals(expected, result);
    }

    public void testCalc3() {
        CalcApp cal = new CalcApp();
        String[] target = {"(", "13", "+", "5", ")", "*", "2"};
        double result = cal.calc(target);
        double expected = 36.0;
        assertEquals(expected, result);
    }

    public void testCalc4() {
        CalcApp cal = new CalcApp();
        String[] target = {"13", "*", "5", "+", "8", "+", "2"};
        double result = cal.calc(target);
        double expected = 75.0;
        assertEquals(expected, result);
    }

    public void testCalc5() {
        CalcApp cal = new CalcApp();
        String[] target = {"13", "*", "5", "+", "8", "/", "2", "+", "124.5"};
        double result = cal.calc(target);
        double expected = 193.5;
        assertEquals(expected, result);
    }

    public void testCalc6() {
        CalcApp cal = new CalcApp();
        String[] target = {"13", "*", "5", "+", "8", "/", "2", "-", "124.5"};
        double result = cal.calc(target);
        double expected = -55.5;
        assertEquals(expected, result);
    }

//    public void testCalc7() {
//        CalcApp cal = new CalcApp();
//        String[] target = {"-", "1"};
//        double result = cal.calc(target);
//        double expected = -1;
//        assertEquals(expected, result);
//    }
//
//    public void testCalc8() {
//        CalcApp cal = new CalcApp();
//        String[] target = {"2", "+", "-", "1"};
//        double result = cal.calc(target);
//        double expected = 1;
//        assertEquals(expected, result);
//    }

}
