package algorithms.cs;


import java.io.InputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
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

        LinkedList<Record> objects = new LinkedList<>();
        objects.push(new Record(mas[m - 1], mas[m - 1]));
        for (int i = m - 2; 0 <= i; i--) {
            objects.push(new Record(mas[i], Math.max(mas[i], objects.getFirst().max)));
        }


        for (int i = m; i < n; i++) {
            if (!objects.isEmpty()) {
                Record first = objects.pop();
                int last = mas[i];
                if (i != n - 1 && (objects.isEmpty() || objects.getFirst().max == null || last >= objects.getFirst().max || !Objects.equals(first.max, objects.getFirst().max))) {
                    //rebuid
                    objects.addLast(new Record(last, last));
                    rebuid(objects);
                } else {
                    objects.addLast(new Record(last, null));
                }
                value.append(first.getMax()).append(" ");
            }
        }


        Record first = objects.getFirst();
        Record last = objects.getLast();
        if (first.max == null) {
            rebuid(objects);
        }
        if (last.i > first.getMax()) {
            first = last;
        }
        value.append(first.getMax());


        return value.toString().trim();
    }

    private static void rebuid(LinkedList<Record> objects) {
        Iterator<Record> iterator = objects.descendingIterator();
        Record last = iterator.next();
        if (last.max == null) {
            last.max = last.i;
        }
        while (iterator.hasNext()) {
            Record record = iterator.next();
            record.max = Math.max(record.i, last.max);
            last = record;
        }

    }

    static class Record {
        private Integer i;
        private Integer max;

        Record(Integer i, Integer max) {
            this.i = i;
            this.max = max;
        }

        Integer getMax() {
            return max == null ? i : max;
        }
    }
    //39208356
}
