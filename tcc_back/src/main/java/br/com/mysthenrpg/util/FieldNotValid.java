package br.com.mysthenrpg.util;

import java.io.Serializable;

public class FieldNotValid implements Serializable {

	private static final long serialVersionUID = 1517897436930820803L;

	private String field;

	private String message;

	public FieldNotValid(String field, String message) {
		super();
		this.field = field;
		this.message = message;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getField() {
		return field;
	}

	public String getMessage() {
		return message;
	}

}

