package devs_uninassau.projeto_biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import devs_uninassau.projeto_biblioteca.entities.Emprestimo;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long>{
			// se existe esse livro e se a data de devolucao tá vazia
	boolean existsByLivroIdAndDataDevolucaoIsNull(Long livroId);
}
