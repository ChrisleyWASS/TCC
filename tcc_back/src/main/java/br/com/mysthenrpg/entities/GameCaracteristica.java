package br.com.mysthenrpg.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

import br.com.mysthenrpg.enuns.TipoQualidadeDefeito;

@Entity
@Table(name = "caracteristicas", schema = "game_data")

public class GameCaracteristica implements Serializable {

	private static final long serialVersionUID = -5568110594263069345L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "caracteristica_seq")
	@SequenceGenerator(schema = "game_data", name = "caracteristica_seq", sequenceName = "caracteristica_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_caracteristica")
	private Long id;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_capacidade", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "capacidade_caracteristica_fk"))
	private CapacidadeGameData capacidades;
	
	@JsonProperty(value = "tipo_qualidade_defeito")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_qualidade_defeito", nullable = false, length = 1)
	private TipoQualidadeDefeito tipo_qualidade_defeito;
	
	@JsonProperty("nome")
	@Column(name = "nome", nullable = false, length = 20)
	private String nome;
	
	@JsonProperty("descricao")
	@Column(name = "descricao", nullable = false, length = 300)
	private String descricao;

	public GameCaracteristica() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameCaracteristica(Long id, CapacidadeGameData capacidades, TipoQualidadeDefeito tipo_qualidade_defeito,
			String nome, String descricao) {
		super();
		this.id = id;
		this.capacidades = capacidades;
		this.tipo_qualidade_defeito = tipo_qualidade_defeito;
		this.nome = nome;
		this.descricao = descricao;
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

	public TipoQualidadeDefeito getTipo_qualidade_defeito() {
		return tipo_qualidade_defeito;
	}

	public void setTipo_qualidade_defeito(TipoQualidadeDefeito tipo_qualidade_defeito) {
		this.tipo_qualidade_defeito = tipo_qualidade_defeito;
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
