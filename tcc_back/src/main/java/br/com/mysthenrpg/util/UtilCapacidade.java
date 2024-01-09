package br.com.mysthenrpg.util;

import java.util.ArrayList;
import java.util.List;

import br.com.mysthenrpg.entities.CapacidadeGameData;

public class UtilCapacidade {
	
	private String capacidade;
	
	private String sigla;
	
	private Integer valor;

	public UtilCapacidade(String capacidade, String sigla, Integer valor) {
		super();
		this.capacidade = capacidade;
		this.sigla = sigla;
		this.valor = valor;
	}
	
	public List<UtilCapacidade> listCapacidades(CapacidadeGameData capacidades) {
		
		List<UtilCapacidade> list = new ArrayList<UtilCapacidade>();
		
		list.add(new UtilCapacidade("Força", "FRC", capacidades.getFRC()));
		list.add(new UtilCapacidade("Mobilidade", "MOB", capacidades.getMOB()));
		list.add(new UtilCapacidade("Resistência", "RES", capacidades.getRES()));
		list.add(new UtilCapacidade("Agilidade", "AGL", capacidades.getAGL()));
		list.add(new UtilCapacidade("Desenvoltura", "DSV", capacidades.getDSV()));
		list.add(new UtilCapacidade("Sutileza", "STZ", capacidades.getSTZ()));
		list.add(new UtilCapacidade("Vigor", "VIG", capacidades.getVIG()));
		list.add(new UtilCapacidade("Tenacidade", "TNA", capacidades.getTNA()));
		list.add(new UtilCapacidade("Imunidade", "IMD", capacidades.getIMD()));
		list.add(new UtilCapacidade("Razão", "RAZ", capacidades.getRAZ()));
		list.add(new UtilCapacidade("Obstinação", "OBT", capacidades.getOBT()));
		list.add(new UtilCapacidade("Atenção", "ATN", capacidades.getATN()));
		list.add(new UtilCapacidade("Retórica", "RET", capacidades.getRET()));
		list.add(new UtilCapacidade("Carisma", "CAR", capacidades.getCAR()));
		list.add(new UtilCapacidade("Imposição", "IMP", capacidades.getIMP()));
				
		return list;
		
	}

	public String getCapacidade() {
		return capacidade;
	}

	public void setCapacidade(String capacidade) {
		this.capacidade = capacidade;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public Integer getValor() {
		return valor;
	}

	public void setValor(Integer valor) {
		this.valor = valor;
	}

}
