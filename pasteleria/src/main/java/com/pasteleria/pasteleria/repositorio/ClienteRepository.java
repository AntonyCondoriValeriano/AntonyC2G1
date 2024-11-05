package com.pasteleria.pasteleria.repositorio;

import com.pasteleria.pasteleria.modelo.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
