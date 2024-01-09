package br.com.mysthenrpg.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "salas_logs", schema = "sala")
@JsonInclude(Include.NON_NULL)
													
public class SalaLog implements Serializable {

	private static final long serialVersionUID = -5820919151746429976L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sala_log_seq")
	@SequenceGenerator(schema = "sala", name = "sala_log_seq", sequenceName = "sala_log_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_sala_log")
	private Long id;
	
	@JsonProperty("descricao")
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@JsonIgnore
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_registro", nullable = false, updatable = false)
	private Date dataRegistro;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sala", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "sala_sala_log_fk"))
	private Sala sala;

	public SalaLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SalaLog(String descricao, Date dataRegistro, Sala sala) {
		super();
		this.descricao = descricao;
		this.dataRegistro = dataRegistro;
		this.sala = sala;
	}



	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataRegistro() {
		return dataRegistro;
	}

	public void setDataRegistro(Date dataRegistro) {
		this.dataRegistro = dataRegistro;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
}
