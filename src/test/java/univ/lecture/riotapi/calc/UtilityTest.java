package univ.lecture.riotapi.calc;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Assert;

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
        String[] nonOps = {"123", "3434", "asdasd"};

        for (String op : ops) {
            assertEquals(true, Operator.isOperator(op));
        }

        for (String op : nonOps) {
            assertEquals(false, Operator.isOperator(op));
        }
    }

    public void testIsNumber() {
        String num1 = "13";
        String num2 = "13.5";
        String nonNum = "asdasd";

        assertEquals(true, Utility.isNumber(num1));
        assertEquals(true, Utility.isNumber(num2));
        assertEquals(false, Utility.isNumber(nonNum));
    }


    public void testIsNumber2() {
        String num = "-13";

        assertTrue(Utility.isNumber(num));

    }

    public void testIsDeleteEquals() {
        String url1 = "s1d5v63ds1v23ds1sd23f=";
        String expectedUrl1 = "s1d5v63ds1v23ds1sd23f";
        String url2 = "sd123136vw156w5wefwef16%sfdv256s";
        String expectedUrl2 = "sd123136vw156w5wefwef16%sfdv256s";
        String url3 = "sdfsjdkfcdsnjkvnwros1d23wer=";
        String expectedUrl3 = "sdfsjdkfcdsnjkvnwros1d23wer";

        assertEquals(Utility.deleteUrlLastEqual(url1), expectedUrl1);
        assertEquals(Utility.deleteUrlLastEqual(url2), expectedUrl2);
        assertEquals(Utility.deleteUrlLastEqual(url3), expectedUrl3);
    }

    public void testTokenize() {
        CalcApp calcApp = new CalcApp();
        String[] str = {
                "1+2* 6",
                "( 1 + 2)*6",
                "(-1+2)*6",
                "(-1+2)*6.4"
        };

        String[][] tokens = {
                {"1", "+", "2", "*", "6"},
                {"(", "1", "+", "2", ")", "*", "6"},
                {"(", "-", "1", "+", "2", ")", "*", "6"},
                {"(", "-", "1", "+", "2", ")", "*", "6.4"}
        };


        Assert.assertArrayEquals(tokens[0], Utility.tokenize(str[0]));
        Assert.assertArrayEquals(tokens[1], Utility.tokenize(str[1]));
        Assert.assertArrayEquals(tokens[2], Utility.tokenize(str[2]));
        Assert.assertArrayEquals(tokens[3], Utility.tokenize(str[3]));


    }
}
