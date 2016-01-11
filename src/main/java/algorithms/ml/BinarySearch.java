package algorithms.ml;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.abs;

/**
 * бинарный поиск
 */
public class BinarySearch {


    public static void main(String[] args) {
       start(System.in, System.out);
    }

    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);
        int n = in.nextInt();
        int a[] = new int[n];
        fillArray(in, a);

        final int bn = in.nextInt();
        int b[] = new int[bn];
        fillArray(in, b);

        Arrays.stream(b).forEach((x) -> {
            int search = search(a, x);
            out.print(search + " ");
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

            if (abs(m[s0] - n) <= abs(m[start] - n)&& start != s0) {
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
