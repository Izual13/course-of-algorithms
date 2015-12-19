package algorithms.introduction;

import algorithms.AbstractTest;
import org.junit.Assert;
import org.junit.Test;


public class FibonacciTest extends AbstractTest {

    @Test
    public void testMain() throws Exception {
        byte[] input = "10".getBytes();
        Fibonacci.start(is(input), out());
        Assert.assertEquals("55", output.toString().trim());

    }

}