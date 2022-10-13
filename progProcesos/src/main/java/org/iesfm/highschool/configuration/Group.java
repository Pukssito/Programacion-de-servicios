package org.iesfm.highschool.configuration;

import org.iesfm.highschool.components.GroupReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class Group {

    @Bean
    public Scanner scanner (){
        return new Scanner(System.in);
    }
    public GroupReader groupReader(Scanner scanner){
        return new GroupReader(scanner);

    }
}
