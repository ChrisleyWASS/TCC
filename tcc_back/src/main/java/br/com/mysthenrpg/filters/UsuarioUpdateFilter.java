package br.com.mysthenrpg.filters;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.mysthenrpg.entities.Usuario;

public class UsuarioUpdateFilter {
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("login")
	private String login;
	
	@JsonProperty("senha")
	private String senha;
	
	@JsonProperty("nova_senha")
	private String novaSenha;
	
	@JsonProperty("data_nascimento")
	private Date dataNascimento;

	public UsuarioUpdateFilter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNova_senha(String nova_senha) {
		this.novaSenha = nova_senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Usuario getObjectUsuario() {
		Usuario usuario = new Usuario(this.getNome(), 
									  this.getLogin(), 
									  this.getSenha(), 
									  this.getDataNascimento());		
		
		return usuario;
		
	}
	
	

}
