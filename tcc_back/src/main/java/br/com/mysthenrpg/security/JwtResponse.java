package br.com.mysthenrpg.security;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = 1793178197758055421L;

	private final String jwttoken;
	
	private final String name;

	public JwtResponse(String jwttoken, String name) {
		this.jwttoken = jwttoken;
		this.name = name;
	}

	public String getToken() {
		return this.jwttoken;
	}

	public String getName() {
		return name;
	}

}
