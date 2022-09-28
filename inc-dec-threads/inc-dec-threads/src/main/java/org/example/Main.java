package org.example;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter(100);
        Thread incrementThread = new Thread(new IncrementalTask(counter));
        Thread decrementThread = new Thread(new DecrementalTask(counter));

        incrementThread.start();
        decrementThread.start();

        try {
            incrementThread.join();
            decrementThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // H1. inc
        // H2. dec
        //  value = value + 1  // value=2
        // value = value - 1   // value=2
        // value + 1 = 3
        // value -1 = 1
        // value = 3
        // value = 1

        System.out.println(counter.getValue());
    }
}