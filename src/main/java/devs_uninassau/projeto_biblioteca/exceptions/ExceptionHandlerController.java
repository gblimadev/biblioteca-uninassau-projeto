package devs_uninassau.projeto_biblioteca.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(LivroIndisponivelException.class) //quando acontecer uma LivroIndisponivelException, execute este método
	public ResponseEntity<String> handleLivroIndisponivel(LivroIndisponivelException e) {
	    return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	    
	}
}
