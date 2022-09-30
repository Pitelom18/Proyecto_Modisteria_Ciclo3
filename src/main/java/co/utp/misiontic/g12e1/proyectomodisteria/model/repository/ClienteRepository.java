package co.utp.misiontic.g12e1.proyectomodisteria.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Cliente;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Item;

public interface ClienteRepository extends JpaRepository <Cliente,Long> {

    // Cliente findAllByid(Long clienteId);
    Cliente findByidCliente(Long id);
    // void insertItem(Item item);
}
