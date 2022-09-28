package org.example;

public class RepeatMessageTask implements Runnable {

    private int times;
    private String message;
    private int ttw;

    public RepeatMessageTask(int times, String message, int ttw) {
        this.times = times;
        this.message = message;
        this.ttw = ttw;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.println(message);
            try {
                Thread.sleep(ttw);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}