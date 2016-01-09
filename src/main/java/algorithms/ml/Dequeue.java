package algorithms.ml;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * дек
 */
public class Dequeue {


    public static void main(String[] args) {

//        String s = "5 1 1 1 2 1 3 2 50 2 -1"; //yes
//        String s = "5 1 44 3 50 2 44 2 50 2 -1"; //yes


//        start(new ByteArrayInputStream(s.getBytes()), System.out);

    }

    public static void start(InputStream is, PrintStream out) {
        Scanner in = new Scanner(is);
        int n = in.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        try {
            for (int i = 0; i < n; i++) {
                Action action = Action.values()[in.nextInt()];
                int value = in.nextInt();
                switch (action) {
                    case pushFront:
                        list.addFirst(value);
                        break;
                    case popFront:
                        Integer popFront = list.pollFirst();
                        if (popFront == null) {
                            popFront = -1;
                        }
                        if (popFront != value) {
                            throw new RuntimeException();
                        }
                        break;
                    case pushBack:
                        list.add(value);
                        break;
                    case popBack:
                        Integer popBack = list.pollLast();
                        if (popBack == null) {
                            popBack = -1;
                        }
                        if (popBack != value) {
                            throw new RuntimeException();
                        }
                        break;
                }
            }

            System.out.println("YES");
        } catch (RuntimeException e) {
            System.out.println("NO");
        }

    }


    enum Action {
        NON, pushFront, popFront, pushBack, popBack
    }


}
