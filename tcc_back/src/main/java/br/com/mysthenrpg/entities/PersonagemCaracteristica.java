package br.com.mysthenrpg.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.ForeignKey;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "personagens_caracteristicas", schema = "personagem")
public class PersonagemCaracteristica implements Serializable {
	
	private static final long serialVersionUID = 3499510332051874932L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_personagem_caracteristica_seq")
	@SequenceGenerator(schema = "personagem", name = "id_personagem_caracteristica_seq", sequenceName = "id_personagem_caracteristica_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_personagem_caracteristica")
	private Long id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_personagem", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "personagem_personagem_caracteristica_fk"))
	private Personagem personagem;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_caracteristica", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "caracteristica_personagem_caracteristica_fk"))
	private GameCaracteristica caracteristica;

	public PersonagemCaracteristica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonagemCaracteristica(Personagem personagem, GameCaracteristica caracteristica) {
		super();
		this.personagem = personagem;
		this.caracteristica = caracteristica;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Personagem getPersoagem() {
		return personagem;
	}

	public void setPersoagem(Personagem personagem) {
		this.personagem = personagem;
	}

	public GameCaracteristica getCaracteristica() {
		return caracteristica;
	}

	public void setCaracteristica(GameCaracteristica caracteristica) {
		this.caracteristica = caracteristica;
	}

	

}
