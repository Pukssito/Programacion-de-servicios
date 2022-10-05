package org.example;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;

public class Main {


    public static void main(String[] args) {

    Semaphore receivePackageSemaphore = new Semaphore(3);
    Semaphore sendPackageSemaphore = new Semaphore(3);

    List<Integer> listaNum = new Vector<Integer>();

    Thread sendThread = new Thread(new SendThread(listaNum,receivePackageSemaphore,sendPackageSemaphore));
    Thread receiveThread = new Thread(new ReceiveThread(listaNum,receivePackageSemaphore,sendPackageSemaphore));

    sendThread.start();
    receiveThread.start();

        System.out.println("Programa terminado");


    }




}