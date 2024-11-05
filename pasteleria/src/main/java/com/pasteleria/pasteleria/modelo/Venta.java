package com.pasteleria.pasteleria.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "pasteleria_venta")
public class Venta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_venta")
    private Long idVenta;
    @Column(name = "preciobase", nullable = false)
    private Double precioBase;
    @Column(name = "igv", nullable = false)
    private Double igv;
    @Column(name = "preciototal", nullable = false)
    private Double precioTotal;
    @ManyToOne
    @JoinColumn(name = "dniruc", referencedColumnName = "dniruc",
            nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENTE_VENTA"))
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "producto", referencedColumnName = "producto",
            nullable = false, foreignKey = @ForeignKey(name = "FK_PRODUCTO_VENTA"))
    private Producto producto;

}
