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
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "usuarios_personagens", schema = "cadastro", uniqueConstraints = { @UniqueConstraint(columnNames = { "id_usuario", "id_personagem" }, name = "usuario_personagem_un")})
@JsonInclude(Include.NON_NULL)
													
public class UsuarioPersonagem implements Serializable {

	private static final long serialVersionUID = 8301930500064394013L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
	@SequenceGenerator(schema = "cadastro", name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_usuario_personagem")
	private Long id;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_usuario", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "usuario_usuario_personagem_fk"))
	private Usuario usuario;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_personagem", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "personagem_usuario_personagem_fk"))
	private Personagem personagem;

	public UsuarioPersonagem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UsuarioPersonagem(Usuario usuario, Personagem personagem) {
		super();
		this.usuario = usuario;
		this.personagem = personagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}
	
	

}
