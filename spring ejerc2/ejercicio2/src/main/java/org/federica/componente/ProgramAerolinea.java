package org.federica.componente;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.federica.entity.Aerolinea;
import org.federica.entity.Vuelo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProgramAerolinea {

    private static final Logger log = LoggerFactory.getLogger(ProgramAerolinea.class);

    private ReadAerolinea readAerolinea;
    private FilterAerolinea filterAerolinea;
    private Scanner scanner;

    public void execute() throws IOException {
        log.info("Introduce un origen");
        String origen = scanner.nextLine();
        Aerolinea aerolinea = readAerolinea.mapeaAerolinea();
        List<Vuelo> listaVuelo = filterAerolinea.airlineFilter(aerolinea,origen);
        for (Vuelo vuelo:listaVuelo) {
            log.info(vuelo.toString());
        }
    }




}
