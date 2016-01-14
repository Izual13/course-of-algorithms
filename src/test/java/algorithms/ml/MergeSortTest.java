package algorithms.ml;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MergeSortTest {

    private void test(String inStr, String outStr) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] input = inStr.getBytes();
        MergeSort.start(new ByteArrayInputStream(input), new PrintStream(output));
        Assert.assertEquals(outStr, output.toString().trim().replaceAll("\r\n", " ").replaceAll("\n", " "));
    }

    @Test
    public void test1() throws Exception {
        test("4 0 0 1 1 1 0 0 1", "0 0 0 1 1 0 1 1");
    }
}