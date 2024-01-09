package br.com.mysthenrpg.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.mysthenrpg.entities.CapacidadeGameData;
import br.com.mysthenrpg.entities.GameArma;
import br.com.mysthenrpg.entities.GameCaracteristica;
import br.com.mysthenrpg.entities.GameConhecimento;
import br.com.mysthenrpg.entities.GameEspecie;
import br.com.mysthenrpg.entities.GameEtnia;
import br.com.mysthenrpg.entities.GamePersonalidade;
import br.com.mysthenrpg.entities.GameRaca;
import br.com.mysthenrpg.entities.GameTreinamento;
import br.com.mysthenrpg.entities.Personagem;
import br.com.mysthenrpg.entities.PersonagemCaracteristica;
import br.com.mysthenrpg.entities.SalaPersonagem;
import br.com.mysthenrpg.enuns.TipoQualidadeDefeito;
import br.com.mysthenrpg.exceptions.BadRequestException;
import br.com.mysthenrpg.repositories.GameCaracteristicaRepository;
import br.com.mysthenrpg.repositories.GameConhecimentoRepository;
import br.com.mysthenrpg.repositories.GameTipoConhecimentoRepository;
import br.com.mysthenrpg.repositories.GameTreinamentoRepository;

public class PersonagemDTO {

	private Long id;
	private String nome;
	private String linhagem;
	private String alternativo;

	private CapacidadeGameData capacidadesPersonagem;
	private GameEspecie especiesPersonagem;
	private GameRaca racasPersonagem;
	private GameEtnia etniasPersonagem;
	private GameCaracteristica qualidade;
	private GameCaracteristica defeito;
	private List<GameTreinamento> treinamentos;
	private List<GameConhecimento> conhecimentos;
	private List<GamePersonalidade> personalidade;

	private List<GameArma> armas;

	private int integridade;
	private int apFisica;
	private int apMental;
	private int deslocamento;
	private int inicitativa;
	private int baseOfensiva;
	private int basePoder;
	private int guarda;
	private int carga;

	private int deslocamentoAtual;
	private int inicitativaAtual;
	private int baseOfensivaAtual;
	private int basePoderAtual;
	private int guardaAtual;
	private int posGuarda;
	private int cargaAtual;

	private CapacidadeGameData BonusCapacidades;
	private List<GameConhecimento> BonusConhecimentos;

	private SalaPersonagem salaPersonagem;

	
	public PersonagemDTO(Long id, CapacidadeGameData capacidadesPersonagem, GameEspecie especiesPersonagem,
			GameRaca racasPersonagem, GameEtnia etniasPersonagem, String nome, String linhagem, String alternativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.linhagem = linhagem;
		this.alternativo = alternativo;

		this.capacidadesPersonagem = capacidadesPersonagem;
		this.especiesPersonagem = especiesPersonagem;
		this.racasPersonagem = racasPersonagem;
		this.etniasPersonagem = etniasPersonagem;

		calculaValoresBase();

	}

	public PersonagemDTO(Personagem personagem, PersonagemCaracteristica qualidade, PersonagemCaracteristica defeito,
			List<GameTreinamento> treinamentos, List<GamePersonalidade> personalidade,
			List<GameConhecimento> conhecimentos, List<GameArma> armas, CapacidadeGameData capacidadesPersonagem,
			SalaPersonagem salaPersonagem) {
		super();

		this.id = personagem.getId();
		this.nome = personagem.getNome();
		this.linhagem = personagem.getLinhagem();
		this.alternativo = personagem.getAlternativo();
		
		if ((personagem.getLinhagem().length() == 0) 
		|| (personagem.getLinhagem() == null)
		|| (personagem.getLinhagem().isBlank())
		|| (personagem.getLinhagem().isEmpty())) {
			this.setLinhagem("");
		}

		if ((personagem.getAlternativo().length() == 0) 
		|| (personagem.getAlternativo() == null)
		|| (personagem.getAlternativo().isBlank())
		|| (personagem.getAlternativo().isEmpty())) {
			this.setAlternativo("");
		}

		this.capacidadesPersonagem = capacidadesPersonagem;
		this.especiesPersonagem = personagem.getEspeciesPersonagem();
		this.racasPersonagem = personagem.getRacasPersonagem();
		this.etniasPersonagem = personagem.getEtniasPersonagem();

		this.setQualidade(qualidade.getCaracteristica());
		this.setDefeito(defeito.getCaracteristica());
		this.setTreinamentos(treinamentos);
		this.setPersonalidade(personalidade);
		this.setConhecimentos(conhecimentos);
		this.setArmas(armas);
		this.setSalaPersonagem(salaPersonagem);

		calculaValoresBase();
		atualizaAdversidade();

	}

