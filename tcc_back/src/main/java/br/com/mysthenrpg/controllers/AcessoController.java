package br.com.mysthenrpg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import br.com.mysthenrpg.entities.Usuario;
import br.com.mysthenrpg.exceptions.BadRequestException;
import br.com.mysthenrpg.exceptions.RecordDuplicatedException;
import br.com.mysthenrpg.exceptions.RecordNotFoundException;
import br.com.mysthenrpg.repositories.UsuarioRepository;
import br.com.mysthenrpg.rules.UsuarioRules;
import br.com.mysthenrpg.util.FieldNotValid;
import br.com.mysthenrpg.util.UtilPassword;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mysthenrpg.entities.Usuario;
import br.com.mysthenrpg.repositories.UsuarioRepository;
import br.com.mysthenrpg.security.JwtRequest;
import br.com.mysthenrpg.security.JwtResponse;
import br.com.mysthenrpg.security.JwtTokenUtil;
import br.com.mysthenrpg.security.JwtUserDetailsService;
import br.com.mysthenrpg.util.UtilPassword;

@RestController
@RequestMapping("/acesso")
public class AcessoController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = {"/login"}, method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest, HttpServletRequest request) throws Exception {
		
		Usuario usuario = usuarioRepository.findByLogin(authenticationRequest.getUsername());
		
		if ((usuario != null) && (usuario.getId() != 0)) {
			if (UtilPassword.verifyUserPassword(authenticationRequest.getPassword(), usuario.getSenha(), usuario.getSalt() + usuario.getHash())) {
				final UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getLogin().toString());
				final String token = jwtTokenUtil.generateToken(userDetails);
				
				JwtResponse jwtResponse = new JwtResponse(token, usuario.getNome());
				
				return ResponseEntity.ok(jwtResponse);
			} else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro de acesso a conta, verifique Login e Senha.");
		} else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Erro de acesso a conta, verifique Login e Senha.");
	}
	
	@RequestMapping( value = {"/cadastro"}, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody Usuario usuario, BindingResult result) throws Exception {
				
		UsuarioRules regras = new UsuarioRules(result);
		regras.validate(usuario);		
		if (result.hasErrors()) {
			List<FieldNotValid> fieldsNotValid = new ArrayList<FieldNotValid>();
			for (int i = 0; i < result.getErrorCount(); i++) {
				fieldsNotValid.add(new FieldNotValid(result.getFieldErrors().get(i).getField(), result.getFieldErrors().get(i).getDefaultMessage()));
			} 
			return new ResponseEntity<Object>(fieldsNotValid, HttpStatus.BAD_REQUEST); 
		}
		
		Usuario usuarioLoginExistente = null;
		try {
			usuarioLoginExistente = usuarioRepository.findByLogin(usuario.getLogin());				
		} catch (Exception e) {
			throw new BadRequestException("Erro ao verificar o login informado.");
		}
		
		if(usuarioLoginExistente != null) {
			throw new RecordDuplicatedException("Login " + usuario.getLogin() + " já cadastrado no sistema.");
		}
		
		usuario.setAtivo(true);
		usuario.setHash(UtilPassword.getSaltOrHash(10));
		usuario.setSalt(UtilPassword.getSaltOrHash(10));
		usuario.setSenha(UtilPassword.generateSecurePassword(usuario.getSenha(), usuario.getSalt() + usuario.getHash()));
		
		usuario.setUsuarioCriacao((long)0);
		usuario.setDataCriacao(new Date());	
		
		try {
			return new ResponseEntity<Object>(usuarioRepository.save(usuario), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}		
	}	
}
