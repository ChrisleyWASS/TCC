package br.com.mysthenrpg.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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
import javax.persistence.Transient;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import javax.persistence.ForeignKey;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "personagens_armas", schema = "personagem")
public class PersonagemArma implements Serializable {
	
	private static final long serialVersionUID = 5792100954506574311L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_personagem_arma_seq")
	@SequenceGenerator(schema = "personagem", name = "id_personagem_arma_seq", sequenceName = "id_personagem_arma_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_personagem_arma")
	private Long id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_personagem", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "personagem_personagem_arma_fk"))
	private Personagem personagem;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_arma", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "arma_personagem_arma_fk"))
	private GameArma arma;	

	public PersonagemArma() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PersonagemArma(Personagem personagem, GameArma arma) {
		super();
		this.personagem = personagem;
		this.arma = arma;
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

	public GameArma getArma() {
		return arma;
	}

	public void setArma(GameArma arma) {
		this.arma = arma;
	}
	
}
