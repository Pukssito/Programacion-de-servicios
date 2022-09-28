package org.example;

public class IncrementalTask implements Runnable {

    private final Counter counter;

    public IncrementalTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while(counter.getValue() != 0) {
            counter.increment();

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}