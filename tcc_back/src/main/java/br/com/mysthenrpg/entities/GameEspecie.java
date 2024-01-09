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
@Table(name = "especies", schema = "game_data")

public class GameEspecie implements Serializable {

	private static final long serialVersionUID = -8629100251116786989L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "especie_seq")
	@SequenceGenerator(schema = "game_data", name = "especie_seq", sequenceName = "especie_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_especie")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_capacidade", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "capacidade_especie_fk"))
	private CapacidadeGameData capacidades;
	
	@JsonProperty("nome")
	@Column(name = "nome", nullable = false, length = 20)
	private String nome;
	
	@JsonProperty("descricao")
	@Column(name = "descricao", nullable = false, length = 500)
	private String descricao;
	
	// Lista das Raças dessa Especie
	@Transient
	private List<GameRaca> racas;

	public GameEspecie(Long id, CapacidadeGameData capacidades, String nome, String descricao) {
		super();
		this.id = id;
		this.capacidades = capacidades;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	public GameEspecie() {
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

	public List<GameRaca> getRacas() {
		return racas;
	}

	public void setRacas(List<GameRaca> racas) {
		this.racas = racas;
	}
	
	
	
	
}
