package algorithms.cs;


import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class WindowMax {
    public static void main(String[] args) {
        System.out.println(calc(System.in));
    }

    static String calc(InputStream is) {
        StringBuilder value = new StringBuilder();
        Scanner scanner = new Scanner(is);
        int n = scanner.nextInt();
        int[] mas = new int[n];
        for (int i = 0; i < n; i++) {
            mas[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();

        LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() == i - m) {
                deque.poll();
            }

            while (!deque.isEmpty() && mas[deque.peekLast()] < mas[i]) {
                deque.removeLast();
            }
            deque.offer(i);
            if (i >= m - 1) {
                value.append(mas[deque.peekFirst()]).append(" ");
            }
        }


        return value.toString().trim();
    }

}
