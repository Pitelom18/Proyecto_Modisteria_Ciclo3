package co.utp.misiontic.g12e1.proyectomodisteria.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ProductoDto;
import co.utp.misiontic.g12e1.proyectomodisteria.service.ProductoService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("api/producto")
public class CarroRestController {

    private ProductoService productosvc;

    @GetMapping("/{id}") // /api/movie/t12345
    public ResponseEntity<ProductoDto> getMovieById(@PathVariable("id") String productoid) {
        
        var producto = productosvc.getProductoDto(Integer.valueOf(productoid));
        return ResponseEntity.ok().body(producto);
    }
}
