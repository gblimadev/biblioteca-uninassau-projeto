package devs_uninassau.projeto_biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devs_uninassau.projeto_biblioteca.entities.Usuario;
import devs_uninassau.projeto_biblioteca.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public Usuario insert(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(Long id) {
		return usuarioRepository.findById(id).get();
	}

	public void deleteById(Long id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario update(Long id, Usuario usuario) {
		Usuario usuarioAtual = usuarioRepository.findById(id).get();

		usuarioAtual.setNome(usuario.getNome());
		usuarioAtual.setEmail(usuario.getEmail());

		return usuarioRepository.save(usuarioAtual);
	}
}
