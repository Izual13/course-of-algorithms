package algorithms.ml;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class DequeueTest {
    private void test(String inStr, String outStr) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] input = inStr.getBytes();
        Dequeue.start(new ByteArrayInputStream(input), new PrintStream(output));
        Assert.assertEquals(outStr, output.toString().trim());
    }

    @Test
    public void test1() throws Exception {
        test("5 1 44 3 50 2 44 2 50 2 -1", "YES");
    }
}