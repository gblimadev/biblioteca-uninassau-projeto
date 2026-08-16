package devs_uninassau.projeto_biblioteca.exceptions;

public class LivroIndisponivelException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public LivroIndisponivelException(String msg) {
		super(msg);
	}
}
