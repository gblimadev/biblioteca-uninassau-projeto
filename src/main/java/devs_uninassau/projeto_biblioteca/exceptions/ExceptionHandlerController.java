package devs_uninassau.projeto_biblioteca.exceptions;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(LivroIndisponivelException.class) //quando acontecer uma LivroIndisponivelException, execute este método
	public ResponseEntity<String> handleLivroIndisponivel(LivroIndisponivelException e) {
	    return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
	    
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> handleVaidation(MethodArgumentNotValidException e) {
		
		List<String> errors = e.getBindingResult().getFieldErrors()
							.stream()
							.map(
							error -> error.getField() + ": " + error.getDefaultMessage())
							.toList();
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errors);
	}
}
