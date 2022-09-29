package org.example;

import java.util.concurrent.Semaphore;

public class PongTask implements Runnable{

    private Semaphore pingSemaphore;

    private Semaphore pongSemaphore;

    public PongTask(Semaphore pingSemaphore, Semaphore pongSemaphore) {
        this.pingSemaphore = pingSemaphore;
        this.pongSemaphore = pongSemaphore;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            try {
                // aqui el semaforo estará en rojo osea 0
                pongSemaphore.acquire(); // espera aq se ponga verde
                //aqui pong estara en rojo
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Pong");
            pingSemaphore.release();    //aqui pong estara en verde
        }

    }
}
