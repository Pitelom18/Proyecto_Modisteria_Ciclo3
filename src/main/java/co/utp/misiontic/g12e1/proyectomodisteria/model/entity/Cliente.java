package co.utp.misiontic.g12e1.proyectomodisteria.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
/* import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType; */
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    
    @Id
    // @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="ID_Cliente")
    private Long id;

    @Column(name="Apellidos", nullable = false , length = 100)
    private String lastName;
    @Column(name="Nombres", nullable = false , length = 100)
    private String firstName;
    @Column(name="Email", nullable = false , length = 100)
    private String eMail;
    @Column(name="Telefono", nullable = false , length = 100)
    private String telefono;

    
    //-------RELACIONES
    @OneToMany(mappedBy = "cliente")
    private List<Pedido> pedidos = new ArrayList<>();;
}
