package devs_uninassau.projeto_biblioteca.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class LivroResponseDTO {
	
	@Schema(description = "Identificador único do livro")
	private Long id;
	
	@Schema(description = "Título do livro")
	private String titulo;
	
	@Schema(description = "Autor do livro")
	private String autor;
	
	@Schema(description = "Ano de publicação do livro")
	private Integer ano;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public Integer getAno() {
		return ano;
	}
	public void setAno(Integer ano) {
		this.ano = ano;
	}
	
}
