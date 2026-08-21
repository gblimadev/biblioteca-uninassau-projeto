package devs_uninassau.projeto_biblioteca.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class LivroDTO {
	
	@Schema(description = "Título do livro")
	private String titulo;
	
	@Schema(description = "Autor do livro")
	private String autor;
	
	@Schema(description = "Ano de publicação livro")
	private Integer ano;
	
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
