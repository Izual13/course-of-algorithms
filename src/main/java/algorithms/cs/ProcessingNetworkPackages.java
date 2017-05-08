package algorithms.cs;


import java.io.InputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class ProcessingNetworkPackages {
    public static void main(String[] args) {
        System.out.println(builder().calc(System.in));
    }

    static ProcessingNetworkPackages builder() {
        return new ProcessingNetworkPackages();
    }

    private LinkedList<Package> buffer = new LinkedList<>();
    private int bufferSize = 0;
    private int maxBufferSize = 0;
    private int currentTime = -1;


    String calc(InputStream is) {
        StringBuilder string = new StringBuilder();
        Scanner scanner = new Scanner(is);
        maxBufferSize = scanner.nextInt();

        int n = scanner.nextInt();
        if (n == 0) {
            return string.toString();
        }

        for (int i = 0; i < n; i++) {
            int arrival = scanner.nextInt();
            int duration = scanner.nextInt();

            while (!buffer.isEmpty() && Math.max(currentTime, buffer.getFirst().arrival) + buffer.getFirst().duration <= arrival) {
                processing(string);
            }

            if (bufferSize < maxBufferSize) {
                if (duration == 0 && buffer.isEmpty()) {
                    string.append(arrival).append("\n");
                    currentTime = Math.max(arrival, currentTime);
                } else {
                    buffer.addLast(new Package(Math.max(arrival, currentTime), duration));
                    bufferSize++;
                }
            } else {
                buffer.addLast(new Package(-1, -1));
                maxBufferSize++;
                bufferSize++;
            }
        }
        while (!buffer.isEmpty()) {
            processing(string);
        }
        return string.toString();
    }

    private void processing(StringBuilder string) {
        if (buffer.isEmpty()) {
            return;
        }
        Package p = buffer.pop();
        while (p.arrival == -1) {
            string.append(-1).append("\n");
            maxBufferSize--;
            bufferSize--;
            if (!buffer.isEmpty()) {
                p = buffer.pop();
            } else {
                return;
            }
        }

        if (p.arrival == 188) {
            System.out.println();
        }
        bufferSize--;
        currentTime = Math.max(currentTime, p.arrival);
        string.append(currentTime).append("\n");
        currentTime += p.duration;
    }

    static class Package {
        private int arrival;
        private int duration;

        public Package(int arrival, int duration) {
            this.arrival = arrival;
            this.duration = duration;
        }

        @Override public String toString() {
            return "Package{" +
                    "arrival=" + arrival +
                    ", duration=" + duration +
                    '}';
        }
    }
}
