package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) {
        ObjectMapper om = new ObjectMapper();

        try {
            HighSchool federica = om.readValue(
                    new File(Main.class.getResource("/instituto.json").toURI()),
                    HighSchool.class
            );
            System.out.println(federica.getNombre());
            System.out.println("Estudiantes");
            for (Student student : federica.getEstudiantes())
            {
                System.out.println(student);
            }
        } catch (URISyntaxException | IOException e) {
            throw new RuntimeException(e);
        }


    }
}