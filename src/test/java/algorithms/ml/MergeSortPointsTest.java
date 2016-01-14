package algorithms.ml;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MergeSortPointsTest {

    private void test(String inStr, String outStr) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] input = inStr.getBytes();
        MergeSortPoints.start(new ByteArrayInputStream(input), new PrintStream(output));
        Assert.assertEquals(outStr, output.toString().trim().replaceAll("\r\n", " ").replaceAll("\n", " "));
    }

    @Test
    public void test1() throws Exception {
        test("3 1 4 7 8 2 5", "3");
    }
}