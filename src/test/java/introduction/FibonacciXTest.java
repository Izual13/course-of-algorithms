package introduction;

import common.AbstractTest;
import org.junit.Assert;
import org.junit.Test;


public class FibonacciXTest  extends AbstractTest {


    @Test
    public void testStart() throws Exception {
        byte[] input = "16759108071127739 44408".getBytes();
        FibonacciX.start(is(input), out());
        Assert.assertEquals("22937", output.toString().trim());
    }
}