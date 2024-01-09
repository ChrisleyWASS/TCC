package br.com.mysthenrpg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class ConstraintViolationException extends RuntimeException {

	private static final long serialVersionUID = -4554818633976774551L;

	public ConstraintViolationException(String exception) {
	    super(exception);
	  }
}