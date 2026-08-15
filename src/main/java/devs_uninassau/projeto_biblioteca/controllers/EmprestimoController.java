package devs_uninassau.projeto_biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devs_uninassau.projeto_biblioteca.entities.Emprestimo;
import devs_uninassau.projeto_biblioteca.services.EmprestimoService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

	@Autowired
	private EmprestimoService emprestimoService;

	@PostMapping
	public Emprestimo insert(@RequestBody Emprestimo emprestimo) {
		return emprestimoService.insert(emprestimo);
	}

	@GetMapping
	public List<Emprestimo> findAll() {
		return emprestimoService.findAll();
	}

	@GetMapping("/{id}")
	public Emprestimo findById(@PathVariable Long id) {
		return emprestimoService.findById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		emprestimoService.deleteById(id);
	}

	@PutMapping("/{id}")
	public Emprestimo update(@PathVariable Long id, @RequestBody Emprestimo emprestimo) {
		return emprestimoService.update(id, emprestimo);
	}
	
}
