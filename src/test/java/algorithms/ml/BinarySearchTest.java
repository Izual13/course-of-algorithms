package algorithms.ml;

import algorithms.AbstractTest;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest extends AbstractTest {

    private void test(String inStr, String outStr) throws Exception {
        byte[] input = inStr.getBytes();
        BinarySearch.start(is(input), out());
        Assert.assertEquals(outStr, output.toString().trim());
    }



    @Test
    public void test1() throws Exception {
        test("3 10 20 30 3 9 15 35", "0 0 2");
    }

    @Test
    public void test2() throws Exception {
        test("4 1 3 20 21 1 19", "2");
    }

    @Test
    public void test3() throws Exception {
        test("4 10 20 30 40 1 35", "2");
    }

    @Test
    public void test4() throws Exception {
        test("10 1 2 3 50 60 70 80 90 100 110 1 59", "4");
    }

    @Test
    public void test5() throws Exception {
        test("11 0 10 20 30 40 50 60 70 80 90 100 103 -1 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101",
                "0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2 2 2 3 3 3 3 3 3 3 3 3 3 4 4 4 4 4 4 4 4 4 4 5 5 5 5 5 5 5 5 5 5 6 6 6 6 6 6 6 6 6 6 7 7 7 7 7 7 7 7 7 7 8 8 8 8 8 8 8 8 8 8 9 9 9 9 9 9 9 9 9 9 10 10 10 10 10 10");
    }


}