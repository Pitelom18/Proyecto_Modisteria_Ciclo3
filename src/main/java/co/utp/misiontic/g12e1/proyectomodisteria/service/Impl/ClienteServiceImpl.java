package co.utp.misiontic.g12e1.proyectomodisteria.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.UserResponse;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Item;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ClienteRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ItemRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ProductoRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.service.ClienteService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService{

    private final ClienteRepository clienteRepo;
    private final ProductoRepository productoRepo;
    private final ItemRepository ItemRepo;

    private final CarroServiceImpl carrosvc;
    private final ItemServiceImpl itemsvc;

    @Override
    public UserResponse validarUsuario(String user, String password) {

        var clienteOp = clienteRepo.findByUserAndPassword(user, password);
        if (clienteOp.isEmpty()) {
            throw new RuntimeException("Credenciales inválidas");
        }
        
        var cliente = clienteOp.get();
        return UserResponse.builder()
                .username(cliente.getUser())
                .name(cliente.getFirstName())
                .email(cliente.getEmail())
                .carro(itemsvc.cargarCarro(cliente.getIdCliente()))
                .build();
    }


    
    
}
