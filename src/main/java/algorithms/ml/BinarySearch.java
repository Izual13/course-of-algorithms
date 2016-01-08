package algorithms.ml;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * поиск простых чисел
 * генерация решета эратосфена
 */
public class BinarySearch {


    public static void main(String[] args) {
        String s = "3 10 20 30 3 9 15 35"; //0 0 2
        start(new ByteArrayInputStream(s.getBytes()), System.out);
        System.out.println();
        s = "4 1 3 20 21 1 19"; // 2
        start(new ByteArrayInputStream(s.getBytes()), System.out);
        System.out.println();
        s = "4 10 20 30 40 1 35"; //2
        start(new ByteArrayInputStream(s.getBytes()), System.out);
        System.out.println();
        s = "10 1 2 3 50 60 70 80 90 100 110 1 59"; //4
        start(new ByteArrayInputStream(s.getBytes()), System.out);
        System.out.println();
        s = "11 0 10 20 30 40 50 60 70 80 90 100 103 -1 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31 32 33 34 35 36 37 38 39 40 41 42 43 44 45 46 47 48 49 50 51 52 53 54 55 56 57 58 59 60 61 62 63 64 65 66 67 68 69 70 71 72 73 74 75 76 77 78 79 80 81 82 83 84 85 86 87 88 89 90 91 92 93 94 95 96 97 98 99 100 101";
        start(new ByteArrayInputStream(s.getBytes()), System.out);
    }

    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);
        int n = in.nextInt();
        int a[] = new int[n];
        fillArray(in, a);

        final int bn = in.nextInt();
        int b[] = new int[bn];
        fillArray(in, b);


//        out.println(Arrays.toString(a));
//        out.println(Arrays.toString(b));
//        out.println();
        Arrays.stream(b).forEach((x) -> {
            int search = search(a, x);
            out.print(search+" ");
//            out.println(x + ": " + search);
        });


    }

    private static int search(int[] m, int n) {
        return search(m, n, 0, m.length - 1);
    }

    private static int search(int[] m, int n, int start, int end) {

        if (start >= end) {
            int s0 = 0;
            int s2 = start;
            if (start != 0) {
                s0 = start - 1;
            }

            if (start != m.length - 1) {
                s2 = start + 1;
            }

            if (abs(m[s0] - n) <= abs(m[start] - n)) {
                return s0;
            }

            if (abs(m[s2] - n) < abs(m[start] - n)) {
                return s2;
            }
            return start;
        }
        int avg = start / 2 + end / 2;
        if (m[avg] == n) {
            return avg;
        } else if (m[avg] > n) {
            return search(m, n, start, avg - 1);
        } else {
            return search(m, n, avg + 1, end);
        }

    }

    static void fillArray(Scanner in, int[] m) {
        for (int i = 0; i < m.length; i++) {
            m[i] = in.nextInt();
        }
    }
}
