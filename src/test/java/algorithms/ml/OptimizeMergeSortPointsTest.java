package algorithms.ml;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class OptimizeMergeSortPointsTest {

    private void test(String inStr, String outStr) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] input = inStr.getBytes();
        OptimizeMergeSortPoints.start(new ByteArrayInputStream(input), new PrintStream(output));
        Assert.assertEquals(outStr, output.toString().trim().replaceAll("\r\n", " ").replaceAll("\n", " "));
    }

    @Test
    public void test1() throws Exception {
        test("20 3 4 1 2 0 9 7 8 6 5 11 12 13 10 14 18 19 16 17 15 10", "0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19");
    }

}