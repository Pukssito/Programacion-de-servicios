package org.example;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;

public class SendThread implements Runnable{

    private List<Integer> listaNum;

    private Semaphore receivePackageSemaphore;

    private Semaphore sendPackageSemaphore;

    public SendThread(List listaNum, Semaphore receivePackageSemaphore, Semaphore sendPackageSemaphore) {
        this.listaNum = listaNum;
        this.receivePackageSemaphore = receivePackageSemaphore;
        this.sendPackageSemaphore = sendPackageSemaphore;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 100; i++)
        {
            try {
                sendPackageSemaphore.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            listaNum.add(i);
            System.out.println("Enviado paquete " + i);
            receivePackageSemaphore.release();
        }
    }
}
