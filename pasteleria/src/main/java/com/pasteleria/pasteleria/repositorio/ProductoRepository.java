package com.pasteleria.pasteleria.repositorio;

import com.pasteleria.pasteleria.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
