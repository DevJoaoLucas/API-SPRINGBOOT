package com.joaodev.apicursos.exception;

import java.time.LocalDateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<String, Object>> handleResourceNotFound(ResourceNotFoundException ex) {
	    Map<String, Object> erro = new HashMap<>();
	    erro.put("status", HttpStatus.NOT_FOUND.value());
	    erro.put("erro", "Recurso não encontrado");
	    erro.put("detalhes", ex.getMessage());
	    erro.put("timestamp", LocalDateTime.now());
	    return new ResponseEntity<>(erro, HttpStatus.NOT_FOUND);
	}

	
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<?> handleMethodNotAllowed(HttpRequestMethodNotSupportedException ex) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(gerarErro("Método não permitido", ex.getMessage()));
    }
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationError(MethodArgumentNotValidException ex) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(gerarErro("Erro de validação", "Campos inválidos"));
	}
	
	@ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGenericException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(gerarErro("Erro interno no servidor", ex.getMessage()));
    }
	
	private Map<String, Object> gerarErro(String erro, String detalhes) {
        Map<String, Object> map = new HashMap<>();
        map.put("erro", erro);
        map.put("detalhes", detalhes);
        return map;
    }
	
}
