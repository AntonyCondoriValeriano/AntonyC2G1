package com.pasteleria.pasteleria.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pasteleria.pasteleria.modelo.CompCarrito;
import com.pasteleria.pasteleria.modelo.Venta;
import com.pasteleria.pasteleria.repositorio.CompCarritoRepository;
import com.pasteleria.pasteleria.repositorio.VentaRepository;

import java.util.List;

@Service
public class VentaService {
    @Autowired
    VentaRepository repo;

    public Venta save(Venta to) {
        return repo.save(to);
    }

    public List<Venta> list() {
        return repo.findAll();
    }

    public Venta update(Venta to, Long id) {
        try {
            Venta toe = repo.findById(id).orElse(null);
            if (toe != null) {
                toe.setSerie(to.getSerie());
                return repo.save(toe);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Venta searchById(Long id) {
        return repo.findById(id).orElse(null);
    }
}