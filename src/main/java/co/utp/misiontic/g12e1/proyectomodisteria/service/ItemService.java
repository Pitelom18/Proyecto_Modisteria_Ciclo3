package co.utp.misiontic.g12e1.proyectomodisteria.service;

import java.util.List;

import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Item;

public interface ItemService {

    public void insertItem(Long cliente, Long producto, Integer cantidad);

    public void insertitems(List<Item> items);


}
