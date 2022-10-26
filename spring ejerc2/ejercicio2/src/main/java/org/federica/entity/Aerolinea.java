package org.federica.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Aerolinea {

    private String nombre;
    private List<Vuelo> listaVuelos;
}
