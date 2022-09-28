package org.example;

public class DecrementalTask implements Runnable {

    private final Counter counter;

    public DecrementalTask(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        while(counter.getValue() != 0) {
            counter.decrement();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}