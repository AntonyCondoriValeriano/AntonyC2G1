package pe.edu.upeu.sysalmacenfx.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysalmacenfx.modelo.Emisor;

public interface EmisorRepository extends JpaRepository<Emisor, Long> {
}
