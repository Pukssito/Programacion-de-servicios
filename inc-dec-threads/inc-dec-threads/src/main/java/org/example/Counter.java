package org.example;

public class Counter {
    private int value;

    public Counter(int value) {
        this.value = value;
    }

    public synchronized void increment() {
        value++; // value = value + 1;
    }

    public synchronized void decrement() {
        value--; // value = value - 1;
    }

    public int getValue() {
        return value;
    }
}