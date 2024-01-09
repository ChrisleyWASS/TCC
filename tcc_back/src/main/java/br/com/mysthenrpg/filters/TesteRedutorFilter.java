package br.com.mysthenrpg.filters;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.mysthenrpg.entities.Usuario;

public class TesteRedutorFilter {
	
	@JsonProperty("redutor")
	private String redutor;	
	
	@JsonProperty("tipo")
	private String tipo;
	
	@JsonProperty("dificuldade")
	private int dificuldade;
	
	@JsonProperty("idsPersonagens")
	private List<Long> idPersonagens;

	public TesteRedutorFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TesteRedutorFilter(String redutor, String tipo, int dificuldade, List<Long> idPersonagens) {
		super();
		this.redutor = redutor;
		this.tipo = tipo;
		this.dificuldade = dificuldade;
		this.idPersonagens = idPersonagens;
	}

	public String getRedutor() {
		return redutor;
	}

	public void setRedutor(String redutor) {
		this.redutor = redutor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getDificuldade() {
		return dificuldade;
	}

	public void setDificuldade(int dificuldade) {
		this.dificuldade = dificuldade;
	}

	public List<Long> getIdPersonagens() {
		return idPersonagens;
	}

	public void setIdPersonagens(List<Long> idPersonagens) {
		this.idPersonagens = idPersonagens;
	}

}
