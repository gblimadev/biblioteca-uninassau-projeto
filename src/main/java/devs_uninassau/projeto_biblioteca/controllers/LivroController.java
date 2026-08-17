package devs_uninassau.projeto_biblioteca.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import devs_uninassau.projeto_biblioteca.dto.LivroDTO;
import devs_uninassau.projeto_biblioteca.dto.LivroResponseDTO;
import devs_uninassau.projeto_biblioteca.entities.Livro;
import devs_uninassau.projeto_biblioteca.entities.Usuario;
import devs_uninassau.projeto_biblioteca.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;

	@PostMapping
	public ResponseEntity<LivroResponseDTO> insert(@RequestBody LivroDTO livroDTO) {
		
		Livro livro = new Livro();
		livro.setTitulo(livroDTO.getTitulo());
		livro.setAutor(livroDTO.getAutor());
		livro.setAno(livroDTO.getAno());
		
		livroService.insert(livro);
		
		LivroResponseDTO livroResponseDTO = new LivroResponseDTO();
		livroResponseDTO.setId(livro.getId());
		livroResponseDTO.setTitulo(livro.getTitulo());
		livroResponseDTO.setAutor(livro.getAutor());
		livroResponseDTO.setAno(livro.getAno());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(livroResponseDTO);
	}
	
	@GetMapping
	public List<LivroResponseDTO> findAll() {
		
		List<Livro> listaLivro = livroService.findAll();
		
		List<LivroResponseDTO> listaLivroResponseDTO = listaLivro.stream().map(livro -> {
			
			LivroResponseDTO livroResponseDTO = new LivroResponseDTO();
			
			livroResponseDTO.setId(livro.getId());
			livroResponseDTO.setTitulo(livro.getTitulo());
			livroResponseDTO.setAutor(livro.getAutor());
			livroResponseDTO.setAno(livro.getAno());
			
			return livroResponseDTO;
			
		}).toList();
		
	    return listaLivroResponseDTO;
	    
	}
	
	@GetMapping("/{id}")
	public LivroResponseDTO findById(@PathVariable Long id) {
		
		Livro livro = livroService.findById(id);
		
		LivroResponseDTO livroResponseDTO = new LivroResponseDTO();
		livroResponseDTO.setId(livro.getId());
		livroResponseDTO.setTitulo(livro.getTitulo());
		livroResponseDTO.setAutor(livro.getAutor());
		livroResponseDTO.setAno(livro.getAno());
		
	    return livroResponseDTO;
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
	    livroService.deleteById(id);
	}
	
	@PutMapping("/{id}")
	public LivroResponseDTO update(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
		
		Livro livro = livroService.findById(id);
		
		livro.setTitulo(livroDTO.getTitulo());
		livro.setAutor(livroDTO.getAutor());
		livro.setAno(livroDTO.getAno());
		
	    livroService.update(id, livro);
	    
	    LivroResponseDTO livroResponseDTO = new LivroResponseDTO();
	    livroResponseDTO.setId(livro.getId());
	    livroResponseDTO.setTitulo(livro.getTitulo());
	    livroResponseDTO.setAutor(livro.getAutor());
	    livroResponseDTO.setAno(livro.getAno());
	    
	    return livroResponseDTO;
	}
}
