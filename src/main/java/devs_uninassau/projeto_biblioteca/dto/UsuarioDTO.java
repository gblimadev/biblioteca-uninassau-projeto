package devs_uninassau.projeto_biblioteca.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class UsuarioDTO {
	
	@NotBlank
	@Schema(description = "Nome completo do usuário")
	private String nome;
	
	@NotBlank
	@Email
	@Schema(description = "Endereço de E-mail do usuário")
	private String email;
	
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
