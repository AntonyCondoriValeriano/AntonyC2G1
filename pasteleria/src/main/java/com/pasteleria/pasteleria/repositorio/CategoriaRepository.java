package com.pasteleria.pasteleria.repositorio;

import com.pasteleria.pasteleria.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
