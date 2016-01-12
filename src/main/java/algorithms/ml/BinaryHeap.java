package algorithms.ml;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Жадина.
 * <p>
 * Вовочка ест фрукты из бабушкиной корзины. В корзине лежат фрукты разной массы. Вовочка может поднять не более K грамм. Каждый фрукт весит не более K грамм. За раз он выбирает несколько самых тяжелых фруктов, которые может поднять одновременно, откусывает от каждого половину и кладет огрызки обратно в корзину. Если фрукт весит нечетное число грамм, он откусывает большую половину. Фрукт массы 1гр он съедает полностью.
 * Определить за сколько подходов Вовочка съест все фрукты в корзине.
 * <p>
 * Напишите свой класс кучи, реализующий очередь с приоритетом.
 * <p>
 * Формат входных данных. Вначале вводится n - количество фруктов и строка с целочисленными массами фруктов через пробел. Затем в отдельной строке K - "грузоподъемность".
 * <p>
 * Формат выходных данных. Неотрицательное число - количество подходов к корзине.
 */
public class BinaryHeap {


    public static void main(String[] args) {
        String s = "3 1 2 2 2"; //4
        s = "12 1 4 8 9 10 40 45 50 60 70 80 100 100"; //13
        s = "7 1 3 5 7 9 11 13 25"; //5
        s = "10 1 1 1 1 1 1 1 1 1 10 11"; //4
        s = "2 4 1 6"; //3
        s = "7 1 1 1 1 1 1 1 3"; //3
        s = "3 4 3 5 6"; //5
        s = " 10 1 2 3 4 5 6 7 8 9 10 12"; //10

//        5/128 64 32 32 32/192 -> 8
//        10/6 6 6 6 6 6 6 8 8 8/15 -> 10
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
            int subLength = 0;
            while (a.length > subLength && sum + a[subLength] <= m) {
                sum += a[subLength];
                subLength++;
            }
            int countZero = 0;
            for (int j = 0; j < subLength; j++) {
                a[j] /= 2;
                if (a[j] == 0) {
                    countZero++;
                    if (subLength <= a.length - countZero) {
                        swap(a, j, a.length - countZero);
                    }
                }
            }

            for (int j = subLength-1; j >= 0; j--) {
                siftDown(a, j);
            }
//            buildHeap(a);

            if (countZero != 0 && a.length - countZero >= 0) {
                a = Arrays.copyOf(a, a.length - countZero);
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
        if (left < m.length && right < m.length && m[left] < m[right]) {
            swap(m, left, right);
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
