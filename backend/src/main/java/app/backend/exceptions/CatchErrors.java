package app.backend.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//classe que vai lidar com erros
@RestControllerAdvice
public class CatchErrors extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity formatRuntimeException( RuntimeException e) {
		return ResponseEntity.badRequest().body( new ErrorResponse(e.getMessage()));
		
	}
}
