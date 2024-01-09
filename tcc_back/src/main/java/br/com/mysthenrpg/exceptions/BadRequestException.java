package br.com.mysthenrpg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 7009902692462564153L;

	public BadRequestException(String exception) {
	    super(exception);
	  }
}