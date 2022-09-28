package org.example;

public class Main {
    public static void main(String[] args) {
        Thread helloWorldThread = new Thread(new RepeatMessageTask(50, "Hello world", 10));
        Thread goodbyeThread = new Thread(new RepeatMessageTask(50, "Goodbye", 20));

        helloWorldThread.start();
        goodbyeThread.start();

    }
}