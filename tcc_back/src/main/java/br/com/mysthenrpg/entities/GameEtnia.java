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
import javax.persistence.ForeignKey;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "etnias", schema = "game_data")

public class GameEtnia implements Serializable {

	private static final long serialVersionUID = -5418755864984946875L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "etnia_seq")
	@SequenceGenerator(schema = "game_data", name = "etnia_seq", sequenceName = "etnia_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_etnia")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_capacidade", updatable = false, nullable = true, foreignKey = @ForeignKey(name = "capacidade_etnia_fk"))
	private CapacidadeGameData capacidades;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_especie", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "especie_etnia_fk"))
	private GameEspecie especie;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_raca", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "raca_etnia_fk"))
	private GameRaca raca;
	
	@JsonProperty("nome")
	@Column(name = "nome", nullable = false, length = 20)
	private String nome;
	
	@JsonProperty("descricao")
	@Column(name = "descricao", nullable = false, length = 500)
	private String descricao;

	public GameEtnia(Long id, CapacidadeGameData capacidades, GameEspecie especie, GameRaca raca, String nome,
			String descricao) {
		super();
		this.id = id;
		this.capacidades = capacidades;
		this.especie = especie;
		this.raca = raca;
		this.nome = nome;
		this.descricao = descricao;
	}

	public GameEtnia() {
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

	public GameEspecie getEspecie() {
		return especie;
	}

	public void setEspecie(GameEspecie especie) {
		this.especie = especie;
	}

	public GameRaca getRaca() {
		return raca;
	}

	public void setRaca(GameRaca raca) {
		this.raca = raca;
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
	
	
	
}
