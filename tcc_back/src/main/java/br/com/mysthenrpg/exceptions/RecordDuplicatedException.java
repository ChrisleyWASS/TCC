package br.com.mysthenrpg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class RecordDuplicatedException extends RuntimeException {

	private static final long serialVersionUID = 7484809761463412018L;

	public RecordDuplicatedException(String exception) {
		super(exception);
	}	
}
