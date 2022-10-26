package org.federica.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vuelo {

    private String origen;
    private String destino;
    private String fecha;
    private List<String> listaPasajeros;

}
