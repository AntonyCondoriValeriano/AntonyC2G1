package pe.edu.upeu.sysalmacenfx.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
<<<<<<< HEAD

=======
>>>>>>> f8f5c08cc55d09348cbe8d3bb2bcbcc5e3873faf
@Entity
@Table(name = "upeu_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Long idCategoria;
    @Column(name = "nombre", nullable = false, length = 60)
    private String nombre;
<<<<<<< HEAD

=======
>>>>>>> f8f5c08cc55d09348cbe8d3bb2bcbcc5e3873faf
}