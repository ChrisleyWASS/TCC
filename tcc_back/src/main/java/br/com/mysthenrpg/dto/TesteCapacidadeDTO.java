package br.com.mysthenrpg.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.mysthenrpg.entities.Personagem;
import br.com.mysthenrpg.entities.Sala;
import br.com.mysthenrpg.entities.Usuario;
import br.com.mysthenrpg.entities.UsuarioPersonagem;

public class TesteCapacidadeDTO {
	
	private int d20;
	private int AD;
	private int bonusCap;
	private int result;
	
	public TesteCapacidadeDTO(int d20, int bonusCap, int AD, int result) {
		super();
		this.d20 = d20;
		this.AD = AD;
		this.bonusCap = bonusCap;
		this.result = result;
	}

	public int getD20() {
		return d20;
	}

	public void setD20(int d20) {
		this.d20 = d20;
	}

	public int getAD() {
		return AD;
	}

	public void setAD(int AD) {
		AD = AD;
	}

	public int getBonusCap() {
		return bonusCap;
	}

	public void setBonusCap(int bonusCap) {
		this.bonusCap = bonusCap;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}
	
}
