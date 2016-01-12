package algorithms.ml;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BinaryHeapTest {


    private void test(String inStr, String outStr) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] input = inStr.getBytes();
        BinaryHeap.start(new ByteArrayInputStream(input), new PrintStream(output));
        Assert.assertEquals(outStr, output.toString().trim());
    }

    @Test
    public void test1() throws Exception {
        test("3 1 2 2 2", "4");
        test("12 1 4 8 9 10 40 45 50 60 70 80 100 100", "13");
        test("7 1 3 5 7 9 11 13 25", "5");
        test("10 1 1 1 1 1 1 1 1 1 10 11", "4");
        test("2 4 1 6", "3");
        test("7 1 1 1 1 1 1 1 3", "3");
        test("3 4 3 5 6", "5");
        test("10 1 2 3 4 5 6 7 8 9 10 12", "10");

    }
}