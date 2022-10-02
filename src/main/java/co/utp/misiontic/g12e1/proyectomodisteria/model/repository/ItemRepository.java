package co.utp.misiontic.g12e1.proyectomodisteria.model.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Item;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.ItemPk;

public interface ItemRepository extends JpaRepository<Item, ItemPk> {

    
    // @Query(" SELECT DISTINCT p "
    //         + "FROM Producto p JOIN p.categories c "
    //         + "WHERE c.name IN :filtros "
    //         + "ORDER BY p.name ASC ")

    @Query(" SELECT DISTINCT i "
            + "FROM Item i JOIN i.idItem.client c "
            + "WHERE c.idCliente = :id ")
    Optional<List<Item>> verCarro(Long id);
}
