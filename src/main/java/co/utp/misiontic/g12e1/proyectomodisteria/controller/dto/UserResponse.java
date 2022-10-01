package co.utp.misiontic.g12e1.proyectomodisteria.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class UserResponse {

    private String username;
    
    private String name;

    private String email;
    
    private CarroDto carro;

}
