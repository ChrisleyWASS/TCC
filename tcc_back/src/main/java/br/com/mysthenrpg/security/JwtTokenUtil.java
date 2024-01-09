package br.com.mysthenrpg.security;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable {
		
	private static final long serialVersionUID = -1297681406581905368L;

	public static final long JWT_TOKEN_VALIDITY = 12*60*60;

	private String secret = "SXpUR3pvNj43XiROYnInTVx0KGVtI0NWdF1eVSFXcCp5IlJBTyZ+Jw==";

	public String getIdUserFromToken(String token) {
		Claims claims = this.getAllClaimsFromToken(token);
		return claims.get("sub").toString();
	}

	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
	}

	private Boolean isTokenExpired(String token) {
		final Date expiration = this.getAllClaimsFromToken(token).getExpiration();
		return expiration.before(new Date());
	}

	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<String, Object>();
		return doGenerateToken(claims, userDetails.getUsername());
	}

	private String doGenerateToken(Map<String, Object> claims, String subject) {
		return Jwts.builder()
				   .setClaims(claims)
				   .setSubject(subject)
				   .setIssuedAt(new Date(System.currentTimeMillis()))
				   .setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				   .signWith(SignatureAlgorithm.HS512, secret)
				   .compact();
	}

	public Boolean validateToken(String token, UserDetails userDetails) {
		final String id = this.getIdUserFromToken(token);
		return (id.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

}
