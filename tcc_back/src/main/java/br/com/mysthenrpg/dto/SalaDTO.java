package br.com.mysthenrpg.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.mysthenrpg.entities.Personagem;
import br.com.mysthenrpg.entities.Sala;
import br.com.mysthenrpg.entities.SalaLog;
import br.com.mysthenrpg.entities.Usuario;
import br.com.mysthenrpg.entities.UsuarioPersonagem;

public class SalaDTO {
	
	private Long id;
	private String nome;
	private String codigo;
	private Boolean ativa;
	private Usuario mestre;
	private List<UsuarioPersonagem> solicitacoes;
	private List<UsuarioPersonagem> autorizados;
	private List<PersonagemDTO> personagens;
	private List<SalaLog> log;
	
	public SalaDTO() {
		super();
		this.id = (long) 0;
	}
	public SalaDTO(Sala sala, List<UsuarioPersonagem> solicitacoes,
			List<UsuarioPersonagem> autorizados, List<PersonagemDTO> personagens, List<SalaLog> log) {
		super();
		this.id = sala.getId();
		this.nome = sala.getNome();
		this.codigo = sala.getCodigo();
		this.ativa = sala.getAtiva();
		this.mestre = sala.getMestre();
		this.solicitacoes = solicitacoes;
		this.autorizados = autorizados;
		this.personagens = personagens;
		this.log = log;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Boolean getAtiva() {
		return ativa;
	}
	public void setAtiva(Boolean ativa) {
		this.ativa = ativa;
	}
	public Usuario getMestre() {
		return mestre;
	}
	public void setMestre(Usuario mestre) {
		this.mestre = mestre;
	}
	public List<UsuarioPersonagem> getSolicitacoes() {
		return solicitacoes;
	}
	public void setSolicitacoes(List<UsuarioPersonagem> solicitacoes) {
		this.solicitacoes = solicitacoes;
	}
	public List<UsuarioPersonagem> getAutorizados() {
		return autorizados;
	}
	public void setAutorizados(List<UsuarioPersonagem> autorizados) {
		this.autorizados = autorizados;
	}
	public List<PersonagemDTO> getPersonagens() {
		return personagens;
	}
	public void setPersonagens(List<PersonagemDTO> personagens) {
		this.personagens = personagens;
	}
	public List<SalaLog> getLog() {
		return log;
	}
	public void setLog(List<SalaLog> log) {
		this.log = log;
	}
	
	

}
