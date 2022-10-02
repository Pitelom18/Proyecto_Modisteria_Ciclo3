package co.utp.misiontic.g12e1.proyectomodisteria.service.Impl;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.CarroDto;
import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ItemDto;
import co.utp.misiontic.g12e1.proyectomodisteria.controller.dto.ProductoDto;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ItemRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.service.CarroService;
import co.utp.misiontic.g12e1.proyectomodisteria.service.ItemService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarroServiceImpl implements CarroService{

    private final ItemRepository itemRepo;
    private final ItemServiceImpl itemsvc;

    @Override
    public CarroDto cargarCarro(Long idCliente) {

        var saved_carro = itemRepo.verCarro(idCliente);
        if(saved_carro.isEmpty()){
            return new CarroDto();
        }

        var contenido = saved_carro.get();

        return CarroDto.builder().items(
            contenido.stream()
                    .map(i-> itemsvc.toItemDto(i))
                    .collect(Collectors.toList())
        ).build();
    }
}
