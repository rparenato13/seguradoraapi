package com.renatoalmeida.seguradoraapi.resources.exception;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.validation.FieldError;

import com.renatoalmeida.seguradoraapi.services.exception.ConstraintViolationException;
import com.renatoalmeida.seguradoraapi.services.exception.InvalidArgumentException;
import com.renatoalmeida.seguradoraapi.services.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandartError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandartError err = new StandartError(System.currentTimeMillis(), status.value(), "Não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(InvalidArgumentException.class)
	public ResponseEntity<StandartError> invalidArgument(InvalidArgumentException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandartError err = new StandartError(System.currentTimeMillis(), status.value(), "Argumento inválido", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandartError> invalidArgument(ConstraintViolationException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandartError err = new StandartError(System.currentTimeMillis(), status.value(), "Violação de restrição", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandartError> invalidArgument(MethodArgumentNotValidException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
        org.springframework.validation.BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        
        Error errors = processFieldErrors(fieldErrors);
        List<String> stringErrors = errors.getFieldErrors().stream().map((obj) -> obj.getDefaultMessage()).collect(Collectors.toList());
		
		
		StandartError err = new StandartError(System.currentTimeMillis(), status.value(), "Violação de validação", 	stringErrors.toString() , request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
    private Error processFieldErrors(List<org.springframework.validation.FieldError> fieldErrors) {
    	Error error = new Error(HttpStatus.BAD_REQUEST.value(), "Erro de validação");
        for (FieldError fieldError: fieldErrors) {
            error.addFieldError(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return error;
    }
    
    public static class Error {
        private final int status;
        private final String message;
        private List<FieldError> fieldErrors = new ArrayList<>();

        public Error(int status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public void addFieldError(String path, String message) {
            FieldError error = new FieldError("", "", message);
            fieldErrors.add(error);
        }

        public List<FieldError> getFieldErrors() {
            return fieldErrors;
        }
    }
	
}
