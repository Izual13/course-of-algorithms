package algorithms.ml;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class StackForBracketsTest {


    private void test(String inStr, String outStr) throws Exception {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] input = inStr.getBytes();
        StackForBrackets.start(new ByteArrayInputStream(input), new PrintStream(output));
        Assert.assertEquals(outStr, output.toString().trim());
    }

    @Test
    public void test1() throws Exception {
        test(")]", "[()]");
        test("([", "([])");
        test("([]", "([])");
        test("]}[{]}{[(", "IMPOSSIBLE");
        test("([])", "([])");
        test("[{()}]]", "[[{()}]]");
        test(")[", "()[]");
        test("((])", "IMPOSSIBLE");
        test("(({)", "IMPOSSIBLE");
        test(")[(()", "()[(())]");
        test(")[(()[]", "()[(()[])]");
        test("()]", "[()]");
        test("}[[([{[]}", "{}[[([{[]}])]]");
        test("{][[[[{}[]", "IMPOSSIBLE");
        test("]()}[](({}", "{[]()}[](({}))");
    }


}