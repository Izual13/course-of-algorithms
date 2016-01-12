package algorithms.ml;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

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


        start(System.in, System.out);
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
            ArrayList<Integer> list = new ArrayList<>();
            while (a.length != 0 && sum + peekHeap(a) <= m) {
                int maxElement = popHeap(a);
                a = Arrays.copyOf(a, a.length - 1);
                list.add(maxElement);
                sum += maxElement;
            }

            List<Integer> integers = list.parallelStream().map((x) -> x / 2).filter((x) -> x != 0).collect(Collectors.toList());
            if (integers.size() != 0) {
                a = Arrays.copyOf(a, a.length + integers.size());
            }

            for (int j = integers.size() - 1; j >= 0; j--) {
                a[a.length - j - 1] = integers.get(j);
                siftUp(a, a.length - j - 1);
            }
            i++;
        }

        out.println(i);

    }


    static int popHeap(int m[]) {
        int value = m[0];
        swap(m, 0, m.length - 1);
        m[m.length - 1] = 0;
        siftDown(m, 0);
        return value;
    }

    static int peekHeap(int m[]) {
        return m[0];
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
