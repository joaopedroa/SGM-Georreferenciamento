package br.com.bomdestino.sgm.georreferenciamento.handlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.bomdestino.sgm.georreferenciamento.exceptions.ServiceException;
import br.com.bomdestino.sgm.georreferenciamento.exceptions.StandardError;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ServiceException.class)
	public ResponseEntity<StandardError> objectNotFound(ServiceException e, HttpServletRequest request) {
		
		StandardError err = new StandardError(System.currentTimeMillis(), HttpStatus.PRECONDITION_FAILED.value(), "Erro ao consultar api externa", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).body(err);
	}
	
}
