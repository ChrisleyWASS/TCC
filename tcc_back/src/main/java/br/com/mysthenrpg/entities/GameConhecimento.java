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
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.ForeignKey;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.mysthenrpg.enuns.TipoConhecimento;
import br.com.mysthenrpg.enuns.TipoQualidadeDefeito;

@Entity
@Table(name = "conhecimentos", schema = "game_data")

public class GameConhecimento implements Serializable {
	
	private static final long serialVersionUID = -6822148502761625770L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "conhecimento_seq")
	@SequenceGenerator(schema = "game_data", name = "conhecimento_seq", sequenceName = "conhecimento_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_conhecimento")
	private Long id;
	
	@JsonProperty("tipo")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_conhecimento", updatable = false, nullable = true, foreignKey = @ForeignKey(name = "tipo_conhecimento_conhecimento_fk"))
	private GameTipoConhecimento tipo;
	
	@JsonProperty("nome")
	@Column(name = "nome", nullable = false, length = 20)
	private String nome;
	
	@JsonProperty("descricao")
	@Column(name = "descricao", nullable = false, length = 300)
	private String descricao;
	
	@JsonProperty("valor")
	@Transient
	private int valor;

	public GameConhecimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GameTipoConhecimento getTipo() {
		return tipo;
	}

	public void setTipo(GameTipoConhecimento tipo) {
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
	
	
		
}
