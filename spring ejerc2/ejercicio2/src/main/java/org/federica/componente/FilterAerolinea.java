package org.federica.componente;

import org.federica.entity.Aerolinea;
import org.federica.entity.Vuelo;

import java.util.ArrayList;
import java.util.List;

public class FilterAerolinea {



    public List<Vuelo> airlineFilter(Aerolinea aerolinea,String vuelo){

        List<Vuelo> listaVuelos = new ArrayList<>();
        for (int i = 0; i < aerolinea.getListaVuelos().size(); i++) {
            if (aerolinea.getListaVuelos().get(i).getOrigen().equals(vuelo)){
                listaVuelos.add(aerolinea.getListaVuelos().get(i));
            }
        }
        return listaVuelos;
    }

}