	private void atualizaAdversidade() {

		int AD = salaPersonagem.calculaAdversidade();
		calculaBonusCapacidades(AD);
		calculaBonusConhecimentos(AD);
		calculaBonusCombate(AD);
		calculaBonusArmas(AD);

	}

	private void calculaValoresBase() {

		this.apFisica = (capacidadesPersonagem.getFRC() + capacidadesPersonagem.getMOB()
				+ capacidadesPersonagem.getRES() + capacidadesPersonagem.getDSV() + capacidadesPersonagem.getSTZ()
				+ capacidadesPersonagem.getAGL() + capacidadesPersonagem.getVIG() + capacidadesPersonagem.getTNA()
				+ capacidadesPersonagem.getIMD()) / 5;

		this.apMental = (capacidadesPersonagem.getRAZ() + capacidadesPersonagem.getATN()
				+ capacidadesPersonagem.getOBT() + capacidadesPersonagem.getCAR() + capacidadesPersonagem.getRET()
				+ capacidadesPersonagem.getIMP() + capacidadesPersonagem.getVIG() + capacidadesPersonagem.getTNA()
				+ capacidadesPersonagem.getIMD()) / 5;

		this.integridade = this.apFisica + this.apMental;

		this.deslocamento = 8 + capacidadesPersonagem.getMOB() + capacidadesPersonagem.getAGL();

		this.inicitativa = this.integridade + capacidadesPersonagem.getAGL() + capacidadesPersonagem.getATN();

		this.baseOfensiva = this.apFisica + (capacidadesPersonagem.getFRC() + capacidadesPersonagem.getAGL()) / 2;

		this.basePoder = this.apMental + (capacidadesPersonagem.getATN() + capacidadesPersonagem.getOBT()) / 2;

		this.guarda = this.integridade + capacidadesPersonagem.getVIG() + capacidadesPersonagem.getOBT()
				+ capacidadesPersonagem.getATN() + capacidadesPersonagem.getAGL() + capacidadesPersonagem.getDSV()
				+ capacidadesPersonagem.getMOB() + capacidadesPersonagem.getFRC();

		this.carga = 8 + capacidadesPersonagem.getFRC() + capacidadesPersonagem.getRES();

	}

	private void calculaBonusCapacidades(int AD) {

		this.BonusCapacidades = new CapacidadeGameData();

		this.BonusCapacidades.setFRC(this.capacidadesPersonagem.getFRC() + this.apFisica - AD);
		this.BonusCapacidades.setMOB(this.capacidadesPersonagem.getMOB() + this.apFisica - AD);
		this.BonusCapacidades.setRES(this.capacidadesPersonagem.getRES() + this.apFisica - AD);
		this.BonusCapacidades.setAGL(this.capacidadesPersonagem.getAGL() + this.apFisica - AD);
		this.BonusCapacidades.setDSV(this.capacidadesPersonagem.getDSV() + this.apFisica - AD);
		this.BonusCapacidades.setSTZ(this.capacidadesPersonagem.getSTZ() + this.apFisica - AD);

		this.BonusCapacidades.setTNA(this.capacidadesPersonagem.getTNA() + this.integridade - AD);
		this.BonusCapacidades.setVIG(this.capacidadesPersonagem.getVIG() + this.integridade - AD);
		this.BonusCapacidades.setIMD(this.capacidadesPersonagem.getIMD() + this.integridade - AD);

		this.BonusCapacidades.setRAZ(this.capacidadesPersonagem.getRAZ() + this.apMental - AD);
		this.BonusCapacidades.setATN(this.capacidadesPersonagem.getATN() + this.apMental - AD);
		this.BonusCapacidades.setOBT(this.capacidadesPersonagem.getOBT() + this.apMental - AD);
		this.BonusCapacidades.setRET(this.capacidadesPersonagem.getRET() + this.apMental - AD);
		this.BonusCapacidades.setCAR(this.capacidadesPersonagem.getCAR() + this.apMental - AD);
		this.BonusCapacidades.setIMP(this.capacidadesPersonagem.getIMP() + this.apMental - AD);

	}

