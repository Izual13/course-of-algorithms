package algorithms.cs;


import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class StackWithMax {
    public static void main(String[] args) {
        System.out.println(calc(System.in));
    }


    static String calc(InputStream is) {
        StringBuilder value = new StringBuilder();
        Scanner scanner = new Scanner(is);
        int n = scanner.nextInt();
        LinkedList<Record> objects = new LinkedList<>();
        boolean isCallMaxQuery = false;
        for (int i = 0; i < n; i++) {
            String action = scanner.next();
            switch (action) {
                case "push":
                    int number = scanner.nextInt();
                    if (!objects.isEmpty()) {
                        Record first = objects.getFirst();
                        objects.push(new Record(number, Math.max(number, first.max)));
                    } else {
                        objects.push(new Record(number, number));
                    }
                    break;
                case "max":
                    if (!objects.isEmpty()) {
                        isCallMaxQuery = true;
                        Record first = objects.getFirst();
                        value.append(first.max).append("\n");
                    }
                    break;

                case "pop":
                    if (!objects.isEmpty()) {
                        objects.pop();
                    }
                    break;
            }
        }

        return isCallMaxQuery ? value.toString().trim() : "";
    }

    static class Record {
        private int i;
        private int max;

        Record(int i, int max) {
            this.i = i;
            this.max = max;
        }
    }
}
