package pe.edu.upeu.sysalmacenfx.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.edu.upeu.sysalmacenfx.modelo.Marca;
import pe.edu.upeu.sysalmacenfx.repositorio.MarcaRepository;
import java.util.List;
@Repository
public class MarcaService {
    @Autowired
    MarcaRepository repo;

    public Marca save(Marca to){
        return repo.save(to);
    }

    public List<Marca> List(){
        return repo.findAll();
    }

    public Marca update(Marca to, Long id){
        try {
            Marca toe=repo.findById(id).get();
            if(toe!=null) {
                toe.setNombre(to.getNombre());
            }
            return repo.save(toe);
        }catch (Exception e){
            System.out.println("Error: "+ e.getMessage());
        }
        return null;
    }
    public Marca update(Marca to){
        return repo.save(to);
    }


    public void delete(Long id){
        repo.deleteById(id);
    }

    public Marca searchById(Long id){
        return repo.findById(id).get();
    }
}
