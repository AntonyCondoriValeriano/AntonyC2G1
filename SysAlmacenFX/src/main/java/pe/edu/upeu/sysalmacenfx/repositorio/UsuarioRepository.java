package pe.edu.upeu.sysalmacenfx.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.upeu.sysalmacenfx.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
