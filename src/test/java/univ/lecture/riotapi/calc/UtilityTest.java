package univ.lecture.riotapi.calc;

import groovy.transform.PackageScope;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Ignore;

import static univ.lecture.riotapi.calc.Utility.*;

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

    public void testIsOperator() {
        String[] ops = {"+", "-", "*", "/"};
        for (String op : ops) {
            assertTrue(isOperator(op));
        }
    }

    public void testIsNonOperator() {
        String[] nonOps = {"123", "3434", "asdasd"};

        for (String op : nonOps) {
            assertFalse(isOperator(op));
        }
    }

    // + and +-*/
    public void testIsHigherPrirortyGivenPlusAndPlus() {
        assertTrue(isHigherPrirorty("+", "+"));
    }

    public void testIsHigherPrirortyGivenPlusAndMinus() {
        assertTrue(isHigherPrirorty("+", "-"));
    }

    public void testIsHigherPrirortyGivenPlusAndMultiply() {
        assertFalse(isHigherPrirorty("+", "*"));
    }

    public void testIsHigherPrirortyGivenPlusAnddivide() {
        assertFalse(isHigherPrirorty("+", "/"));
    }

    // - and +-*/
    public void testIsHigherPrirortyGivenMinusAndPlus() {
        assertTrue(isHigherPrirorty("-", "+"));
    }

    public void testIsHigherPrirortyGivenMinusAndMinus() {
        assertTrue(isHigherPrirorty("-", "-"));
    }

    public void testIsHigherPrirortyGivenMinusAndMultiply() {
        assertFalse(isHigherPrirorty("-", "*"));
    }

    public void testIsHigherPrirortyGivenMinusAnddivide() {
        assertFalse(isHigherPrirorty("-", "/"));
    }

    // * and +-*/
    public void testIsHigherPrirortyGivenMultiplyAndPlus() {
        assertTrue(isHigherPrirorty("*", "+"));
    }

    public void testIsHigherPrirortyGivenMultiplyAndMinus() {
        assertTrue(isHigherPrirorty("*", "-"));
    }

    public void testIsHigherPrirortyGivenMultiplyAndMultiply() {
        assertTrue(isHigherPrirorty("*", "*"));
    }

    public void testIsHigherPrirortyGivenMultiplyAnddivide() {
        assertTrue(isHigherPrirorty("*", "/"));
    }

    // / and +-*/
    public void testIsHigherPrirortyGivenDivideAndPlus() {
        assertTrue(isHigherPrirorty("/", "+"));
    }

    public void testIsHigherPrirortyGivenDivideAndMinus() {
        assertTrue(isHigherPrirorty("/", "-"));
    }

    public void testIsHigherPrirortyGivenDivideAndMultiply() {
        assertTrue(isHigherPrirorty("/", "*"));
    }

    public void testIsHigherPrirortyGivenDivideAnddivide() {
        assertTrue(isHigherPrirorty("/", "/"));
    }

    public void testIsNumber() {
        String num1 = "13";
        String num2 = "13.5";
        String nonNum = "asdasd";

        assertEquals(true, isNumber(num1));
        assertEquals(true, isNumber(num2));
        assertEquals(false, isNumber(nonNum));
    }

    public void testIsNumberGivenInteger() {
        String num = "13";
        assertTrue(isNumber(num));
    }

    public void testIsNumberGivenRealnumber() {
        String num = "3.14";
        assertTrue(isNumber(num));
    }

    public void testIsNumberGivenNonNumber() {
        String nonNum = "Hello123";
        assertFalse(isNumber(nonNum));
    }

    public void testIsDeleteEqualsGivenEqualURL() {
        String url = "s1d5v63ds1v23ds1sd23f=";
        String expectedUrl = "s1d5v63ds1v23ds1sd23f";
        assertEquals(deleteUrlLastEqual(url), expectedUrl);
    }

    public void testIsDeleteEqualsGivenNoNEqualURL() {
        String url = "s1d5v63ds1v23ds1sd23f";
        String expectedUrl = "s1d5v63ds1v23ds1sd23f";
        assertEquals(deleteUrlLastEqual(url), expectedUrl);
    }
}
