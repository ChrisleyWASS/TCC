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
@Table(name = "personagens_personalidade", schema = "personagem")

public class PersonagemPersonalidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personagem_personalidade_seq")
	@SequenceGenerator(schema = "personagem", name = "personagem_personalidade_seq", sequenceName = "personagem_personalidade_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_personagem_personalidade")
	private Long id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_personagem", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "personagem_personagem_personalidade_fk"))
	private Personagem personagem;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_personalidade", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "personalidade_personagem_personalidade_fk"))
	private GamePersonalidade personalidade;

	public PersonagemPersonalidade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonagemPersonalidade(Long id, Personagem personagem, GamePersonalidade personalidade) {
		super();
		this.id = id;
		this.personagem = personagem;
		this.personalidade = personalidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

	public GamePersonalidade getPersonalidade() {
		return personalidade;
	}

	public void setPersonalidade(GamePersonalidade personalidade) {
		this.personalidade = personalidade;
	}

}
