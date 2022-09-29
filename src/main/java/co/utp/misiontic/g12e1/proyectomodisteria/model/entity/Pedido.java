package co.utp.misiontic.g12e1.proyectomodisteria.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
/* import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; */
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pedido {

    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idPedido;
    
    @Column(name="Precio", nullable = false)
    private Double precio;

    
    //-------RELACIONES
    @ManyToOne
    private Cliente cliente;

    @OneToMany(mappedBy = "id.pedido")
    private List<Item> listaItems= new ArrayList<>();;
}
