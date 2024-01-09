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
import javax.persistence.ForeignKey;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "racas", schema = "game_data")

public class GameRaca implements Serializable {

	private static final long serialVersionUID = -9195730300472144503L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "raca_seq")
	@SequenceGenerator(schema = "game_data", name = "raca_seq", sequenceName = "raca_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_raca")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_capacidade", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "capacidade_raca_fk"))
	private CapacidadeGameData capacidades;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_especie", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "especie_raca_fk"))
	private GameEspecie especie;
	
	@JsonProperty("nome")
	@Column(name = "nome", nullable = false, length = 20)
	private String nome;
	
	@JsonProperty("descricao")
	@Column(name = "descricao", nullable = false, length = 500)
	private String descricao;
	
	// Lista das Etnias dessa Raça
	@Transient
	private List<GameEtnia> etnias;

	public GameRaca(Long id, CapacidadeGameData capacidades, String nome, String descricao) {
		super();
		this.id = id;
		this.capacidades = capacidades;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public GameRaca() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public CapacidadeGameData getCapacidades() {
		return capacidades;
	}

	public void setCapacidades(CapacidadeGameData capacidades) {
		this.capacidades = capacidades;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public GameEspecie getEspecie() {
		return especie;
	}

	public void setEspecie(GameEspecie especie) {
		this.especie = especie;
	}

	public List<GameEtnia> getEtnias() {
		return etnias;
	}

	public void setEtnias(List<GameEtnia> etnias) {
		this.etnias = etnias;
	}
	
	
}
