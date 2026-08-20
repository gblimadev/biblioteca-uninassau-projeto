package devs_uninassau.projeto_biblioteca.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ErrorResponse {
	
	private Integer status;
	private String mensagem;
	
	private List<String> errors = new ArrayList<>();
	
	public ErrorResponse() {
		
	}

	public ErrorResponse(Integer status, String mensagem) {
		this.status = status;
		this.mensagem = mensagem;
	}
	
	public ErrorResponse(Integer status, String mensagem, List<String> errors) {
		this.status = status;
		this.mensagem = mensagem;
		this.errors = errors;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	
}
