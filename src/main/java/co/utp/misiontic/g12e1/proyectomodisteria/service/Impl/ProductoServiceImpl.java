package co.utp.misiontic.g12e1.proyectomodisteria.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ProductoDto;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Categoria;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Producto;
// import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.CategoriaRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ProductoRepository;
// import co.utp.misiontic.g12e1.proyectomodisteria.service.CategoriaService;
import co.utp.misiontic.g12e1.proyectomodisteria.service.ProductoService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService {

    private ProductoRepository productoRepository;
    private CategoriaServiceImpl categoriaSvc;

    @Override
    public Producto saveProducto(Producto producto) {

        Producto p_new = new Producto();

        p_new.setName(producto.getName());
        p_new.setImageUrl(producto.getImageUrl());
        p_new.setPrecio(producto.getPrecio());

        p_new.getCategorias()
                .addAll(producto
                        .getCategorias()
                        .stream()
                        .map(c -> {
                            Categoria cc = categoriaSvc.findCategoriaById(c.getIdCategoria());
                            cc.getProductos().add(p_new);
                            System.out.println("producto agregado a categoria");
                            return cc;
                        }).collect(Collectors.toList()));
                        
        System.out.println("productos guardados");
        return productoRepository.save(p_new);
    }

    @Override
    public Producto saveProductos(List<Producto> productos) {
        
        return null;
    }

    @Override
    public List<ProductoDto> buscarProductosFiltrados(List<String> filtros) {
        
        if(filtros ==  null){
            return getProductos();
        }else{
            return productoRepository.busquedaFiltrada(filtros).stream()
                .map(p -> new ProductoDto(
                    p.getIdProducto().intValue(),
                    p.getPrecio(),
                    p.getName(),
                    p.getImageUrl()
                ))
                .collect(Collectors.toList());
        }
        
    }

    @Override
    public List<ProductoDto> getProductos() {
        var productos = productoRepository.findAll(Sort.by("name"));
        
        return productos.stream()
                .map(p->new ProductoDto(p.getIdProducto().intValue(), p.getPrecio(), p.getName(),p.getImageUrl()))
                .collect(Collectors.toList());
    }

    // @Override
    // public List<Producto> saveProductos(List<Producto> productos) {
        
    //     productos.stream()
            


    //     return null;

    // }

}
