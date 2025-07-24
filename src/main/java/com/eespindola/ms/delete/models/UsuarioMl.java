package com.eespindola.ms.delete.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsuarioMl {

    private int idUsuario;
    private String folioId;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String fechaNacimiento;
    private String username;
    private String email;
    private String password;
    private String status;

}
