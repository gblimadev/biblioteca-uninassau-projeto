package devs_uninassau.projeto_biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import devs_uninassau.projeto_biblioteca.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
