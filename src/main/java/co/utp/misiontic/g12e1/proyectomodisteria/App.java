package co.utp.misiontic.g12e1.proyectomodisteria;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Categoria;
import co.utp.misiontic.g12e1.proyectomodisteria.model.entity.Producto;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.CategoriaRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.model.repository.ProductoRepository;
import co.utp.misiontic.g12e1.proyectomodisteria.service.ProductoService;
import lombok.AllArgsConstructor;
import lombok.Data;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Data
	@Component
	@AllArgsConstructor
	private class DataLoader implements CommandLineRunner {

		private final ProductoRepository productoRepository;
		private final ProductoService productosvc;
		private final CategoriaRepository categoriaRepository;

		@Override
		public void run(String... args) throws Exception {
			System.out.println("-----LOAD DATA----------");
			loadData();

		}

		private void loadData() {
			// loadCategories();
			// loadProducto();
		}

		

		private void loadCategories() {
			categoriaRepository.saveAll(Arrays.asList(
					new Categoria(1001L,"Pantalon"),
					new Categoria(1002L,"Camisa"),
					new Categoria(1003L,"Otros"),
					new Categoria(1004L,"Colegio A"),
					new Categoria(1005L,"Colegio B"),
					new Categoria(1006L,"Fisica"),
					new Categoria(1007L,"Diario"),
					new Categoria(1008L,"Preescolar")));
					System.out.println("CATEGORIAS GUARDADAS");
		}

		private void loadProducto(){
			// var productos = Arrays.asList(
			// 	new Producto ("Pantalon Diario", 50.0, "img/product-4.jpg", 
			// 		Arrays.asList(new Categoria(1001L), new Categoria(1007L))),
			// 	new Producto ("Camisa Fisica", 30.0, "img/product-5.jpg",
			// 		Arrays.asList(new Categoria(1002L), new Categoria(1006L)))
			// );
			var producto1 = new Producto (1001L,"Pantalon Diario", 50.0, "img/product-4.jpg", 
			Arrays.asList(new Categoria(1001L), new Categoria(1007L)));
			var producto2=new Producto (1002L,"Camisa Fisica", 30.0, "img/product-5.jpg",
			Arrays.asList(new Categoria(1002L), new Categoria(1006L)));
			productosvc.saveProducto(producto1);
			productosvc.saveProducto(producto2);
			System.out.println("PRODUCTOS GUARDADOS");
		}
	}

}
