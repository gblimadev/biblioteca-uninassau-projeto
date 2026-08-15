package devs_uninassau.projeto_biblioteca.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devs_uninassau.projeto_biblioteca.entities.Livro;
import devs_uninassau.projeto_biblioteca.repositories.LivroRepository;

@Service
public class LivroService {
	
	@Autowired
    private LivroRepository livroRepository;

    public Livro insert(Livro livro) {
    	return livroRepository.save(livro);
    }
    
    public List<Livro> findAll() {
        return livroRepository.findAll();
    }
    
    public Livro findById(Long id) {
        return livroRepository.findById(id).get();
    }
    
    public void deleteById(Long id) {
        livroRepository.deleteById(id);
    }
    
    public Livro update(Long id, Livro livro) {
        Livro livroAtual = livroRepository.findById(id).get();

        livroAtual.setTitulo(livro.getTitulo());
        livroAtual.setAutor(livro.getAutor());
        livroAtual.setAno(livro.getAno());

        return livroRepository.save(livroAtual);
    }
}
