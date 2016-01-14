package algorithms.ml;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Пирамидальная сортировка
 */
public class MergeSort {


    public static void main(String[] args) {
        start(System.in, System.out);
    }

    private static int length = 0;
    private static int size = 0;
    private static int[] m = new int[size];




    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);
        int n = in.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            points[i] = new Point(x, y);
        }

        Point[] sort = sort(points);
        Arrays.asList(sort).stream().forEach(out::println);

    }

    private static Point[] sort(Point[] points) {
        int avg = points.length / 2;
        if (points.length > 1) {
            Point[] p1 = sort(Arrays.copyOfRange(points, 0, avg));
            Point[] p2 = sort(Arrays.copyOfRange(points, avg, points.length));
            return merge(p1, p2);
        } else {
            return points;
        }
    }


    private static Point[] merge(Point[] p1, Point[] p2) {
        Point[] points = new Point[p1.length + p2.length];
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


    private static class Point implements Comparable {
        private int x;
        private int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return x + " " + y;
        }

        @Override
        public int compareTo(Object o) {
            Point p = (Point) o;
            return x < p.x ? -1 : x > p.x ? 1 : y < p.y ? -1 : y > p.y ? 1 : 0;
        }


    }

}
