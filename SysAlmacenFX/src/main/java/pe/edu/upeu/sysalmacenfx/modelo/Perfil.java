package pe.edu.upeu.sysalmacenfx.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name = "upeu_perfil")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_perfil", nullable = false)
    private Long idPerfil;
<<<<<<< HEAD
    @Size(max = 40)
    @Column(length = 40)
    private String nombre;
    @Size(max = 6)
    @Column(length = 6)
=======

    @Size(max = 20)
    @Column(length = 40)
    private String nombre;

    @Size(max = 6)
>>>>>>> f8f5c08cc55d09348cbe8d3bb2bcbcc5e3873faf
    private String codigo;
}