package org.federica;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.federica.componente.ProgramAerolinea;
import org.federica.componente.ReadAerolinea;
import org.federica.configuracion.AerolineaConfiguration;
import org.federica.entity.Aerolinea;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

public class Main {



    public static void main(String[] args){

        ApplicationContext context = new AnnotationConfigApplicationContext(
                AerolineaConfiguration.class
        );
        ProgramAerolinea programAerolinea = context.getBean(ProgramAerolinea.class);
        try {
            programAerolinea.execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}