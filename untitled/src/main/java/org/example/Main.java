package org.example;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        try {
            Semaphore pingSemaphore = new Semaphore(1);
            Semaphore pongSemaphore = new Semaphore(1);


            Thread ping = new Thread(new PingTask(pingSemaphore, pongSemaphore));
            Thread pong = new Thread(new PongTask(pingSemaphore, pongSemaphore));


            pongSemaphore.acquire();

            ping.start();
            pong.start();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

}