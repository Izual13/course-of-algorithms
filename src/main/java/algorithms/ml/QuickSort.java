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
        sort(integers);

        for (int i = 9; i <= integers.length; i += 10) {
            out.print(integers[i] + " ");
        }
    }

    static void sort(Integer[] integers) {
        sort(integers, 0, integers.length - 1);
    }

    static void sort(Integer[] values, int start, int end) {
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

            if (i <= j) {
                swap(values, i, j);
                i++;
            }
        }
        for (i = end; i - 1 > j; i--) {
            values[i] = values[i - 1];
        }
        values[i] = pivot;
        sort(values, start, j);
        sort(values, j + 1, end);
    }


    static void swap(Integer[] values, int i, int j) {
        int tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }
}


