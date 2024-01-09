package br.com.mysthenrpg.rules;


import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import br.com.mysthenrpg.entities.Usuario;
import br.com.mysthenrpg.util.UtilEmail;

public class UsuarioRules {

	private BindingResult fieldErros = null;

	public UsuarioRules(BindingResult fieldErros) {
		this.fieldErros = fieldErros;
	}

	public BindingResult validate(Usuario usuario) {
		this.validFields(usuario);
		return this.fieldErros;
	}
	
	private void addMessage(String field, String message) {
		Boolean foundError = false;
		
		List<FieldError> fielsError =  this.fieldErros.getFieldErrors();
				
		for (FieldError fieldError : fielsError) {
			if ((fieldError.getField().equals(field)) &&
				(fieldError.getDefaultMessage().equals(message))) {
				foundError = true;
				break;
			}
		}
		if (!foundError)
			this.fieldErros.addError(new FieldError("usuário", field, message));
	}

	private void validFields(Usuario usuario) {
		if ((usuario.getNome() == null) || (usuario.getNome().length() < 3) || (usuario.getNome().length() > 60))
			addMessage("nome", "O nome deve ter entre 3 e 60 caracteres.");
		
		if((usuario.getSenha().isBlank()) || (usuario.getSenha().isEmpty()) || (usuario.getSenha() == null)) {
			addMessage("senha", "Senha não informada.");
		} else if((usuario.getSenha().length() < 3) || (usuario.getSenha().length() > 60)){
			addMessage("senha", "A senha deve ter entre 3 e 60 caracteres.");
		}
		
		if (usuario.getLogin() == null)
			addMessage("login", "Informe o login.");
		else {
			if (!UtilEmail.validade(usuario.getLogin()))
				addMessage("login", "Email inválido.");
		}
	}
}
