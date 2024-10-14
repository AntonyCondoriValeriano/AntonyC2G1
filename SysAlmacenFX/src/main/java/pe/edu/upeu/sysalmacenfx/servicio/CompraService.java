package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.upeu.sysalmacenfx.dto.ComboBoxOption;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.modelo.Compra;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;
import pe.edu.upeu.sysalmacenfx.repositorio.CompraRepository;

import java.util.ArrayList;
import java.util.List;
@Service
public class CompraService {
    @Autowired
    CompraRepository repo;

    //C
    public Compra save(Compra to){
        return repo.save(to);
    }

    //R
    public List<Compra> list(){
        return repo.findAll();
    }
    //U
    public Compra update(Compra to, Long id){
        try {
            Compra toe=repo.findById(id).get();
            if(toe!=null){
                toe.setIdCompra(to.getIdCompra());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }

    public Compra update(Compra to){
        return repo.save(to);
    }

    //D
    public void delete(Long id){
        repo.deleteById(id);
    }
    //B
    public Compra searchById(Long id){
        return repo.findById(id).get();
    }


    public List<ComboBoxOption> listarCombobox(){
        List<ComboBoxOption> listar=new ArrayList<>();
        ComboBoxOption cb;
        for(Compra cate : repo.findAll()) {
            cb=new ComboBoxOption();
            cb.setKey(String.valueOf(cate.getIdCompra()));
            cb.setValue(cate.getNumDoc());
            listar.add(cb);
        }
        return listar;
    }
}
