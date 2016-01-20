package algorithms.ml;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Created by izual on 20.01.2016.
 */
public class OrderStatisticTest {

    private void test(String inStr, String outStr) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] input = inStr.getBytes();
        OrderStatistic.start(new ByteArrayInputStream(input), new PrintStream(output));
        Assert.assertEquals(outStr, output.toString().trim());
    }

    @Test
    public void test1() throws Exception {
        test("10 3 0 2 1 5 4 21 4 6 5 10", "21");
        test("10 3 0 2 1 5 4 21 4 6 5 9", "6");
        test("10 3 0 2 1 5 4 21 4 6 5 8", "5");
        test("10 3 0 2 1 5 4 21 4 6 5 7", "5");
        test("10 3 0 2 1 5 4 21 4 6 5 6", "4");
        test("10 3 0 2 1 5 4 21 4 6 5 5", "4");
    }

}