package algorithms.ml;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Пирамидальная сортировка
 */
public class OptimizeMergeSortPoints {


    public static void main(String[] args) {
        start(System.in, System.out);
    }


    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);
        int n = in.nextInt();
        Integer[] points = new Integer[n];
        for (int i = 0; i < n; i++) {
            points[i] = in.nextInt();
        }

        Comparable[] sort = sort(points);
        Arrays.asList(sort).forEach((x) -> out.print(x + " "));
    }


    private static Comparable[] sort(Comparable[] points) {
        int avg = points.length / 2;
        if (points.length > 1) {
            Comparable[] p1 = sort(Arrays.copyOfRange(points, 0, avg));
            Comparable[] p2 = sort(Arrays.copyOfRange(points, avg, points.length));
            return merge(p1, p2);
        } else {
            return points;
        }
    }


    private static <T extends Comparable<T>> Comparable[] merge(T[] p1, T[] p2) {
        Comparable[] points = new Comparable[p1.length + p2.length];
        int n = 0;
        int ip1 = 0;
        int ip2 = 0;
        while (ip1 != p1.length && ip2 != p2.length) {
            if (p1[ip1].compareTo(p2[ip2]) == -1) {
                points[n++] = p1[ip1++];
            } else {
                points[n++] = p2[ip2++];
            }
        }

        while (ip1 != p1.length) {
            points[n++] = p1[ip1++];
        }
        while (ip2 != p2.length) {
            points[n++] = p2[ip2++];
        }
        return points;
    }

}


