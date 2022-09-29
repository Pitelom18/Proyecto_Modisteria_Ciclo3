package co.utp.misiontic.g12e1.proyectomodisteria.model.entity;

import java.util.ArrayList;
// import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
// import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducto;

    @Column(name = "Nombre" , nullable = false , length = 100)
    private String name;
    @Column(name = "Precio", nullable = false, length = 100)
    private Double precio;
    @Column(name = "Descripcion" , length = 255)
    private String descripcion;
    @Column(name = "Imagen", length = 100)
    private String imageUrl;
    

    //-------RELACIONES
    @ManyToMany
    @JoinTable(name = "Tag",
    joinColumns=@JoinColumn(name="ID_Producto"),
    inverseJoinColumns=@JoinColumn(name="ID_Categoria"))
    private List<Categoria> categorias= new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Molde",
    joinColumns=@JoinColumn(name="ID_Producto"),
    inverseJoinColumns=@JoinColumn(name="ID_Talla"))
    private List<Talla> tallas= new ArrayList<>();;

    
    @OneToMany(mappedBy = "id.producto")
    private List<Item> compras;

    //-------CONSTRUCTOR
    public Producto(String name, Double precio, String imageUrl ){
        this.name = name;
        this.precio = precio;
        this.imageUrl= imageUrl;
    }

    public Producto(Long id, String name, Double precio, String imageUrl, List<Categoria> categorias){
        this.idProducto=id;
        this.name = name;
        this.precio = precio;
        this.imageUrl= imageUrl;
        this.categorias=categorias;
    }
    
}
