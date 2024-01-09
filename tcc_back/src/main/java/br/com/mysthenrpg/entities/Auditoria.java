package br.com.mysthenrpg.entities;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Audited
@MappedSuperclass
public class Auditoria {

	@JsonIgnore
	@Column(updatable = false, nullable = false, name = "id_usuario_criacao")
	private Long usuarioCriacao;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_criacao", nullable = false, updatable = false)
	private Date dataCriacao;

	@JsonIgnore
	@Column(nullable = false, name = "id_usuario_atualizacao")
	private Long usuarioAtualizacao;

	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;
	
	public Long getUsuarioCriacao() {
		return usuarioCriacao;
	}

	public void setUsuarioCriacao(Long usuarioCriacao) {
		this.usuarioCriacao = usuarioCriacao;
		this.usuarioAtualizacao = usuarioCriacao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
		this.dataAtualizacao = dataCriacao;
	}

	public Long getUsuarioAtualizacao() {
		return usuarioAtualizacao;
	}

	public void setUsuarioAtualizacao(Long usuarioAtualizacao) {
		this.usuarioAtualizacao = usuarioAtualizacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
}
