package br.com.mysthenrpg.filters;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.mysthenrpg.entities.Usuario;

public class CapacidadesPersonagemFilter {
	
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
	
	@JsonProperty("id_trein1")
	private Long idTrein1;
	
	@JsonProperty("id_trein2")
	private Long idTrein2;
	
	@JsonProperty("id_trein3")
	private Long idTrein3;

	public CapacidadesPersonagemFilter() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CapacidadesPersonagemFilter(Long idEspecie, Long idRaca, Long idEtnia, Long idQualidade, Long idDefeito,
			Long idTrein1, Long idTrein2, Long idTrein3) {
		super();
		this.idEspecie = idEspecie;
		this.idRaca = idRaca;
		this.idEtnia = idEtnia;
		this.idQualidade = idQualidade;
		this.idDefeito = idDefeito;
		this.idTrein1 = idTrein1;
		this.idTrein2 = idTrein2;
		this.idTrein3 = idTrein3;
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

	public Long getIdTrein1() {
		return idTrein1;
	}

	public void setIdTrein1(Long idTrein1) {
		this.idTrein1 = idTrein1;
	}

	public Long getIdTrein2() {
		return idTrein2;
	}

	public void setIdTrein2(Long idTrein2) {
		this.idTrein2 = idTrein2;
	}

	public Long getIdTrein3() {
		return idTrein3;
	}

	public void setIdTrein3(Long idTrein3) {
		this.idTrein3 = idTrein3;
	}
	
	
//	public idacidadePersonagem calculaidacidades() {
//		idacidadePersonagem idChar = new idacidadePersonagem();
//		idChar.setFRC(idEspecie.getFRC() + idRaca.getFRC() + idQualidade.getFRC() + idDefeito.getFRC() + idTrein1.getFRC() + idTrein2.getFRC() + idTrein3.getFRC());
//		idChar.setMOB(idEspecie.getMOB() + idRaca.getMOB() + idQualidade.getMOB() + idDefeito.getMOB() + idTrein1.getMOB() + idTrein2.getMOB() + idTrein3.getMOB());
//		idChar.setRES(idEspecie.getRES() + idRaca.getRES() + idQualidade.getRES() + idDefeito.getRES() + idTrein1.getRES() + idTrein2.getRES() + idTrein3.getRES());
//		idChar.setAGL(idEspecie.getAGL() + idRaca.getAGL() + idQualidade.getAGL() + idDefeito.getAGL() + idTrein1.getAGL() + idTrein2.getAGL() + idTrein3.getAGL());
//		idChar.setSTZ(idEspecie.getSTZ() + idRaca.getSTZ() + idQualidade.getSTZ() + idDefeito.getSTZ() + idTrein1.getSTZ() + idTrein2.getSTZ() + idTrein3.getSTZ());
//		idChar.setDSV(idEspecie.getDSV() + idRaca.getDSV() + idQualidade.getDSV() + idDefeito.getDSV() + idTrein1.getDSV() + idTrein2.getDSV() + idTrein3.getDSV());
//		idChar.setVIG(idEspecie.getVIG() + idRaca.getVIG() + idQualidade.getVIG() + idDefeito.getVIG() + idTrein1.getVIG() + idTrein2.getVIG() + idTrein3.getVIG());
//		idChar.setTNA(idEspecie.getTNA() + idRaca.getTNA() + idQualidade.getTNA() + idDefeito.getTNA() + idTrein1.getTNA() + idTrein2.getTNA() + idTrein3.getTNA());
//		idChar.setIMD(idEspecie.getIMD() + idRaca.getIMD() + idQualidade.getIMD() + idDefeito.getIMD() + idTrein1.getIMD() + idTrein2.getIMD() + idTrein3.getIMD());
//		idChar.setRAZ(idEspecie.getRAZ() + idRaca.getRAZ() + idQualidade.getRAZ() + idDefeito.getRAZ() + idTrein1.getRAZ() + idTrein2.getRAZ() + idTrein3.getRAZ());
//		idChar.setATN(idEspecie.getATN() + idRaca.getATN() + idQualidade.getATN() + idDefeito.getATN() + idTrein1.getATN() + idTrein2.getATN() + idTrein3.getATN());
//		idChar.setOBT(idEspecie.getOBT() + idRaca.getOBT() + idQualidade.getOBT() + idDefeito.getOBT() + idTrein1.getOBT() + idTrein2.getOBT() + idTrein3.getOBT());
//		idChar.setRET(idEspecie.getRET() + idRaca.getRET() + idQualidade.getRET() + idDefeito.getRET() + idTrein1.getRET() + idTrein2.getRET() + idTrein3.getRET());
//		idChar.setCAR(idEspecie.getCAR() + idRaca.getCAR() + idQualidade.getCAR() + idDefeito.getCAR() + idTrein1.getCAR() + idTrein2.getCAR() + idTrein3.getCAR());
//		idChar.setIMP(idEspecie.getIMP() + idRaca.getIMP() + idQualidade.getIMP() + idDefeito.getIMP() + idTrein1.getIMP() + idTrein2.getIMP() + idTrein3.getIMP());
//		return idChar;
//		
//	}
	
	

	
}
