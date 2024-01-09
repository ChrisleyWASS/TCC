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
@Table(name = "personagens_conhecimentos", schema = "personagem")

public class PersonagemConhecimento implements Serializable {

	private static final long serialVersionUID = -3502369566693899114L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personagem_conhecimento_seq")
	@SequenceGenerator(schema = "personagem", name = "personagem_conhecimento_seq", sequenceName = "personagem_conhecimento_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_personagem_conhecimento")
	private Long id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_personagem", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "personagem_personagem_conhecimento_fk"))
	private Personagem personagem;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_conhecimento", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "conhecimento_personagem_conhecimento_fk"))
	private GameConhecimento conhecimento;

	public PersonagemConhecimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonagemConhecimento(Personagem personagem, GameConhecimento conhecimento) {
		super();
		this.personagem = personagem;
		this.conhecimento = conhecimento;
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

	public GameConhecimento getConhecimento() {
		return conhecimento;
	}

	public void setConhecimento(GameConhecimento conhecimento) {
		this.conhecimento = conhecimento;
	}

	


}
