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
@Table(name = "personagens_treinamentos", schema = "personagem")
public class PersonagemTreinamento implements Serializable {

	private static final long serialVersionUID = 5933872737801977753L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_personagem_treinamento_seq")
	@SequenceGenerator(schema = "personagem", name = "id_personagem_treinamento_seq", sequenceName = "id_personagem_treinamento_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_personagem_treinamento")
	private Long id;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_personagem", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "personagem_personagem_conhecimento_fk"))
	private Personagem personagem;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_conhecimento", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "conhecimento_personagem_conhecimento_fk"))
	private GameTreinamento treinamento;

	public PersonagemTreinamento(Personagem personagem, GameTreinamento treinamento) {
		super();
		this.personagem = personagem;
		this.treinamento = treinamento;
	}

	public PersonagemTreinamento() {
		super();
		// TODO Auto-generated constructor stub
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

	public GameTreinamento getTreinamento() {
		return treinamento;
	}

	public void setTreinamento(GameTreinamento treinamento) {
		this.treinamento = treinamento;
	}
	
	

}
