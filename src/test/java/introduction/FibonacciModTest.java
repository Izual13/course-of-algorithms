package introduction;

import common.AbstractTest;
import org.junit.Assert;
import org.junit.Test;

public class FibonacciModTest extends AbstractTest {

    @Test
    public void testMain() throws Exception {
        byte[] input = "560233".getBytes();
        FibonacciMod.start(is(input), out());
        Assert.assertEquals("3", output.toString().trim());
    }
}