package br.com.mysthenrpg.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "capacidades_game_data", schema = "capacidade")

public class CapacidadeGameData implements Serializable {

	private static final long serialVersionUID = -5246780261063872564L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "capacidade_game_data_seq")
	@SequenceGenerator(schema = "capacidade", name = "capacidade_game_data_seq", sequenceName = "capacidade_game_data_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_capacidade")
	private Long id;
	
	@JsonProperty("descricao")
	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@JsonProperty("FRC")
	@Column(name = "FORCA", nullable = false, updatable = true, columnDefinition = "int2")
	private int FRC;
	
	@JsonProperty("MOB")
	@Column(name = "MOBILIDADE", nullable = false, updatable = true, columnDefinition = "int2")
	private int MOB;
	
	@JsonProperty("RES")
	@Column(name = "RESISTENCIA", nullable = false, updatable = true, columnDefinition = "int2")
	private int RES;
	
	@JsonProperty("AGL")
	@Column(name = "AGILIDADE", nullable = false, updatable = true, columnDefinition = "int2")
	private int AGL;
	
	@JsonProperty("STZ")
	@Column(name = "SUTILEZA", nullable = false, updatable = true, columnDefinition = "int2")
	private int STZ;
	
	@JsonProperty("DSV")
	@Column(name = "DESENVOLTURA", nullable = false, updatable = true, columnDefinition = "int2")
	private int DSV;
	
	@JsonProperty("TNA")
	@Column(name = "TENACIDADE", nullable = false, updatable = true, columnDefinition = "int2")
	private int TNA;
	
	@JsonProperty("VIG")
	@Column(name = "VIGOR", nullable = false, updatable = true, columnDefinition = "int2")
	private int VIG;
	
	@JsonProperty("IMD")
	@Column(name = "IMUNIDADE", nullable = false, updatable = true, columnDefinition = "int2")
	private int IMD;
	
	@JsonProperty("RAZ")
	@Column(name = "RAZAO", nullable = false, updatable = true, columnDefinition = "int2")
	private int RAZ;
	
	@JsonProperty("ATN")
	@Column(name = "ATENCAO", nullable = false, updatable = true, columnDefinition = "int2")
	private int ATN;
	
	@JsonProperty("OBT")
	@Column(name = "OBSTINACAO", nullable = false, updatable = true, columnDefinition = "int2")
	private int OBT;
	
	@JsonProperty("RET")
	@Column(name = "RETORICA", nullable = false, updatable = true, columnDefinition = "int2")
	private int RET;
	
	@JsonProperty("CAR")
	@Column(name = "CARISMA", nullable = false, updatable = true, columnDefinition = "int2")
	private int CAR;
	
	@JsonProperty("IMP")
	@Column(name = "IMPOSICAO", nullable = false, updatable = true, columnDefinition = "int2")
	private int IMP;

	public CapacidadeGameData() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public CapacidadeGameData(Object capacidade) {
		Object[] capacidades = (Object[]) capacidade;
		this.FRC = Long.valueOf((Long) capacidades[0]).intValue();
		this.MOB = Long.valueOf((Long) capacidades[1]).intValue();
		this.RES = Long.valueOf((Long) capacidades[2]).intValue();
		this.AGL = Long.valueOf((Long) capacidades[3]).intValue();
		this.STZ = Long.valueOf((Long) capacidades[4]).intValue();
		this.DSV = Long.valueOf((Long) capacidades[5]).intValue();
		this.TNA = Long.valueOf((Long) capacidades[6]).intValue();
		this.VIG = Long.valueOf((Long) capacidades[7]).intValue();
		this.IMD = Long.valueOf((Long) capacidades[8]).intValue();
		this.RAZ = Long.valueOf((Long) capacidades[9]).intValue();
		this.ATN = Long.valueOf((Long) capacidades[10]).intValue();
		this.OBT = Long.valueOf((Long) capacidades[11]).intValue();
		this.RET = Long.valueOf((Long) capacidades[12]).intValue();
		this.CAR = Long.valueOf((Long) capacidades[13]).intValue();
		this.IMP = Long.valueOf((Long) capacidades[14]).intValue();
				
	}

	public CapacidadeGameData somaCapacidades(CapacidadeGameData capAdd) {
		
		this.descricao = this.descricao + capAdd.getDescricao();
		this.FRC += capAdd.getFRC();
		this.MOB += capAdd.getMOB();
		this.RES += capAdd.getRES();
		this.AGL += capAdd.getAGL();
		this.STZ += capAdd.getSTZ();
		this.DSV += capAdd.getDSV();
		this.TNA += capAdd.getTNA();
		this.VIG += capAdd.getVIG();
		this.IMD += capAdd.getIMD();
		this.RAZ += capAdd.getRAZ();
		this.ATN += capAdd.getATN();
		this.OBT += capAdd.getOBT();
		this.RET += capAdd.getRET();
		this.CAR += capAdd.getCAR();
		this.IMP += capAdd.getIMP();
		
		return this;
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getFRC() {
		return FRC;
	}

	public void setFRC(int frc) {
		FRC = frc;
	}

	public int getMOB() {
		return MOB;
	}

	public void setMOB(int mob) {
		MOB = mob;
	}

	public int getRES() {
		return RES;
	}

	public void setRES(int res) {
		RES = res;
	}

	public int getAGL() {
		return AGL;
	}

	public void setAGL(int agl) {
		AGL = agl;
	}

	public int getSTZ() {
		return STZ;
	}

	public void setSTZ(int stz) {
		STZ = stz;
	}

	public int getDSV() {
		return DSV;
	}

	public void setDSV(int dsv) {
		DSV = dsv;
	}

	public int getTNA() {
		return TNA;
	}

	public void setTNA(int tna) {
		TNA = tna;
	}

	public int getVIG() {
		return VIG;
	}

	public void setVIG(int vig) {
		VIG = vig;
	}

	public int getIMD() {
		return IMD;
	}

	public void setIMD(int imd) {
		IMD = imd;
	}

	public int getRAZ() {
		return RAZ;
	}

	public void setRAZ(int raz) {
		RAZ = raz;
	}

	public int getATN() {
		return ATN;
	}

	public void setATN(int atn) {
		ATN = atn;
	}

	public int getOBT() {
		return OBT;
	}

	public void setOBT(int obt) {
		OBT = obt;
	}

	public int getRET() {
		return RET;
	}

	public void setRET(int ret) {
		RET = ret;
	}

	public int getCAR() {
		return CAR;
	}

	public void setCAR(int car) {
		CAR = car;
	}

	public int getIMP() {
		return IMP;
	}

	public void setIMP(int imp) {
		IMP = imp;
	}

	
}
