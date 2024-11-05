package com.pasteleria.pasteleria.servicio;

import com.pasteleria.pasteleria.dto.ComboBoxOption;
import com.pasteleria.pasteleria.modelo.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pasteleria.pasteleria.modelo.Cliente;
import com.pasteleria.pasteleria.repositorio.ClienteRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repo;

    public Cliente save(Cliente to) {
        return repo.save(to);
    }

    public List<Cliente> list() {
        return repo.findAll();
    }

    // Actualizar un cliente por ID
    public Cliente update(Cliente to, Long id) {
        try {
            Cliente toe = repo.findById(id).orElse(null);
            if (toe != null) {
                toe.setDniruc(to.getDniruc());
                return repo.save(toe);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return null;
    }


    public void delete(Long kr) {
        repo.deleteById(kr);
    }


    public Cliente searchById(Long kr) {
        return repo.findById(kr).orElse(null);
    }

    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(Cliente cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdCliente()));
            cb.setValue(cate.getDniruc());
            cb.setValue(cate.getNombres());
            cb.setValue(cate.getTipoDocumento());
            listar.add(cb);
        }
        return listar;
    }
}