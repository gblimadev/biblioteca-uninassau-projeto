package devs_uninassau.projeto_biblioteca.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ResourceNotFoundException(String e) {
		super(e);
	}

}
