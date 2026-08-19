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

import devs_uninassau.projeto_biblioteca.dto.EmprestimoDTO;
import devs_uninassau.projeto_biblioteca.dto.EmprestimoResponseDTO;
import devs_uninassau.projeto_biblioteca.entities.Emprestimo;
import devs_uninassau.projeto_biblioteca.entities.Livro;
import devs_uninassau.projeto_biblioteca.entities.Usuario;
import devs_uninassau.projeto_biblioteca.services.EmprestimoService;
import devs_uninassau.projeto_biblioteca.services.LivroService;
import devs_uninassau.projeto_biblioteca.services.UsuarioService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
	
	@Autowired
	EmprestimoService emprestimoService;
	
	@Autowired 
	UsuarioService usuarioService;
	
	@Autowired
	LivroService livroService;
	
	@PostMapping
	public ResponseEntity<EmprestimoResponseDTO> insert(@RequestBody EmprestimoDTO emprestimoDTO) {
		
		Usuario usuario = usuarioService.findById(emprestimoDTO.getUsuario_id());

		Livro livro = livroService.findById(emprestimoDTO.getLivro_id());

		Emprestimo emprestimo = new Emprestimo();

		emprestimo.setUsuario(usuario);
		emprestimo.setLivro(livro);
		
		emprestimoService.insert(emprestimo);
		
		EmprestimoResponseDTO emprestimoResponseDTO = new EmprestimoResponseDTO();
		emprestimoResponseDTO.setId(emprestimo.getId());
		emprestimoResponseDTO.setUsuario_id(usuario.getId());
		emprestimoResponseDTO.setLivro_id(livro.getId());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(emprestimoResponseDTO);
	}

	@GetMapping
	public List<EmprestimoResponseDTO> findAll() {
		
		List<EmprestimoResponseDTO> listaEmprestimos = emprestimoService.findAll().stream().map(emprestimo -> {
			
			EmprestimoResponseDTO emprestimoResponseDTO = new EmprestimoResponseDTO();
			emprestimoResponseDTO.setId(emprestimo.getId());
			emprestimoResponseDTO.setUsuario_id(emprestimo.getUsuario().getId());
			emprestimoResponseDTO.setLivro_id(emprestimo.getLivro().getId());
			
			return emprestimoResponseDTO;
			
		}).toList();
		
		return listaEmprestimos;
	}

	@GetMapping("/{id}")
	public EmprestimoResponseDTO findById(@PathVariable Long id) {
		
		Emprestimo emprestimo = emprestimoService.findById(id);
		
		EmprestimoResponseDTO emprestimoResponseDTO = new EmprestimoResponseDTO();
		emprestimoResponseDTO.setId(emprestimo.getId());
		emprestimoResponseDTO.setUsuario_id(emprestimo.getUsuario().getId());
		emprestimoResponseDTO.setLivro_id(emprestimo.getLivro().getId());
		
		return emprestimoResponseDTO;
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		emprestimoService.deleteById(id);
	}

	@PutMapping("/{id}")
	public Emprestimo update(@PathVariable Long id, @RequestBody Emprestimo emprestimo) {
		return emprestimoService.update(id, emprestimo);
	}
	
	@PutMapping("/{id}/devolucao")
	public EmprestimoResponseDTO devolver(@PathVariable Long id) {
		
		Emprestimo emprestimo = emprestimoService.devolver(id);
		
		EmprestimoResponseDTO emprestimoResponseDTO = new EmprestimoResponseDTO();
		emprestimoResponseDTO.setId(emprestimo.getId());
		emprestimoResponseDTO.setUsuario_id(emprestimo.getUsuario().getId());
		emprestimoResponseDTO.setLivro_id(emprestimo.getLivro().getId());
		
	    return emprestimoResponseDTO;
	}
	
}
