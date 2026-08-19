package devs_uninassau.projeto_biblioteca.services;

import java.time.LocalDate;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devs_uninassau.projeto_biblioteca.entities.Emprestimo;
import devs_uninassau.projeto_biblioteca.exceptions.LivroIndisponivelException;
import devs_uninassau.projeto_biblioteca.exceptions.ResourceNotFoundException;
import devs_uninassau.projeto_biblioteca.repositories.EmprestimoRepository;

@Service
public class EmprestimoService {

	@Autowired
	private EmprestimoRepository emprestimoRepository;

	public Emprestimo insert(Emprestimo emprestimo) {
		
		boolean livroEmprestado = emprestimoRepository.existsByLivroIdAndDataDevolucaoIsNull(
				emprestimo.getLivro().getId());
		
		if (livroEmprestado) {
			throw new LivroIndisponivelException("Livro já está emprestado.");
		}
		
		return emprestimoRepository.save(emprestimo);
	}

	public List<Emprestimo> findAll() {
		return emprestimoRepository.findAll();
	}

	public Emprestimo findById(Long id) {
		return emprestimoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Emprestimo não encontrado."));
	}

	public void deleteById(Long id) {
		emprestimoRepository.deleteById(id);
	}

	public Emprestimo update(Long id, Emprestimo emprestimo) {
		Emprestimo emprestimoAtual = emprestimoRepository.findById(id).get();

		emprestimoAtual.setDataEmprestimo(emprestimo.getDataEmprestimo());
		emprestimoAtual.setDataDevolucao(emprestimo.getDataDevolucao());
		emprestimoAtual.setUsuario(emprestimo.getUsuario());
		emprestimoAtual.setLivro(emprestimo.getLivro());

		return emprestimoRepository.save(emprestimoAtual);
	}
	
	public Emprestimo devolver(Long id) {
		Emprestimo emprestimo = emprestimoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Emprestimo não encontrado."));;
		
		emprestimo.setDataDevolucao(LocalDate.now());
		
		return emprestimoRepository.save(emprestimo);
	}
	
}
