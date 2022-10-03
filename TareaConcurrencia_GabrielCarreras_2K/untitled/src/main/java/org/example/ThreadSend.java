package org.example;

import java.awt.*;
import java.util.List;
import java.util.concurrent.Semaphore;

public class ThreadSend {

    private Semaphore fullListSemaphore;

    private Semaphore emptyListSemaphore;

    List<Integer> threadList;

    public ThreadSend(Semaphore fullListSemaphore, Semaphore emptyListSemaphore, List<Integer> threadReceivesList) {
        this.fullListSemaphore = fullListSemaphore;
        this.emptyListSemaphore = emptyListSemaphore;
        this.threadList = threadReceivesList;
    }

    public void send ()
    {
        for (int i = 0; i < 100; i++){
                threadList.add(i);
            if (threadList.size() == 3)
            {
                try {
                    fullListSemaphore.acquire();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                threadList.add(i);
                System.out.println("Enviado paquete: " + i);
            }
            if (threadList.size() == 0)
            {
                emptyListSemaphore.release();
            }



        }

    }
}
