package co.utp.misiontic.g12e1.proyectomodisteria.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ItemDto;
import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ProductoDto;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Item;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.ItemPk;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Producto;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ClienteRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ItemRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ProductoRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.service.ItemService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ClienteRepository clienteRepo;
    private final ProductoRepository productoRepo;
    private final ItemRepository itemRepo;


    @Override
    public void insertItem(Long cliente, Long producto, Integer cantidad) {

        var c=clienteRepo.findById(cliente);
        var p=productoRepo.findById(producto);
        
        if(c.isEmpty() || p.isEmpty()){
            System.out.println("cliente o producto no existe");
            return;
        }
        if(cantidad<=0){
            System.out.println("cantidad no aceptada");
            return;
        }
        var i= new Item(new ItemPk(p.get(),c.get()),cantidad);
        
        itemRepo.save(i);

    }

    @Override
    public void insertitems(List<Item> items) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public ProductoDto getProductoDto(Item item) {
        var producto = item.getIdItem().getProduct();
        return new ProductoDto(producto.getIdProducto().intValue()
                                            ,producto.getPrice()
                                            ,producto.getName()
                                            ,producto.getImageUrl());
    }

    @Override
    public ItemDto toItemDto(Item item) {
        return new ItemDto(item.getIdItem().getProduct().getIdProducto().intValue(),item.getQuantity());
    }

    @Override
    public Map cargarCarro(Long idCliente) {

        var saved_carro = itemRepo.verCarro(idCliente);
        if(saved_carro.isEmpty()){
            return new TreeMap();
        }

        var contenido = saved_carro.get();

        return saved_carro.get().stream().collect(Collectors.toMap(Item::getProductoId,Item::getQuantity));

        
    }
}
