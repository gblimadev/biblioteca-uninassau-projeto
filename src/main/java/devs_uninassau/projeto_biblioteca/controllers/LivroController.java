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

import devs_uninassau.projeto_biblioteca.entities.Livro;
import devs_uninassau.projeto_biblioteca.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping
	public Livro insert(@RequestBody Livro livro) {
		return livroService.insert(livro);
	}
	
	@GetMapping
	public List<Livro> findAll() {
	    return livroService.findAll();
	}
	
	@GetMapping("/{id}")
	public Livro findById(@PathVariable Long id) {
	    return livroService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
	    livroService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public Livro update(@PathVariable Long id, @RequestBody Livro livro) {
	    return livroService.update(id, livro);
	}
}
