package br.com.mysthenrpg.exceptions;

public class UtilException extends Exception {

	private static final long serialVersionUID = 1L;

	public UtilException(String mensagem) {
		super(mensagem);
	}

	public UtilException(Throwable cause) {
		super(cause);
	}
}
