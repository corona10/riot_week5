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

    public void testIsDeleteEquals(){
        String url1 = "s1d5v63ds1v23ds1sd23f=";
        String expectedUrl1 = "s1d5v63ds1v23ds1sd23f";
        String url2 = "sd123136vw156w5wefwef16%sfdv256s";
        String expectedUrl2 = "sd123136vw156w5wefwef16%sfdv256s";
        String url3 = "sdfsjdkfcdsnjkvnwros1d23wer=";
        String expectedUrl3 = "sdfsjdkfcdsnjkvnwros1d23wer";

        assertEquals(Utility.deleteUrlLastEqual(url1),expectedUrl1);
        assertEquals(Utility.deleteUrlLastEqual(url2),expectedUrl2);
        assertEquals(Utility.deleteUrlLastEqual(url3),expectedUrl3);
    }
}
