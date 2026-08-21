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
import devs_uninassau.projeto_biblioteca.services.LivroService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/livros")
public class LivroController {

	@Autowired
	private LivroService livroService;

	
	@Operation(summary = "Cadastrar livro")
	@ApiResponses({
		@ApiResponse(responseCode = "201", description = "Livro cadastrado com sucesso"),
		@ApiResponse(responseCode = "400", description = "Dados inválidos")
	})
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
	
	@Operation(summary = "Listar todos os livros")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Usuários encontrados")
	})
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
	
	@Operation(summary = "Buscar livro por ID")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Livro encontrado"),
		@ApiResponse(responseCode = "404", description = "Livro não encontrado")
	})
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
	
	@Operation(summary = "Excluir livro")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Livro excluido com sucesso"),
		@ApiResponse(responseCode = "404", description = "Livro não encontrado")
	})
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
	    livroService.deleteById(id);
	}
	
	@Operation(summary = "Atualizar livro")
	@ApiResponses({
		@ApiResponse(responseCode = "200", description = "Livro atualizado com sucesso"),
		@ApiResponse(responseCode = "400", description = "Dados inválidos"),
		@ApiResponse(responseCode = "404", description = "Livro não encontrado")
	})
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
