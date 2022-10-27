package org.federica.configuracion;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.federica.componente.FilterAerolinea;
import org.federica.componente.ProgramAerolinea;
import org.federica.componente.ReadAerolinea;
import org.federica.entity.Aerolinea;
import org.federica.entity.Vuelo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.List;
import java.util.Scanner;

@Configuration
@PropertySource("application.properties")
public class AerolineaConfiguration {

    @Bean
    public ReadAerolinea readAerolinea(
            @Value("${input.path}") String path,
            ObjectMapper objectMapper){
        return new ReadAerolinea(path,objectMapper);
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
    @Bean
    public FilterAerolinea filterAerolinea(){
        return new FilterAerolinea();
    }
    @Bean
    public Scanner scanner (){
        return new Scanner(System.in);
    }
    @Bean
    public ProgramAerolinea programAerolinea(ReadAerolinea readAerolinea,
                                             FilterAerolinea filterAerolinea,
                                             Scanner scanner){
        return new ProgramAerolinea(readAerolinea,filterAerolinea,scanner);
    }
}
