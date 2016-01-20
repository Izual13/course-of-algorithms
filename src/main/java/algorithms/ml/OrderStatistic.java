package algorithms.ml;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * K-порядковая статистика
 */
public class OrderStatistic {

    public static void main(String[] args) {
        start(System.in, System.out);
    }


    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);

        int n = in.nextInt();
        int[] integers = new int[n];
        for (int i = 0; i < n; i++) {
            integers[i] = in.nextInt();
        }

        int k = in.nextInt() - 1;

        out.println(getOrderStatistic(integers, k));


    }

    static int getOrderStatistic(int[] m, int k) {
        return getOrderStatistic(m, 0, m.length - 1, k);
    }

    static int getOrderStatistic(int[] m, int start, int end, int k) {
        if (start + 1 > end) {
            return m[k];
        }
        int pivot = m[end];
        int i = start;
        int j = end - 1;
        while (i <= j) {
            while (i < end && m[i] <= pivot) {
                i++;
            }
            while (j > start && m[j] >= pivot) {
                j--;
            }
            if (i <= j) {
                swap(m, i, j);
                i++;
            }
        }
        for (i = end; i - 1 > j; i--) {
            m[i] = m[i - 1];
        }
        m[i] = pivot;
        if (k == i) {
            return pivot;
        } else if (k < i) {
            return getOrderStatistic(m, start, j, k);
        } else {
            return getOrderStatistic(m, j + 1, end, k);
        }
    }


    static void swap(int[] m, int i, int j) {
        int tmp = m[i];
        m[i] = m[j];
        m[j] = tmp;
    }
}


