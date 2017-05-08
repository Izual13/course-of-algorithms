package algorithms.cs;

import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;


public class ProcessingNetworkPackagesTest {
    @Test
    public void calc() {
        assertEquals("", ProcessingNetworkPackages.builder().calc(new ByteArrayInputStream("1 0".getBytes())));
        assertEquals("0\n", ProcessingNetworkPackages.builder().calc(new ByteArrayInputStream("1 1 0 0".getBytes())));
        assertEquals("0\n1\n", ProcessingNetworkPackages.builder().calc(new ByteArrayInputStream("1 2 0 1 1 1".getBytes())));
        assertEquals("0\n-1\n", ProcessingNetworkPackages.builder().calc(new ByteArrayInputStream("1 2 0 1 0 1".getBytes())));
        assertEquals("0\n0\n0\n1\n1\n1\n2\n-1\n", ProcessingNetworkPackages.builder().calc(new ByteArrayInputStream("2 8 0 0 0 0 0 0 1 0 1 0 1 1 1 2 1 3".getBytes())));
        assertEquals("0\n0\n0\n1\n2\n-1\n-1\n-1\n", ProcessingNetworkPackages.builder().calc(new ByteArrayInputStream("2 8 0 0 0 0 0 0 1 1 1 0 1 0 1 2 1 3".getBytes())));
        assertEquals("999999\n1000000\n1000000\n-1\n-1\n", ProcessingNetworkPackages.builder().calc(new ByteArrayInputStream("1 5 999999 1 1000000 0 1000000 1 1000000 0 1000000 0".getBytes())));
        assertEquals("0\n2\n2\n3\n4\n5\n", ProcessingNetworkPackages.builder().calc(new ByteArrayInputStream("2 6 0 2 0 0 2 0 3 0 4 0 5 0".getBytes())));
        assertEquals("0\n21\n56\n68\n81\n92\n106\n155\n188\n-1\n231\n245\n290\n-1\n-1\n328\n-1\n-1\n-1\n-1\n-1\n-1\n-1\n-1\n-1\n", ProcessingNetworkPackages.builder().calc(new ByteArrayInputStream("7 25 0 21 10 35 10 12 21 13 35 11 35 14 51 49 59 33 59 43 67 42 80 14 93 45 93 38 100 8 101 31 108 46 123 22 127 20 139 7 142 43 142 12 142 25 154 25 154 5 154 42".getBytes())));
        assertEquals("15\n-1\n39\n-1\n-1\n-1\n-1\n-1\n-1\n-1\n-1\n-1\n-1\n84\n-1\n-1\n-1\n-1\n-1\n-1\n-1\n142\n-1\n-1\n-1\n", ProcessingNetworkPackages.builder().calc(new ByteArrayInputStream("1 25 15 23 24 44 39 43 48 15 56 6 56 8 56 29 56 28 56 4 56 17 68 44 75 22 75 34 84 46 84 21 84 25 97 31 105 34 105 43 117 17 129 12 142 47 144 22 144 18 152 9".getBytes())));
    }
}