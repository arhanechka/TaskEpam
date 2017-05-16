package ua.kpi.training;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import ua.kpi.training.controller.services.RegExExpressions;

/**
 * Created by Anya on 16.05.2017.
 */
public class RegExTestPhoneNumbers {
    static String[] stringsForTest;
    static String one;
    static String two;
    static String three;
    static String four;
    static String five;
    static String six;
    static String seven;

    @BeforeClass
    public static void setArray() {
        stringsForTest = TestConstants.PHONE_NUMBERS_FOR_TESTING.split(" ");
        one = stringsForTest[0];
        two = stringsForTest[1];
        three = stringsForTest[2];
        four = stringsForTest[3];
        five = stringsForTest[4];
        six = stringsForTest[5];
        seven = stringsForTest[6];
    }

    @Test
    public void nickNameAssertOne() {

        Assert.assertTrue(one, one.matches(RegExExpressions.PHONE_REGEX));

    }

    @Test
    public void nickNameAssertTwo() {
        Assert.assertTrue(two, two.matches(RegExExpressions.PHONE_REGEX));
    }

    @Test
    public void nickNameAsserThree() {
        Assert.assertTrue(three, three.matches(RegExExpressions.PHONE_REGEX));

    }

    @Test
    public void nickNameAssertFour() {
        Assert.assertTrue(four, four.matches(RegExExpressions.PHONE_REGEX));

    }

    @Test
    public void nickNameAssertFive() {
        Assert.assertTrue(five, five.matches(RegExExpressions.PHONE_REGEX));
    }

    @Test
    public void nickNameAssertSix() {
        Assert.assertTrue(six, six.matches(RegExExpressions.PHONE_REGEX));
    }

    @Test
    public void nickNameAssertSeven() {
        Assert.assertTrue(seven, seven.matches(RegExExpressions.PHONE_REGEX));

    }
}


