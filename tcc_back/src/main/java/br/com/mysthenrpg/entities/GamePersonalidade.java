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

import br.com.mysthenrpg.enuns.TipoCategoriaPersonalidade;
import br.com.mysthenrpg.enuns.TipoGrupoPersonalidade;
import br.com.mysthenrpg.enuns.TipoQualidadeDefeito;

@Entity
@Table(name = "personalidades", schema = "game_data")

public class GamePersonalidade implements Serializable {

	private static final long serialVersionUID = 63834957806381457L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "personalidade_seq")
	@SequenceGenerator(schema = "game_data", name = "personalidade_seq", sequenceName = "personalidade_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_personalidade")
	private Long id;
	
	@JsonProperty(value = "tipo_categoria")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_categoria", nullable = false, length = 3)
	private TipoCategoriaPersonalidade tipoCategoria;
	
	@JsonProperty(value = "tipo_grupo")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo_grupo", nullable = false, length = 2)
	private TipoGrupoPersonalidade tipoGrupo;
	
	@JsonProperty("nome")
	@Column(name = "nome", nullable = false, length = 20)
	private String nome;
	
	@JsonProperty("descricao")
	@Column(name = "descricao", nullable = false, length = 300)
	private String descricao;
	
	public GamePersonalidade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoCategoriaPersonalidade getTipoCategoria() {
		return tipoCategoria;
	}

	public void setTipoCategoria(TipoCategoriaPersonalidade tipoCategoria) {
		this.tipoCategoria = tipoCategoria;
	}

	public TipoGrupoPersonalidade getTipoGrupo() {
		return tipoGrupo;
	}

	public void setTipoGrupo(TipoGrupoPersonalidade tipoGrupo) {
		this.tipoGrupo = tipoGrupo;
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
