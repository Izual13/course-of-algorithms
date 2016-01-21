package algorithms.ml;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Quick sort
 */
public class QuickSort {

    public static void main(String[] args) {
        start(System.in, System.out);
    }


    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);

        List<Integer> list = new ArrayList();
        while (in.hasNextInt()) {
            int i = in.nextInt();
            list.add(i);
        }

        Integer[] integers = list.toArray(new Integer[list.size()]);
        sortWithLast(integers);

        for (int i = 9; i <= integers.length; i += 10) {
            out.print(integers[i] + " ");
        }
    }

    static void sortWithLast(Integer[] values) {
        sortWithLast(values, 0, values.length - 1);
    }

    static void sortWithLast(Integer[] values, int start, int end) {
        if (start + 1 > end) {
            return;
        }
        int pivot = values[end];
        int i = start;
        int j = end - 1;
        while (i <= j) {
            while (i < end && values[i] <= pivot) {
                i++;
            }
            while (j > start && values[j] >= pivot) {
                j--;
            }

            if (i < j) {
                swap(values, i, j);
                i++;
            } else if (i == j) {
                if (values[i] <= pivot) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        for (i = end; i - 1 > j; i--) {
            values[i] = values[i - 1];
        }
        values[i] = pivot;
        sortWithLast(values, start, j);
        sortWithLast(values, j + 1, end);
    }


    private static void sortWithAvg(Integer[] values) {
        sortWithAvg(values, 0, values.length - 1);
    }

    private static void sortWithAvg(Integer[] values, int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (values[i] <= values[cur])) {
                i++;
            }
            while (j > cur && (values[cur] <= values[j])) {
                j--;
            }
            if (i < j) {
                swap(values, i, j);
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        sortWithAvg(values, start, cur);
        sortWithAvg(values, cur + 1, end);
    }

    static void swap(Integer[] values, int i, int j) {
        int tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
}


