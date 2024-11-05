package com.pasteleria.pasteleria.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pasteleria_cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long idCliente;
    @Column(name = "dniruc", nullable = false, length = 12)
    private String dniruc;
    @Column(name = "nombres", nullable = false, length = 160)
    private String nombres;
    @Column(name = "tipo_documento", nullable = false, length = 12)
    private String tipoDocumento;
}
