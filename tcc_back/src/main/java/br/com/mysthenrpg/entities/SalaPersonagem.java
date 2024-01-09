package br.com.mysthenrpg.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.mysthenrpg.enuns.AcessoPersonagemSala;
import br.com.mysthenrpg.enuns.StatusPersonagemSala;

import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Audited
@AuditTable(schema = "auditoria", value = "salas_personagens_auditoria")
@Table(name = "salas_personagens", schema = "sala")
@JsonInclude(Include.NON_NULL)
													
public class SalaPersonagem extends Auditoria implements Serializable {
	private static final long serialVersionUID = -8755401741824620980L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sala_personagem_seq")
	@SequenceGenerator(schema = "sala", name = "sala_personagem_seq", sequenceName = "sala_personagem_seq", allocationSize = 1, initialValue = 2)
	@Column(name = "id_sala_persongem")
	private Long id;
	
	@JsonProperty("situacao")
	@Enumerated(EnumType.STRING)
	@Column(name = "situacao", nullable = false, length = 2)	
	private StatusPersonagemSala situacao;
	
	@JsonProperty("acesso")
	@Enumerated(EnumType.STRING)
	@Column(name = "acesso", nullable = false, length = 2)	
	private AcessoPersonagemSala acesso;

	@JsonProperty("rdt_postura")
	@Column(name = "rdt_postura", nullable = false, updatable = true, columnDefinition = "int2 DEFAULT 0")
	private int redutorPostura;
	
	@JsonProperty("rdt_cansaco")
	@Column(name = "rdt_cansaco", nullable = false, updatable = true, columnDefinition = "int2 DEFAULT 0")
	private int redutorCansaco;
	
	@JsonProperty("rdt_estresse")
	@Column(name = "rdt_estresse", nullable = false, updatable = true, columnDefinition = "int2 DEFAULT 0")
	private int redutorEstresse;
	
	@JsonProperty("rdt_necessidade")
	@Column(name = "rdt_necessidade", nullable = false, updatable = true, columnDefinition = "int2 DEFAULT 0")
	private int redutorNecessidade;
	
	@JsonProperty("rdt_ferimento")
	@Column(name = "rdt_ferimento", nullable = false, updatable = true, columnDefinition = "int2 DEFAULT 0")
	private int redutorFerimento;
	
	@JsonProperty("rdt_contaminacao")
	@Column(name = "rdt_contaminacao", nullable = false, updatable = true, columnDefinition = "int2 DEFAULT 0")
	private int redutorContaminacao;
		
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_personagem", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "personagem_sala_personagem_fk"))
	private Personagem personagem;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_sala", updatable = false, nullable = false, foreignKey = @ForeignKey(name = "sala_sala_personagem_fk"))
	private Sala sala;

	public SalaPersonagem() {
		super();
		this.id = (long) 0;
		this.situacao = StatusPersonagemSala.OF;
		this.acesso = AcessoPersonagemSala.NS;
		this.redutorPostura = 0;
		this.redutorCansaco = 0;
		this.redutorEstresse = 0;
		this.redutorNecessidade = 0;
		this.redutorFerimento = 0;
		this.redutorContaminacao = 0;
		this.personagem = new Personagem();
		this.sala = new Sala();
	}
	
	public SalaPersonagem(AcessoPersonagemSala acesso, Personagem personagem, Sala sala) {
		super();
		this.sala = sala;
		this.acesso = acesso;
		this.personagem = personagem;
		this.situacao = StatusPersonagemSala.OF;
		this.redutorPostura = 0;
		this.redutorCansaco = 0;
		this.redutorEstresse = 0;
		this.redutorNecessidade = 0;
		this.redutorFerimento = 0;
		this.redutorContaminacao = 0;
	}
	
	public SalaPersonagem(Long id, StatusPersonagemSala situacao, AcessoPersonagemSala acesso, int redutorPostura,
			int redutorCansaco, int redutorEstresse, int redutorNecessidade, int redutorFerimento,
			int redutorContaminacao, Personagem personagem, Sala sala) {
		super();
		this.id = id;
		this.situacao = situacao;
		this.acesso = acesso;
		this.redutorPostura = redutorPostura;
		this.redutorCansaco = redutorCansaco;
		this.redutorEstresse = redutorEstresse;
		this.redutorNecessidade = redutorNecessidade;
		this.redutorFerimento = redutorFerimento;
		this.redutorContaminacao = redutorContaminacao;
		this.personagem = personagem;
		this.sala = sala;
	}

	public int calculaAdversidade() {		
		return (redutorPostura + 
				redutorCansaco + 
				redutorEstresse + 
				redutorNecessidade + 
				redutorFerimento + 
				redutorContaminacao);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public StatusPersonagemSala getSituacao() {
		return situacao;
	}

	public void setSituacao(StatusPersonagemSala situacao) {
		this.situacao = situacao;
	}

	public int getRedutorPostura() {
		return redutorPostura;
	}

	public void setRedutorPostura(int redutorPostura) {
		this.redutorPostura = redutorPostura;
	}

	public int getRedutorCansaco() {
		return redutorCansaco;
	}

	public void setRedutorCansaco(int redutorCansaco) {
		this.redutorCansaco = redutorCansaco;
	}

	public int getRedutorEstresse() {
		return redutorEstresse;
	}

	public void setRedutorEstresse(int redutorEstresse) {
		this.redutorEstresse = redutorEstresse;
	}

	public int getRedutorNecessidade() {
		return redutorNecessidade;
	}

	public void setRedutorNecessidade(int redutorNecessidade) {
		this.redutorNecessidade = redutorNecessidade;
	}

	public int getRedutorFerimento() {
		return redutorFerimento;
	}

	public void setRedutorFerimento(int redutorFerimento) {
		this.redutorFerimento = redutorFerimento;
	}

	public int getRedutorContaminacao() {
		return redutorContaminacao;
	}

	public void setRedutorContaminacao(int redutorContaminacao) {
		this.redutorContaminacao = redutorContaminacao;
	}

	public Personagem getPersonagem() {
		return personagem;
	}

	public void setPersonagem(Personagem personagem) {
		this.personagem = personagem;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public AcessoPersonagemSala getAcesso() {
		return acesso;
	}

	public void setAcesso(AcessoPersonagemSala acesso) {
		this.acesso = acesso;
	}
	

}
