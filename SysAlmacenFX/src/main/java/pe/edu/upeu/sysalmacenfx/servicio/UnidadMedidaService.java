package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysalmacenfx.modelo.Categoria;
import pe.edu.upeu.sysalmacenfx.modelo.UnidadMedida;
import pe.edu.upeu.sysalmacenfx.repositorio.CategoriaRepository;
import pe.edu.upeu.sysalmacenfx.repositorio.UnidadMedidaRepository;

import java.util.List;
@Repository
public class UnidadMedidaService {
    @Autowired
    UnidadMedidaRepository repo;

    //C
    public UnidadMedida save(UnidadMedida to){
        return repo.save(to);
    }
    //R
    public List<UnidadMedida> List(){
        return repo.findAll();
    }
    //U
    public UnidadMedida update(UnidadMedida to, Long id){
        try {
            UnidadMedida toe=repo.findById(id).get();
            if(toe!=null) {
                toe.setNombreMedida(to.getNombreMedida());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }
    public UnidadMedida update(UnidadMedida to){
        return repo.save(to);
    }

    //D
    public void delete(Long id){
        repo.deleteById(id);
    }
    //B
    public UnidadMedida searchId(Long id){
        return repo.findById(id).get();
    }
}
