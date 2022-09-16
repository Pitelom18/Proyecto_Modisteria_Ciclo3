package co.utp.misiontic.g12e1.proyectomodisteria.model.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Categoria {

    @Id
    @Column(name = "ID_Categoria")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(name = "Nombre", nullable = false , length = 100)
    private String name;
    @Column(name = "Descripcion", length = 255)
    private String descripcion;

    //-------RELACIONES
    @ManyToMany
    private List<Producto> productos;
        
}