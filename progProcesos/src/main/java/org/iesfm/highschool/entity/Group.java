package org.iesfm.highschool.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Group {
    private String letter;
    private int course;
    private List<Student> students;
}
