package org.iesfm.highschool.components;

import org.iesfm.highschool.configuration.HighSchool;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class HighSchoolReader {


    private final static Logger log = LoggerFactory.getLogger(HighSchoolReader.class);

    private Scanner scanner;

    public HighSchoolReader(Scanner scanner) {
        this.scanner = scanner;
    }
    public HighSchoolReader highSchoolReader() {

        log.info("Introduce datos del grupo");
        String name = scanner.nextLine();
    }
}
