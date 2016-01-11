package algorithms.ml;

import algorithms.AbstractTest;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest extends AbstractTest {

    private void test(String inStr, String outStr) throws Exception {
        byte[] input = inStr.getBytes();
        BinarySearch.start(is(input), out());
        Assert.assertEquals(outStr, output.toString().trim());
    }



    @Test
    public void test1() throws Exception {
        test("3 10 20 30 3 9 15 35", "0 0 2");
    }

    @Test
    public void test2() throws Exception {
        test("4 1 3 20 21 1 19", "2");
    }

    @Test
    public void test3() throws Exception {
        test("4 10 20 30 40 1 35", "2");
    }

    @Test
    public void test4() throws Exception {
        test("10 1 2 3 50 60 70 80 90 100 110 1 59", "4");
    }

    @Test
    public void test5() throws Exception {
        test("5 0 10 20 30 40 10 10 11 12 13 14 15 16 17 18 19 20",
                "1 1 1 1 1 1 2 2 2 2");
    }


}