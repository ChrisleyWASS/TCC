package br.com.mysthenrpg.entities;

import java.io.Serializable;

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
import javax.persistence.UniqueConstraint;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Audited
@AuditTable(schema = "auditoria", value = "salas_auditoria")
@Table(name = "salas", schema = "sala", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_usuario", "id_sala" }, name = "usuario_sala_un")})
@JsonInclude(Include.NON_NULL)
													
public class Sala extends Auditoria implements Serializable {
	private static final long serialVersionUID = 2682465537938143292L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sala_seq")
	@SequenceGenerator(schema = "sala", name = "sala_seq", sequenceName = "sala_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_sala")
	private Long id;

	@JsonProperty("nome")
	@Column(name = "nome", nullable = false, length = 60)
	private String nome;
	
	@JsonProperty("codigo")
	@Column(name = "codigo", nullable = false, length = 15)
	private String codigo;
	
	@JsonProperty("ativa")
	@Column(name = "ativa", nullable = false)
	private Boolean ativa;

	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "mestre_sala_fk"))
	private Usuario mestre;

	public Sala() {
		super();
		this.id = (long) 0;
		this.nome = "";
		this.codigo = "";
		this.ativa = false;
		this.mestre = new Usuario();
	}

	public Sala(Long id, String nome, String codigo, Boolean ativa, Usuario mestre) {
		super();
		this.id = id;
		this.nome = nome;
		this.codigo = codigo;
		this.ativa = ativa;
		this.mestre = mestre;
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

	
	

}
