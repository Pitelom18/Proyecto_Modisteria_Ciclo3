package co.utp.misiontic.g12e1.proyectomodisteria.service.Impl;

import java.util.List;

import org.springframework.stereotype.Service;

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


    
    
}
