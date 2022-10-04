package org.example;

import java.util.Vector;
import java.util.concurrent.Semaphore;

public class SendPackage implements Runnable{


   Vector<Integer> v = new Vector<Integer>(3);


   @Override
    public void run() {

       Semaforos semaforos = new Semaforos(new Semaphore(3), new Semaphore(3));
        for (int i = 0; i < 100; i++) {
            v.add(i);
            if (v.size() == 3) {
                System.out.println("Enviado paquete  " + i);
                v.add(i);
                try {
                    semaforos.semaforo.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }

    }
}
