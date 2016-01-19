package algorithms.ml;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class QuickSortTest {

    private void test(String inStr, String outStr) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] input = inStr.getBytes();
        QuickSort.start(new ByteArrayInputStream(input), new PrintStream(output));
        Assert.assertEquals(outStr, output.toString().trim());
    }

    @Test
    public void test1() throws Exception {
        test("3 0 2 1 5 4 21 4 6 5 3 0 2 1 5 4 21 4 6 5", "4 21");
    }
}