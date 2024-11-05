package com.pasteleria.pasteleria.servicio;

import org.springframework.stereotype.Service;
import com.pasteleria.pasteleria.dto.MenuMenuItenTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class MenuMenuItemDao implements MenuMenuItenDaoI {

    @Override
    public List<MenuMenuItenTO> listaAccesos(String perfil, Properties idioma) {
        List<MenuMenuItenTO> lista = new ArrayList<>();
        lista.add(new MenuMenuItenTO(idioma.getProperty("menu.nombre.archivo"), "", "mifile"));
        lista.add(new MenuMenuItenTO(idioma.getProperty("menu.nombre.archivo"), "Salir", "misalir"));
        lista.add(new MenuMenuItenTO("Categoria", "Reg. Producto", "miregproduct"));
        lista.add(new MenuMenuItenTO("Cliente", "Ver2", "miver2"));
        lista.add(new MenuMenuItenTO("Producto", "Auto Complete", "miautcomp"));
        lista.add(new MenuMenuItenTO("Venta", "Cliente", "cliente"));


        return lista;
    }
}


