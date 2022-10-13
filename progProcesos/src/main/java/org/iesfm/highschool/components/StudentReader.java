package org.iesfm.highschool.components;

import org.iesfm.highschool.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class StudentReader {

    private final static Logger log = LoggerFactory.getLogger(StudentReader.class);

    private Scanner scanner;

    public StudentReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public Student readStudent() {
        log.info("Introduce el NIF");
        String nif = scanner.nextLine();
        log.info("Introduce el nombre");
        String name = scanner.nextLine();
        log.info("Introduce los apellidos");
        String surname = scanner.nextLine();
        return new Student(nif, name, surname);
    }
}
