package org.federica.componente;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.federica.entity.Aerolinea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@AllArgsConstructor
public class ReadAerolinea {

    private static final Logger log = LoggerFactory.getLogger(ReadAerolinea.class);

    private String PATH;


    public Aerolinea mapeaAerolinea() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Aerolinea aerolinea = objectMapper.readValue("{\"nombre\": \"flyEmirates\"}",Aerolinea.class);
        System.out.println("hola");
        System.out.println(aerolinea);
        return aerolinea;
    }
}
