package devs_uninassau.projeto_biblioteca.dto;

import io.swagger.v3.oas.annotations.media.Schema;

public class UsuarioResponseDTO {
	
	@Schema(description = "Identificador único do usuário")
	private Long id;
	
	@Schema(description = "Nome completo do usuário")
    private String nome;
	
	@Schema(description = "Endereço de E-mail do usuário")
    private String email;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
    
    
}
