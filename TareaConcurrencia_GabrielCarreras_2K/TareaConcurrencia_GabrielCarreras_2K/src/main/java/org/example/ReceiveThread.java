package org.example;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;

public class ReceiveThread implements Runnable{

    private List<Integer> listaNum;

    private Semaphore receivePackageSemaphore;

    private Semaphore sendPackageSemaphore;

    public ReceiveThread(List listaNum, Semaphore receivePackageSemaphore, Semaphore sendPackageSemaphore) {
        this.listaNum = listaNum;
        this.receivePackageSemaphore = receivePackageSemaphore;
        this.sendPackageSemaphore = sendPackageSemaphore;
    }

    @Override
    public void run() {

        for (int i = 1; i <= 100; i++)
        {
            try {
                receivePackageSemaphore.acquire();
                int num = listaNum.remove(0);
                System.out.println("Recibido paquete " + num);
                sendPackageSemaphore.release();
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}


