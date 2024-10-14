package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.modelo.CompCarrito;
import pe.edu.upeu.sysalmacenfx.modelo.Marca;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;
import pe.edu.upeu.sysalmacenfx.repositorio.CompCarritoRepository;

import java.util.ArrayList;
import java.util.List;

public class CompCarritoService {
    @Autowired
    CompCarritoRepository repo;
    //C
    public CompCarrito save(CompCarrito to){
        return repo.save(to);
    }
    //R
    public List<CompCarrito> List(){
        return repo.findAll();
    }
    //U
    public CompCarrito update(CompCarrito to, Long id){
        try {
            CompCarrito toe=repo.findById(id).get();
            if(toe!=null) {
                toe.setIdCompCarrito(to.getIdCompCarrito());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }
    public CompCarrito update(CompCarrito to){
        return repo.save(to);
    }

    //D
    public void delete(Long id){
        repo.deleteById(id);
    }
    //B
    public CompCarrito searchById(Long id){
        return repo.findById(id).get();
    }

    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(CompCarrito cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdCompCarrito()));
            cb.setValue(cate.getNombreProducto());
            listar.add(cb);
        }
        return listar;
    }
}
