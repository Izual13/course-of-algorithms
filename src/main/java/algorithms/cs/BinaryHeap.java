package algorithms.cs;

import java.io.InputStream;
import java.util.Scanner;

public class BinaryHeap {


    public static void main(String[] args) {
        System.out.println(calc(System.in));
    }

    public static String calc(InputStream is) {
        Scanner in = new Scanner(is);
        int n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        return buildHeap(a);
    }


    private static String buildHeap(int m[]) {
        StringBuilder value = new StringBuilder();
        int count = 0;
        for (int i = m.length / 2 - 1; i >= 0; i--) {
            count += siftDown(m, i, value);
        }
        return value.insert(0, count + "\n").toString().trim();
    }

    private static int siftDown(int[] m, int i, StringBuilder value) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        int count = 0;
        if (left < m.length && m[left] < m[i]) {
            smallest = left;
        }
        if (right < m.length && m[right] < m[smallest]) {
            smallest = right;
        }
        if (smallest != i) {
            swap(m, i, smallest);
            value.append(i).append(" ").append(smallest).append("\n");
            count += siftDown(m, smallest, value) + 1;
        }
        return count;
    }

    private static void swap(int[] m, int i, int smallest) {
        int tmp = m[i];
        m[i] = m[smallest];
        m[smallest] = tmp;
    }


}
