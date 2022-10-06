package org.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HighSchool {

    private String nombre;

    private List<Student> estudiantes;

    private int edad;


}
