package br.com.mysthenrpg.entities;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.persistence.Transient;
import javax.persistence.ForeignKey;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.mysthenrpg.enuns.TipoArma;
import br.com.mysthenrpg.enuns.TipoQualidadeDefeito;

@Entity
@Table(name = "armas", schema = "game_data")

public class GameArma implements Serializable {
	
	private static final long serialVersionUID = -1049521503029370946L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "arma_seq")
	@SequenceGenerator(schema = "game_data", name = "arma_seq", sequenceName = "arma_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_arma")
	private Long id;
	
	@JsonProperty("nome")
	@Column(name = "nome", nullable = false, length = 20)
	private String nome;
	
	@JsonProperty("descricao")
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@JsonProperty("reqFRC")
	@Column(name = "reqFRC", nullable = false, updatable = true, columnDefinition = "int2")
	private int reqFRC;
	
	@JsonProperty("reqAGL")
	@Column(name = "reqAGL", nullable = false, updatable = true, columnDefinition = "int2")
	private int reqAGL;
	
	@JsonProperty("reqATN")
	@Column(name = "reqATN", nullable = false, updatable = true, columnDefinition = "int2")
	private int reqATN;
	
	@JsonProperty("valor")
	@Column(nullable = false, name = "valor", precision = 15, scale = 2, columnDefinition = "numeric(15,2) default 0.00")
	private BigDecimal valor;
	
	@JsonProperty("peso")
	@Column(nullable = false, name = "peso", precision = 10, scale = 2, columnDefinition = "numeric(10,2) default 0.00")
	private BigDecimal peso;
	
	@JsonProperty(value = "tipo")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_arma", nullable = false, length = 2)
	private TipoArma tipo_arma;
	
	@Transient
	private int bonusAtaque;
	
	public GameArma() {
		super();
		// TODO Auto-generated constructor stub
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

	public int getReqFRC() {
		return reqFRC;
	}

	public void setReqFRC(int reqFRC) {
		this.reqFRC = reqFRC;
	}

	public int getReqAGL() {
		return reqAGL;
	}

	public void setReqAGL(int reqAGL) {
		this.reqAGL = reqAGL;
	}

	public int getReqATN() {
		return reqATN;
	}

	public void setReqATN(int reqATN) {
		this.reqATN = reqATN;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getPeso() {
		return peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public TipoArma getTipo_arma() {
		return tipo_arma;
	}

	public void setTipo_arma(TipoArma tipo_arma) {
		this.tipo_arma = tipo_arma;
	}
	
	public int getBonusAtaque() {
		return bonusAtaque;
	}

	public void setBonusAtaque(int bonusAtaque) {
		this.bonusAtaque = bonusAtaque;
	}
	
	


	
}
