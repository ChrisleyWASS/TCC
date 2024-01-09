package br.com.mysthenrpg.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
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

import br.com.mysthenrpg.enuns.TipoConhecimento;
import br.com.mysthenrpg.enuns.TipoQualidadeDefeito;

@Entity
@Table(name = "tipos_conhecimentos", schema = "game_data")

public class GameTipoConhecimento implements Serializable {
	
	private static final long serialVersionUID = 1844724386341665788L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tipo_conhecimento_seq")
	@SequenceGenerator(schema = "game_data", name = "tipo_conhecimento_seq", sequenceName = "tipo_conhecimento_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_tipo_conhecimento")
	private Long id;
	
	@JsonProperty("nome")
	@Column(name = "nome", nullable = false, length = 20)
	private String nome;
	
	@JsonProperty("descricao")
	@Column(name = "descricao", nullable = false, length = 300)
	private String descricao;
	
	// Lista das Raças dessa Especie
	@Transient
	private List<GameConhecimento> conhecimentos;

	public GameTipoConhecimento() {
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

	public List<GameConhecimento> getConhecimentos() {
		return conhecimentos;
	}

	public void setConhecimentos(List<GameConhecimento> conhecimentos) {
		this.conhecimentos = conhecimentos;
	}	
		
}
