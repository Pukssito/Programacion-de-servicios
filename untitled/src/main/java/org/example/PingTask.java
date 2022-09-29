package org.example;

import java.util.concurrent.Semaphore;

public class PingTask implements Runnable{

    private Semaphore pingSemaphore;

    private Semaphore pongSemaphore;

    public PingTask(Semaphore pingSemaphore, Semaphore pongSemaphore) {
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                // aqui el semaforo estará en rojo osea 0
                pingSemaphore.acquire();// espera aq se ponga verde
                //aqui ping estara en rojo
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Ping");
            pongSemaphore.release();//aqui pong estara en verde

        }
    }
}
