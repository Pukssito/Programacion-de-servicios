package org.educa.madrid.app;

import org.educa.madrid.service.FileService;

import java.util.Scanner;

public class Actividad1 {

    private static final String PATH = "C:\\temp\\ad\\ut2\\actividad1";

    public static void main(String[] args) {
        FileService myServiceFile = new FileService();
        myServiceFile.listFiles(PATH);

    }

}
