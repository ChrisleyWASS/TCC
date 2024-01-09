package br.com.mysthenrpg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FAILED_DEPENDENCY)
public class AtributeBySearchNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -7979104788771851088L;

	public AtributeBySearchNotFoundException(String exception) {
		super(exception);
	}	
}
