package org.example;

import java.util.concurrent.Semaphore;

public class Semaforos {

    Semaphore semaforo = new Semaphore(3);

    Semaphore semaforo2 = new Semaphore(3);

    public Semaforos(Semaphore semaforo, Semaphore semaforo2) {
        this.semaforo = semaforo;
        this.semaforo2 = semaforo2;
    }


}
