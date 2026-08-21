package devs_uninassau.projeto_biblioteca.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class EmprestimoDTO {
	
	@Schema(description = "ID do usuário que realizará o emprestimo")
	private Long usuario_id;
	
	@Schema(description = "ID do livro que será emprestado")
	private Long livro_id;
	
	public Long getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}
	public Long getLivro_id() {
		return livro_id;
	}
	public void setLivro_id(Long livro_id) {
		this.livro_id = livro_id;
	}
	
}
