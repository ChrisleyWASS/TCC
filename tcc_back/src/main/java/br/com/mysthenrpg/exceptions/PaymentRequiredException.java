package br.com.mysthenrpg.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PAYMENT_REQUIRED)
public class PaymentRequiredException extends RuntimeException {

	private static final long serialVersionUID = -7979104788771851088L;

	public PaymentRequiredException(String exception) {
		super(exception);
	}	
}