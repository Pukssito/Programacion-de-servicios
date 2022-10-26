package org.federica.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    private String origen;
    private String destino;
    private String fecha;
    private List<String> pasajeros;

}
