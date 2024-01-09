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

public class TesteRedutorDTO {
	
	private String redutor;
	private String sigla;
	private int d20;
	private int AD;
	private int bonusCap;
	private int result;
	private String nome;
	private String msgResult;
	
	public TesteRedutorDTO(String redutor, String sigla, int d20, int aD, int bonusCap, int result, String nome,
			String msgResult) {
		super();
		this.redutor = redutor;
		this.sigla = sigla;
		this.d20 = d20;
		AD = aD;
		this.bonusCap = bonusCap;
		this.result = result;
		this.nome = nome;
		this.msgResult = msgResult;
	}
	public String getRedutor() {
		return redutor;
	}
	public void setRedutor(String redutor) {
		this.redutor = redutor;
	}
	public String getSigla() {
		return sigla;
	}
	public void setSigla(String sigla) {
		this.sigla = sigla;
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
	public void setAD(int aD) {
		AD = aD;
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
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMsgResult() {
		return msgResult;
	}
	public void setMsgResult(String msgResult) {
		this.msgResult = msgResult;
	}
	
	
	
}
