package entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Member {

    private String nif;
    private String nombre;
    private String apellidos;
    private int codigoPostal;

}
