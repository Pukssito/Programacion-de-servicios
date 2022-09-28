package org.example;

import clase.Cosas;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

            Cosas cosas = new Cosas();
            File file = cosas.metodo();

            if (file.exists()) {
                System.out.println("El fichero existe " + "y es un " + (file.isDirectory() ? "directorio " : "fichero"));

            } else {
                System.out.println("El fichero no existe");
            }
        }




    }
