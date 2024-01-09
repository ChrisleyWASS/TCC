package br.com.mysthenrpg.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		final String requestTokenHeader = request.getHeader("Authorization");
		final String url = ((HttpServletRequest)request).getRequestURL().toString();
		String idUser = null;
		String jwtToken = null;

		if (url.contains("/acesso")) {
			chain.doFilter(request, response);
		}else if (url.contains("/sse")) {
			chain.doFilter(request, response);
		} else {
			if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
				jwtToken = requestTokenHeader.substring(7);
				try {
					idUser = jwtTokenUtil.getIdUserFromToken(jwtToken);
					
					if (idUser != null && SecurityContextHolder.getContext().getAuthentication() == null) {
						UserDetails userDetails = this.jwtUserDetailsService.loadUserById(idUser);
	
						if (jwtTokenUtil.validateToken(jwtToken, userDetails)) {
							UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
									userDetails, null, userDetails.getAuthorities());
							usernamePasswordAuthenticationToken
									.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	
							SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
						}
					}
					chain.doFilter(request, response);
				} catch (IllegalArgumentException e) {
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				} catch (ExpiredJwtException e) {
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				} catch (io.jsonwebtoken.MalformedJwtException e) {
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				} catch (io.jsonwebtoken.SignatureException e) {
					response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				}
			}	else {
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			}
		}		
	}

}
