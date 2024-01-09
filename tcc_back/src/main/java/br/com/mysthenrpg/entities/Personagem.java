package br.com.mysthenrpg.entities;

import java.io.Serializable;

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
import org.hibernate.envers.NotAudited;
import org.hibernate.envers.RelationTargetAuditMode;

import javax.persistence.ForeignKey;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Audited
@AuditTable(schema = "auditoria", value = "personagens_auditoria")
@Table(name = "personagens", schema = "personagem")

public class Personagem extends Auditoria implements Serializable {

	private static final long serialVersionUID = 6607624094310456480L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personagem_seq")
	@SequenceGenerator(schema = "personagem", name = "personagem_seq", sequenceName = "personagem_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_personagem")
	private Long id;
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_especie", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "especie_personagem_fk"))
	private GameEspecie especiesPersonagem;
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_raca", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "raca_personagem_fk"))
	private GameRaca racasPersonagem;
	
	@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_etnia", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "etnia_personagem_fk"))
	private GameEtnia etniasPersonagem;
	
	@JsonProperty("nome")
	@Column(name = "nome", nullable = false, length = 20)
	private String nome;
	
	@JsonProperty("nome_linhagem")
	@Column(name = "nome_linhagem", nullable = true, length = 20)
	private String linhagem;
	
	@JsonProperty("nome_alternativo")
	@Column(name = "nome_alternativo", nullable = true, length = 20)
	private String alternativo;

	public Personagem(Long id, GameEspecie especiesPersonagem, GameRaca racasPersonagem, GameEtnia etniasPersonagem,
			String nome, String linhagem, String alternativo) {
		super();
		this.id = id;
		this.especiesPersonagem = especiesPersonagem;
		this.racasPersonagem = racasPersonagem;
		this.etniasPersonagem = etniasPersonagem;
		this.nome = nome;
		this.linhagem = linhagem;
		this.alternativo = alternativo;
	}

	public Personagem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GameEspecie getEspeciesPersonagem() {
		return especiesPersonagem;
	}

	public void setEspeciesPersonagem(GameEspecie especiesPersonagem) {
		this.especiesPersonagem = especiesPersonagem;
	}

	public GameRaca getRacasPersonagem() {
		return racasPersonagem;
	}

	public void setRacasPersonagem(GameRaca racasPersonagem) {
		this.racasPersonagem = racasPersonagem;
	}

	public GameEtnia getEtniasPersonagem() {
		return etniasPersonagem;
	}

	public void setEtniasPersonagem(GameEtnia etniasPersonagem) {
		this.etniasPersonagem = etniasPersonagem;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLinhagem() {
		return linhagem;
	}

	public void setLinhagem(String linhagem) {
		this.linhagem = linhagem;
	}

	public String getAlternativo() {
		return alternativo;
	}

	public void setAlternativo(String alternativo) {
		this.alternativo = alternativo;
	}
	
	

	
}
