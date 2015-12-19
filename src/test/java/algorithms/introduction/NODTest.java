package algorithms.introduction;

import algorithms.AbstractTest;
import org.junit.Assert;
import org.junit.Test;


public class NODTest extends AbstractTest {


    private void test(String inStr, String outStr) throws Exception {
        byte[] input = inStr.getBytes();
        NOD.start(is(input), out());
        Assert.assertEquals(outStr, output.toString().trim());
    }

    @Test
    public void testStart() throws Exception {
        test("18 35", "1");
    }

    @Test
    public void testStart2() throws Exception {
        test("14159572 63967072", "4");
    }

}