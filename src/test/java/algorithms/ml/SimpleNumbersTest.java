package algorithms.ml;

import algorithms.AbstractTest;
import org.junit.Assert;
import org.junit.Test;

public class SimpleNumbersTest extends AbstractTest{

    private void test(String inStr, String outStr) throws Exception {
        byte[] input = inStr.getBytes();
        SimpleNumbers.start(is(input), out());
        Assert.assertEquals(outStr, output.toString().trim());
    }

    @Test
    public void test1() throws Exception {
        test("75", "3 5 5");
    }

    @Test
    public void test2() throws Exception {
        test("541", "541");
    }
}