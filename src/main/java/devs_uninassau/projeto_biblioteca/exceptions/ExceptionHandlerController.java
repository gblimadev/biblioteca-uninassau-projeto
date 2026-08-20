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
	public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException e) {
			
		List<String> errors = e.getBindingResult().getFieldErrors()
							.stream()
							.map(
							error -> error.getField() + ": " + error.getDefaultMessage())
							.toList();
		
		ErrorResponse response = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), "Dados inválidos", errors);
	
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> resourceNotFound(ResourceNotFoundException e) {

		String mensagem = e.getMessage();
		
		ErrorResponse error = new ErrorResponse(HttpStatus.NOT_FOUND.value(), mensagem);
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
}
