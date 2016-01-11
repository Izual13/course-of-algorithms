package algorithms.ml;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * очередь с приоритетом
 */
public class BinaryHeap {


    public static void main(String[] args) {
//        String s = "3 1 2 2 2";
        String s = "3 4 3 5 6";
        start(new BufferedInputStream(new ByteArrayInputStream(s.getBytes())), System.out);
    }

    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);
        int n = in.nextInt();
        int a[] = new int[n];
        fillArray(in, a);
        int m = in.nextInt();
        buildHeap(a);


        int i = 0;
        while (a.length > 0) {
            int sum = 0;
            while (a.length > 0 && sum + a[0] <= m) {
                sum += a[0];
                if (a[0] == 1) {
                    a[0] = a[a.length - 1];
                    if (a.length > 0) {
                        a = Arrays.copyOf(a, a.length - 1);
                    }

                    siftDown(a, 0);
                } else {
                    int tmp = a[0] / 2;
                    a[0] = a[a.length - 1];
                    if (a.length > 0) {
                        a = Arrays.copyOf(a, a.length);
                    }
                    siftDown(a, 0);
                    a[a.length - 1] = tmp;
                    siftUp(a, a.length - 1);
                }

            }
            i++;
        }

        System.out.println(i);

    }

    static void fillArray(Scanner in, int[] m) {
        for (int i = 0; i < m.length; i++) {
            m[i] = in.nextInt();
        }
    }

    static void buildHeap(int m[]) {
        for (int i = m.length / 2 - 1; i >= 0; i--) {
            siftDown(m, i);
        }
    }

    private static void siftDown(int[] m, int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < m.length && m[left] > m[i]) {
            largest = left;
        }
        if (right < m.length && m[right] > m[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(m, i, largest);
            siftDown(m, largest);
        }
    }

    private static void swap(int[] m, int i, int largest) {
        int tmp = m[i];
        m[i] = m[largest];
        m[largest] = tmp;
    }

    private static void siftUp(int m[], int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (m[index] <= m[parent]) {
                return;
            }
            swap(m, index, parent);
            index = parent;
        }
    }

}
