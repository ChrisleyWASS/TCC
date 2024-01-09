package br.com.mysthenrpg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.EXPECTATION_FAILED)
public class AtributeBySearchValidationException extends RuntimeException {

	private static final long serialVersionUID = 1297876065692331593L;

	public AtributeBySearchValidationException(String exception) {
		super(exception);
	}	
}
