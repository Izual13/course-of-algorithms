package algorithms.ml;

import algorithms.AbstractTest;
import org.junit.Assert;
import org.junit.Test;


public class SearchMaxIndexesTest extends AbstractTest {

    private void test(String inStr, String outStr) throws Exception {
        byte[] input = inStr.getBytes();
        SearchMaxIndexes.start(is(input), out());
        Assert.assertEquals(outStr, output.toString().trim());
    }

    @Test
    public void test1() throws Exception {
        test("4 4 -8 6 0 -10 3 1 1", "0 1");
    }

    @Test
    public void test2() throws Exception {
        test("7 1 1 1 7 1 10 1 1 1 10 1 7 1 1", "3 4");
    }
    @Test
    public void test3() throws Exception {
        test("3 0 10 20 40 0 30", "2 2");
    }

}