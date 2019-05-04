package algorithms.csc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


public class Backpack {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int v = s.nextInt();
        List<Bag> ranges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double a = s.nextDouble();
            double b = s.nextDouble();
            ranges.add(new Bag(a, b));
        }

        ranges.sort(Bag::compareTo);

        double cost = 0;
        for (Bag bag : ranges) {
            if (v > 0) {
                if (v - bag.amount > 0) {
                    cost += bag.cost;
                    v -= bag.amount;
                } else {
                    cost += bag.cost / bag.amount * v;
                    v = 0;
                }
            }
        }

        System.out.println(String.format("%.3f", cost));


    }

    static class Bag implements Comparable {
        double cost, amount;

        Bag(double a, double amount) {
            this.cost = a;
            this.amount = amount;
        }

        public int compareTo(Object o) {
            Bag ip = (Bag) o;
            return -Double.compare(cost / amount, ip.cost / ip.amount);
        }

        @Override public String toString() {
            return "Bag{" +
                    "cost=" + cost +
                    ", amount=" + amount +
                    ", cost/amount=" + cost / amount +
                    '}';
        }
    }
}
