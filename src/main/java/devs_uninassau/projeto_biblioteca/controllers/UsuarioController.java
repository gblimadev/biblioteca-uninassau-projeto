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

import devs_uninassau.projeto_biblioteca.dto.UsuarioDTO;
import devs_uninassau.projeto_biblioteca.dto.UsuarioResponseDTO;
import devs_uninassau.projeto_biblioteca.entities.Usuario;
import devs_uninassau.projeto_biblioteca.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;

	@PostMapping
	public ResponseEntity<UsuarioResponseDTO> insert(@Valid @RequestBody UsuarioDTO usuarioDTO) {

		Usuario usuario = new Usuario();
		usuario.setNome(usuarioDTO.getNome());
		usuario.setEmail(usuarioDTO.getEmail());

		usuarioService.insert(usuario);

		UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
		usuarioResponseDTO.setId(usuario.getId());
		usuarioResponseDTO.setNome(usuario.getNome());
		usuarioResponseDTO.setNome(usuario.getEmail());

		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponseDTO);
	}

	@GetMapping
	public List<UsuarioResponseDTO> findAll() {

		List<Usuario> usuarios = usuarioService.findAll();

		List<UsuarioResponseDTO> resposta = usuarios.stream().map(usuario -> {

			UsuarioResponseDTO usuarioResponsedto = new UsuarioResponseDTO();

			usuarioResponsedto.setId(usuario.getId());
			usuarioResponsedto.setNome(usuario.getNome());
			usuarioResponsedto.setEmail(usuario.getEmail());

			return usuarioResponsedto;
			
		}).toList();
		
		return resposta;
	}

	@GetMapping("/{id}")
	public UsuarioResponseDTO findById(@PathVariable Long id) {
		
		Usuario usuario = usuarioService.findById(id);
		
		UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
		usuarioResponseDTO.setId(usuario.getId());
		usuarioResponseDTO.setNome(usuario.getNome());
		usuarioResponseDTO.setEmail(usuario.getEmail());
		
		return usuarioResponseDTO;
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable Long id) {
		usuarioService.deleteById(id);
	}

	@PutMapping("/{id}")
	public UsuarioResponseDTO update(@PathVariable Long id, @RequestBody UsuarioDTO usuarioDTO) {
		
		Usuario usuario = usuarioService.findById(id);
		usuario.setNome(usuarioDTO.getNome());
		usuario.setEmail(usuarioDTO.getEmail());
		usuarioService.update(id, usuario);
	
		UsuarioResponseDTO usuarioResponseDTO = new UsuarioResponseDTO();
		usuarioResponseDTO.setNome(usuario.getNome());
		usuarioResponseDTO.setEmail(usuario.getEmail());
		
		return usuarioResponseDTO;
	}

}
