package org.federica.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data // getter setters,  hashcode, equals, toString
@AllArgsConstructor //constructor con todos los atributos
@NoArgsConstructor //constructor vacio
public class Airlane {

    private String name;
    private List<Flight> listaVuelos;


}
