package br.com.mysthenrpg.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mysthenrpg.entities.Usuario;
import br.com.mysthenrpg.exceptions.BadRequestException;
import br.com.mysthenrpg.exceptions.ConstraintViolationException;
import br.com.mysthenrpg.exceptions.RecordDuplicatedException;
import br.com.mysthenrpg.exceptions.RecordNotFoundException;
import br.com.mysthenrpg.filters.UsuarioUpdateFilter;
import br.com.mysthenrpg.repositories.UsuarioRepository;
import br.com.mysthenrpg.rules.UsuarioRules;
import br.com.mysthenrpg.util.FieldNotValid;
import br.com.mysthenrpg.util.UtilPassword;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	@RequestMapping(value = "/{idUsuario}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> update(@RequestBody UsuarioUpdateFilter usuarioFilter, @PathVariable("idUsuario") Long id, BindingResult result) throws Exception {
		
		Usuario usuario = usuarioFilter.getObjectUsuario();
		
		UsuarioRules regras = new UsuarioRules(result);
		regras.validate(usuario);		
		if (result.hasErrors()) {
			List<FieldNotValid> fieldsNotValid = new ArrayList<FieldNotValid>();
			for (int i = 0; i < result.getErrorCount(); i++) {
				fieldsNotValid.add(new FieldNotValid(result.getFieldErrors().get(i).getField(), result.getFieldErrors().get(i).getDefaultMessage()));
			} 
			return new ResponseEntity<Object>(fieldsNotValid, HttpStatus.BAD_REQUEST); 
		}
		
		Usuario currentUsuario = null;
		try {
			currentUsuario = usuarioRepository.findById(id).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Registro não encontrado.");
		}
		
		currentUsuario.setNome(usuario.getNome());
		currentUsuario.setDataNascimento(usuario.getDataNascimento());
		currentUsuario.setUsuarioAtualizacao(Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName()));
		currentUsuario.setDataAtualizacao(new Date());	
		
		if(usuarioFilter.getNovaSenha() != null) {			
			if (UtilPassword.verifyUserPassword(usuario.getSenha(), currentUsuario.getSenha(), currentUsuario.getSalt() + currentUsuario.getHash())) {								
				currentUsuario.setHash(UtilPassword.getSaltOrHash(10));
				currentUsuario.setSalt(UtilPassword.getSaltOrHash(10));
				currentUsuario.setSenha(UtilPassword.generateSecurePassword(usuario.getSenha(), currentUsuario.getSalt() + currentUsuario.getHash()));
			} else {
				throw new RecordNotFoundException("Senha atual incorreta");
			}				
		}
					
		try {
			return new ResponseEntity<Object>(usuarioRepository.save(currentUsuario), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = {"/{idUsuario}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> get(@PathVariable("idUsuario") Long idUsuario) throws Exception {
		
		Usuario usuario = null;
		
		try {
			usuario = usuarioRepository.findById(idUsuario).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Usuário não encontrado.");
		}
		 			
		return ResponseEntity.ok(usuario);
	}
	
	@RequestMapping(value = "/{idUsuario}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public void delete(@PathVariable Long idUsuario) throws Exception {
		
		try {			
			Usuario currentUsuario = null;
			
			try {
				currentUsuario = usuarioRepository.findById(idUsuario).get();
			} catch (Exception e) {
				throw new RecordNotFoundException("Registro não encontrado.");
			}
			
			currentUsuario.setUsuarioAtualizacao(Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName()));
			currentUsuario.setDataAtualizacao(new Date());	
			
			usuarioRepository.deleteById(idUsuario);			
			//usuarioRepository.flush();
			
		} catch (EmptyResultDataAccessException e) {
			throw new RecordNotFoundException("Registro não encontrado.");
		} catch (DataIntegrityViolationException e) {			
			throw new ConstraintViolationException("O registro não pode ser excluído pois está referenciado em outras partes do sistema.");
		} 
	}
}
