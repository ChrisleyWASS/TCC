package br.com.mysthenrpg.filters;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.mysthenrpg.entities.GameConhecimento;
import br.com.mysthenrpg.entities.GameTreinamento;
import br.com.mysthenrpg.entities.Usuario;

public class PersonagemFilter {
	
	@JsonProperty("usuario")
	private String usuario;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("nome_linhagem")
	private String linhagem;
	
	@JsonProperty("nome_alternativo")
	private String alternativo;
	
	@JsonProperty("id_especie")
	private Long idEspecie;
	
	@JsonProperty("id_raca")
	private Long idRaca;
	
	@JsonProperty("id_etnia")
	private Long idEtnia;
	
	@JsonProperty("id_qualidade")
	private Long idQualidade;
	
	@JsonProperty("id_defeito")
	private Long idDefeito;
	
	@JsonProperty("treinamentos")
	private ArrayList<GameTreinamento> treinamentos;
	
	@JsonProperty("conhecimentos")
	private ArrayList<GameConhecimento> conhecimentos;

	public PersonagemFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonagemFilter(String usuario, String nome, String linhagem, String alternativo, Long idEspecie,
			Long idRaca, Long idEtnia, Long idQualidade, Long idDefeito, ArrayList<GameTreinamento> treinamentos,
			ArrayList<GameConhecimento> conhecimentos) {
		super();
		this.usuario = usuario;
		this.nome = nome;
		this.linhagem = linhagem;
		this.alternativo = alternativo;
		this.idEspecie = idEspecie;
		this.idRaca = idRaca;
		this.idEtnia = idEtnia;
		this.idQualidade = idQualidade;
		this.idDefeito = idDefeito;
		this.treinamentos = treinamentos;
		this.conhecimentos = conhecimentos;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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

	public Long getIdEspecie() {
		return idEspecie;
	}

	public void setIdEspecie(Long idEspecie) {
		this.idEspecie = idEspecie;
	}

	public Long getIdRaca() {
		return idRaca;
	}

	public void setIdRaca(Long idRaca) {
		this.idRaca = idRaca;
	}

	public Long getIdEtnia() {
		return idEtnia;
	}

	public void setIdEtnia(Long idEtnia) {
		this.idEtnia = idEtnia;
	}

	public Long getIdQualidade() {
		return idQualidade;
	}

	public void setIdQualidade(Long idQualidade) {
		this.idQualidade = idQualidade;
	}

	public Long getIdDefeito() {
		return idDefeito;
	}

	public void setIdDefeito(Long idDefeito) {
		this.idDefeito = idDefeito;
	}

	public ArrayList<GameTreinamento> getTreinamentos() {
		return treinamentos;
	}

	public void setTreinamentos(ArrayList<GameTreinamento> treinamentos) {
		this.treinamentos = treinamentos;
	}

	public ArrayList<GameConhecimento> getConhecimentos() {
		return conhecimentos;
	}

	public void setConhecimentos(ArrayList<GameConhecimento> conhecimentos) {
		this.conhecimentos = conhecimentos;
	}

	
}
