package org.federica.componente;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.federica.entity.Aerolinea;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

@AllArgsConstructor
public class ReadAerolinea {



    private String PATH;
    private ObjectMapper objectMapper;


    public Aerolinea mapeaAerolinea() throws IOException {


        Aerolinea aerolinea = objectMapper.readValue(new File(PATH), Aerolinea.class);

        return aerolinea;
    }
}
