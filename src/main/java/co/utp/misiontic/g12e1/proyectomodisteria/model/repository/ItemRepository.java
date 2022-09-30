package co.utp.misiontic.g12e1.proyectomodisteria.model.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Item;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.ItemPk;

public interface ItemRepository extends JpaRepository <Item,ItemPk> {

    // Integer getCantidad(ItemPk item);

}
