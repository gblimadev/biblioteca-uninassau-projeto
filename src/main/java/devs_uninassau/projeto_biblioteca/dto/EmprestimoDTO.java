package devs_uninassau.projeto_biblioteca.dto;

public class EmprestimoDTO {
	
	private Long usuario_id;
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