	private void calculaBonusConhecimentos(int AD) {

		this.BonusConhecimentos = new ArrayList<GameConhecimento>();

		for (GameConhecimento conhecimento : this.conhecimentos) {

			if (this.BonusConhecimentos.isEmpty()) {
				conhecimento.setValor(1);
				this.BonusConhecimentos.add(conhecimento);
			} else {
				if (this.BonusConhecimentos.contains(conhecimento)) {
					int i = this.BonusConhecimentos.indexOf(conhecimento);
					conhecimento.setValor(conhecimento.getValor() + 1);
					this.BonusConhecimentos.set(i, conhecimento);
				} else {
					conhecimento.setValor(1);
					this.BonusConhecimentos.add(conhecimento);
				}
			}
		}
	}

	private void calculaBonusCombate(int AD) {
		this.deslocamentoAtual = this.deslocamento - AD;
		this.inicitativaAtual = this.inicitativa - AD;
		this.baseOfensivaAtual = this.baseOfensiva - AD;
		this.basePoderAtual = this.basePoder - AD;
		this.guardaAtual = this.guarda - AD;
		this.posGuarda = this.guarda + 4 - AD; // Assumindo PROTEÇÃO +4
		this.cargaAtual = this.carga - AD;
	}

	private void calculaBonusArmas(int AD) {
		for (GameArma arma : this.armas) {

			int difFRC = 0;
			int difAGL = 0;
			int difATN = 0;

			if (this.capacidadesPersonagem.getFRC() < arma.getReqFRC()) {
				difFRC = arma.getReqFRC() - this.capacidadesPersonagem.getFRC();
			}

			if (this.capacidadesPersonagem.getAGL() < arma.getReqAGL()) {
				difAGL = arma.getReqAGL() - this.capacidadesPersonagem.getAGL();
			}

			if (this.capacidadesPersonagem.getATN() < arma.getReqATN()) {
				difATN = arma.getReqATN() - this.capacidadesPersonagem.getATN();
			}

			arma.setBonusAtaque(this.baseOfensiva - difFRC - difAGL - difATN);
		}
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

	public CapacidadeGameData getCapacidadesPersonagem() {
		return capacidadesPersonagem;
	}

	public void setCapacidadesPersonagem(CapacidadeGameData capacidadesPersonagem) {
		this.capacidadesPersonagem = capacidadesPersonagem;
	}

	public GameEspecie getEspeciesPersonagem() {
		return especiesPersonagem;
	}

	public void setEspeciesPersonagem(GameEspecie especiesPersonagem) {
		this.especiesPersonagem = especiesPersonagem;
	}

	public GameRaca getRacasPersonagem() {
		return racasPersonagem;
	}

	public void setRacasPersonagem(GameRaca racasPersonagem) {
		this.racasPersonagem = racasPersonagem;
	}

	public GameEtnia getEtniasPersonagem() {
		return etniasPersonagem;
	}

	public void setEtniasPersonagem(GameEtnia etniasPersonagem) {
		this.etniasPersonagem = etniasPersonagem;
	}

	public GameCaracteristica getQualidade() {
		return qualidade;
	}

	public void setQualidade(GameCaracteristica qualidade) {
		this.qualidade = qualidade;
	}

	public GameCaracteristica getDefeito() {
		return defeito;
	}

	public void setDefeito(GameCaracteristica defeito) {
		this.defeito = defeito;
	}

	public List<GameTreinamento> getTreinamentos() {
		return treinamentos;
	}

	public void setTreinamentos(List<GameTreinamento> treinamentos) {
		this.treinamentos = treinamentos;
	}

	public List<GameConhecimento> getConhecimentos() {
		return conhecimentos;
	}

	public void setConhecimentos(List<GameConhecimento> conhecimentos) {
		this.conhecimentos = conhecimentos;
	}

	public List<GamePersonalidade> getPersonalidade() {
		return personalidade;
	}

	public void setPersonalidade(List<GamePersonalidade> personalidade) {
		this.personalidade = personalidade;
	}

	public int getIntegridade() {
		return integridade;
	}

	public void setIntegridade(int integridade) {
		this.integridade = integridade;
	}

	public int getApFisica() {
		return apFisica;
	}

	public void setApFisica(int apFisica) {
		this.apFisica = apFisica;
	}

	public int getApMental() {
		return apMental;
	}

	public void setApMental(int apMental) {
		this.apMental = apMental;
	}

	public int getDeslocamento() {
		return deslocamento;
	}

	public void setDeslocamento(int deslocamento) {
		this.deslocamento = deslocamento;
	}

	public int getInicitativa() {
		return inicitativa;
	}

	public void setInicitativa(int inicitativa) {
		this.inicitativa = inicitativa;
	}

	public int getBaseOfensiva() {
		return baseOfensiva;
	}

	public void setBaseOfensiva(int baseOfensiva) {
		this.baseOfensiva = baseOfensiva;
	}

	public int getBasePoder() {
		return basePoder;
	}

	public void setBasePoder(int basePoder) {
		this.basePoder = basePoder;
	}

	public int getGuarda() {
		return guarda;
	}

	public void setGuarda(int guarda) {
		this.guarda = guarda;
	}

	public int getCarga() {
		return carga;
	}

	public void setCarga(int carga) {
		this.carga = carga;
	}

	public CapacidadeGameData getBonusCapacidades() {
		return BonusCapacidades;
	}

	public void setBonusCapacidades(CapacidadeGameData bonusCapacidades) {
		BonusCapacidades = bonusCapacidades;
	}

	public List<GameConhecimento> getBonusConhecimentos() {
		return BonusConhecimentos;
	}

	public void setBonusConhecimentos(List<GameConhecimento> bonusConhecimentos) {
		BonusConhecimentos = bonusConhecimentos;
	}

	public int getDeslocamentoAtual() {
		return deslocamentoAtual;
	}

	public void setDeslocamentoAtual(int deslocamentoAtual) {
		this.deslocamentoAtual = deslocamentoAtual;
	}

	public int getInicitativaAtual() {
		return inicitativaAtual;
	}

	public void setInicitativaAtual(int inicitativaAtual) {
		this.inicitativaAtual = inicitativaAtual;
	}

	public int getBaseOfensivaAtual() {
		return baseOfensivaAtual;
	}

	public void setBaseOfensivaAtual(int baseOfensivaAtual) {
		this.baseOfensivaAtual = baseOfensivaAtual;
	}

	public int getBasePoderAtual() {
		return basePoderAtual;
	}

	public void setBasePoderAtual(int basePoderAtual) {
		this.basePoderAtual = basePoderAtual;
	}

	public int getGuardaAtual() {
		return guardaAtual;
	}

	public void setGuardaAtual(int guardaAtual) {
		this.guardaAtual = guardaAtual;
	}

	public int getCargaAtual() {
		return cargaAtual;
	}

	public void setCargaAtual(int cargaAtual) {
		this.cargaAtual = cargaAtual;
	}

	public SalaPersonagem getSalaPersonagem() {
		return salaPersonagem;
	}

	public void setSalaPersonagem(SalaPersonagem salaPersonagem) {
		this.salaPersonagem = salaPersonagem;
	}

	public int getPosguarda() {
		return posGuarda;
	}

	public void setPosguarda(int posGuarda) {
		this.posGuarda = posGuarda;
	}

	public List<GameArma> getArmas() {
		return armas;
	}

	public void setArmas(List<GameArma> armas) {
		this.armas = armas;
	}

}
