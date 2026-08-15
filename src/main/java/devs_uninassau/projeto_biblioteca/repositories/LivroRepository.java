package devs_uninassau.projeto_biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import devs_uninassau.projeto_biblioteca.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
