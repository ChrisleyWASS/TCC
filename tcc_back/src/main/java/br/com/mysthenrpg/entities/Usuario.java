package br.com.mysthenrpg.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Audited
@AuditTable(schema = "auditoria", value = "usuarios_auditoria")
@Table(name = "usuarios", schema = "cadastro", uniqueConstraints = { @UniqueConstraint(columnNames = { "login" }, name = "usuario_login_un")})
@JsonInclude(Include.NON_NULL)

public class Usuario extends Auditoria implements Serializable {

	private static final long serialVersionUID = 5891630116861256466L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
	@SequenceGenerator(schema = "cadastro", name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_usuario")
	private Long id;
	
	@JsonProperty("nome")
	@Column(name = "nome", nullable = false, length = 60)
	private String nome;
	
	@JsonProperty("login")
	@Column(name = "login", nullable = false, updatable = true, length = 60)
	private String login;
	
	@JsonProperty("senha")
	@Column(name = "senha", nullable = false, updatable = true, length = 120)
	private String senha;
	
	@JsonIgnore
	@Column(nullable = false, name = "ds_salt", length = 10)
	private String salt;
	
	@JsonIgnore
	@Column(nullable = false, name = "ds_hash", length = 10)
	private String hash;
	
	@JsonIgnore
	@Column(name = "ativo", nullable = false)
	private Boolean ativo;
	
	@JsonProperty("data_nascimento")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_nascimento", nullable = true, updatable = false)
	private Date dataNascimento;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String nome, String login, String senha, Date dataNascimento) {
		super();
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
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

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}
	
}
