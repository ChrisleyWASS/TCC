package br.com.mysthenrpg.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import br.com.mysthenrpg.dto.PersonagemDTO;
import br.com.mysthenrpg.dto.SalaDTO;
import br.com.mysthenrpg.dto.TesteCapacidadeDTO;
import br.com.mysthenrpg.dto.TesteRedutorDTO;
import br.com.mysthenrpg.entities.CapacidadeGameData;
import br.com.mysthenrpg.entities.GameArma;
import br.com.mysthenrpg.entities.GameCaracteristica;
import br.com.mysthenrpg.entities.GameConhecimento;
import br.com.mysthenrpg.entities.GamePersonalidade;
import br.com.mysthenrpg.entities.GameTreinamento;
import br.com.mysthenrpg.entities.Personagem;
import br.com.mysthenrpg.entities.PersonagemCaracteristica;
import br.com.mysthenrpg.entities.Sala;
import br.com.mysthenrpg.entities.SalaLog;
import br.com.mysthenrpg.entities.SalaPersonagem;
import br.com.mysthenrpg.entities.Usuario;
import br.com.mysthenrpg.entities.UsuarioPersonagem;
import br.com.mysthenrpg.enuns.TipoQualidadeDefeito;
import br.com.mysthenrpg.exceptions.BadRequestException;
import br.com.mysthenrpg.exceptions.ConstraintViolationException;
import br.com.mysthenrpg.exceptions.RecordDuplicatedException;
import br.com.mysthenrpg.exceptions.RecordNotFoundException;
import br.com.mysthenrpg.filters.PersonagemFilter;
import br.com.mysthenrpg.filters.TesteRedutorFilter;
import br.com.mysthenrpg.filters.UsuarioUpdateFilter;
import br.com.mysthenrpg.repositories.CapacidadeGameDataRepository;
import br.com.mysthenrpg.repositories.GameArmaRepository;
import br.com.mysthenrpg.repositories.GameCaracteristicaRepository;
import br.com.mysthenrpg.repositories.GameConhecimentoRepository;
import br.com.mysthenrpg.repositories.GameEspecieRepository;
import br.com.mysthenrpg.repositories.GameEtniaRepository;
import br.com.mysthenrpg.repositories.GamePersonalidadeRepository;
import br.com.mysthenrpg.repositories.GameRacaRepository;
import br.com.mysthenrpg.repositories.GameTipoConhecimentoRepository;
import br.com.mysthenrpg.repositories.GameTreinamentoRepository;
import br.com.mysthenrpg.repositories.PersonagemCaracteristicaRepository;
import br.com.mysthenrpg.repositories.PersonagemRepository;
import br.com.mysthenrpg.repositories.SalaLogRepository;
import br.com.mysthenrpg.repositories.SalaPersonagemRepository;
import br.com.mysthenrpg.repositories.SalaRepository;
import br.com.mysthenrpg.repositories.UsuarioPersonagemRepository;
import br.com.mysthenrpg.repositories.UsuarioRepository;
import br.com.mysthenrpg.rules.UsuarioRules;
import br.com.mysthenrpg.util.FieldNotValid;
import br.com.mysthenrpg.util.UtilDices;
import br.com.mysthenrpg.util.UtilPassword;

@RestController
@RequestMapping("api/teste")
public class TesteController {

	@Autowired
	SalaRepository salaRepository;

	@Autowired
	SalaPersonagemRepository salaPersonagemRepository;

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioPersonagemRepository usuarioPersonagemRepository;

	@Autowired
	PersonagemRepository personagemRepository;

	@Autowired
	GameEspecieRepository especieRepository;

	@Autowired
	GameRacaRepository racaRepository;

	@Autowired
	GameEtniaRepository etniaRepository;

	@Autowired
	GameCaracteristicaRepository caracteristicaRepository;

	@Autowired
	GameTreinamentoRepository treinamentoRepository;

	@Autowired
	GameTipoConhecimentoRepository tipoConhecimentoRepository;

	@Autowired
	GameConhecimentoRepository conhecimentoRepository;

	@Autowired
	GamePersonalidadeRepository personalidadeRepository;

	@Autowired
	GameArmaRepository gameArmaRepository;

	@Autowired
	CapacidadeGameDataRepository capacidadeGameDataRepository;

	@Autowired
	PersonagemCaracteristicaRepository personagemCaracteristicaRepository;
	
	@Autowired
	SalaLogRepository salaLogRepository;

	private final List<SseEmitter> emitters = new ArrayList<>();

	@RequestMapping(method = RequestMethod.GET, value = "/capacidade/{idSala}/{idPersonagem}/{tipo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TesteCapacidadeDTO> testeCapacidade(@PathVariable Long idSala, @PathVariable Long idPersonagem, @PathVariable String tipo) throws Exception {

		UtilDices roll = new UtilDices();		

		Sala sala = new Sala();
		try {
			sala = salaRepository.findById(idSala).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Sala não encontrada");
		}

		Usuario usuarioLogado = usuarioRepository.findById(SecurityContextHolder.getContext().getAuthentication().getName());
		PersonagemDTO personagemCarregado = null;
		try {
			personagemCarregado = carregaDadosPersonagem(
					personagemRepository.findByIdAndUser(idPersonagem, usuarioLogado.getId()));
		} catch (Exception e) {
			throw new RecordNotFoundException("Personagem não encontrado");
		}

		int d20 = roll.d20();
		int AD = personagemCarregado.getSalaPersonagem().calculaAdversidade();

		int bonusCap = 0;
		if (tipo.equals("FRC")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getFRC();
		} else if (tipo.equals("MOB")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getMOB();
		} else if (tipo.equals("RES")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getRES();
		} else if (tipo.equals("AGL")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getAGL();
		} else if (tipo.equals("DSV")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getDSV();
		} else if (tipo.equals("STZ")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getSTZ();
		} else if (tipo.equals("TNA")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getTNA();
		} else if (tipo.equals("VIG")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getVIG();
		} else if (tipo.equals("IMD")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getIMD();
		} else if (tipo.equals("RAZ")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getRAZ();
		} else if (tipo.equals("ATN")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getATN();
		} else if (tipo.equals("OBT")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getOBT();
		} else if (tipo.equals("RET")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getRET();
		} else if (tipo.equals("CAR")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getCAR();
		} else if (tipo.equals("IMP")) {
			bonusCap = personagemCarregado.getBonusCapacidades().getIMP();
		}
		
		int result = (d20 + bonusCap);		
		TesteCapacidadeDTO testeCapacidade = new TesteCapacidadeDTO(d20, bonusCap + AD, AD, result);
		
		String prefix = "";
		if(d20 == 1) {
			prefix = "ERRO CRÍTICO ";
		}
		if(d20 == 20) {
			prefix = "CRÍTICO ";
		}
		
		SalaLog log = new SalaLog(prefix + tipo + " " + result + " - " + personagemCarregado.getNome() + " " + personagemCarregado.getLinhagem(), new Date(), sala);
		try {
			salaLogRepository.save(log);
		} catch (Exception e) {
			throw new BadRequestException("Erro ao registrar operação");
		}
		
		SSEController sse = new SSEController();
		sse.udateSala(idSala);
		
		return ResponseEntity.ok(testeCapacidade);

	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/redutor/{idSala}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TesteRedutorDTO>> testeRedutor(@PathVariable Long idSala, @RequestBody TesteRedutorFilter teste) throws Exception {			
		
		List<TesteRedutorDTO> listResultados = new ArrayList<TesteRedutorDTO>();		
		String msgResult = "";
		
		Sala sala = new Sala();
		try {
			sala = salaRepository.findById(idSala).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Sala não encontrada");
		}
		
		if(teste.getIdPersonagens().isEmpty()) {
			throw new BadRequestException("Lista de personagens não informada");		
		}
		
		if(teste.getTipo().isBlank()) {
			throw new BadRequestException("Tipo não informado");
		}
		
		String tipo = teste.getTipo();		
		
		for (Long idPersonagem : teste.getIdPersonagens()) {
			
			PersonagemDTO personagemCarregado = null;
			try {
				personagemCarregado = carregaDadosPersonagem(personagemRepository.findById(idPersonagem).get());
			} catch (Exception e) {
				throw new RecordNotFoundException("Personagem não encontrado");
			}
			
			UtilDices roll = new UtilDices();
			int d20 = roll.d20();
			
			int AD = personagemCarregado.getSalaPersonagem().calculaAdversidade();
			
			int bonusCap = 0;
			if (tipo.equals("FRC")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getFRC();
			} else if (tipo.equals("MOB")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getMOB();
			} else if (tipo.equals("RES")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getRES();
			} else if (tipo.equals("AGL")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getAGL();
			} else if (tipo.equals("DSV")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getDSV();
			} else if (tipo.equals("STZ")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getSTZ();
			} else if (tipo.equals("TNA")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getTNA();
			} else if (tipo.equals("VIG")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getVIG();
			} else if (tipo.equals("IMD")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getIMD();
			} else if (tipo.equals("RAZ")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getRAZ();
			} else if (tipo.equals("ATN")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getATN();
			} else if (tipo.equals("OBT")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getOBT();
			} else if (tipo.equals("RET")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getRET();
			} else if (tipo.equals("CAR")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getCAR();
			} else if (tipo.equals("IMP")) {
				bonusCap = personagemCarregado.getBonusCapacidades().getIMP();
			}
			
			int result = (d20 + bonusCap);	
			
			String log  = " ";
			String prefix = " ";
			int valorRedutor = 1;
			if(d20 == 1) {
				prefix = " ERRO CRÍTICO ";
				valorRedutor = 2;
			}
			if(d20 == 20) {
				prefix = " CRÍTICO ";
			}			
			
			if(result >= teste.getDificuldade()) {
				msgResult = "Resistiu ";
				log = msgResult + teste.getRedutor() + " (ND" + teste.getDificuldade() + ")" + prefix + result + " - " + personagemCarregado.getNome() + " " + personagemCarregado.getLinhagem();				
			} else {
				msgResult = "Sucumbiu ";
				log = msgResult + teste.getRedutor() + " (ND" + teste.getDificuldade() + ")" + prefix + result + " - " + personagemCarregado.getNome() + " " + personagemCarregado.getLinhagem();
				
				if(teste.getRedutor().equals("POSTURA")) {
					int valor = valorRedutor + personagemCarregado.getSalaPersonagem().getRedutorPostura();
					personagemCarregado.getSalaPersonagem().setRedutorPostura(valor);
				} else if(teste.getRedutor().equals("CANSACO")) {
					int valor = valorRedutor + personagemCarregado.getSalaPersonagem().getRedutorCansaco();
					personagemCarregado.getSalaPersonagem().setRedutorCansaco(valor);
				} else if(teste.getRedutor().equals("ESTRESSE")) {
					int valor = valorRedutor + personagemCarregado.getSalaPersonagem().getRedutorEstresse();
					personagemCarregado.getSalaPersonagem().setRedutorEstresse(valor);
				} else if(teste.getRedutor().equals("NECESSIDADE")) {
					int valor = valorRedutor + personagemCarregado.getSalaPersonagem().getRedutorNecessidade();
					personagemCarregado.getSalaPersonagem().setRedutorNecessidade(valor);
				} else if(teste.getRedutor().equals("FERIMENTO")) {
					int valor = valorRedutor + personagemCarregado.getSalaPersonagem().getRedutorFerimento();
					personagemCarregado.getSalaPersonagem().setRedutorFerimento(valor);
				} else if(teste.getRedutor().equals("CONTAMINACAO")) {
					int valor = valorRedutor + personagemCarregado.getSalaPersonagem().getRedutorContaminacao();
					personagemCarregado.getSalaPersonagem().setRedutorContaminacao(valor);
				}							
								
			}

			salaLogRepository.saveRedutor(personagemCarregado.getSalaPersonagem(), log);
			TesteRedutorDTO testeRedutor = new TesteRedutorDTO(teste.getRedutor(), tipo, d20, AD, bonusCap + AD, result, personagemCarregado.getNome(), msgResult);
			listResultados.add(testeRedutor);
		}
		
		SSEController sse = new SSEController();
		sse.udateSala(idSala);
					
		return ResponseEntity.ok(listResultados);
		
	}


	private PersonagemDTO carregaDadosPersonagem(Personagem personagem) {

		PersonagemCaracteristica qualidade = personagemCaracteristicaRepository
				.findByPersonagemAndTipo(personagem.getId(), TipoQualidadeDefeito.Q);
		PersonagemCaracteristica defeito = personagemCaracteristicaRepository
				.findByPersonagemAndTipo(personagem.getId(), TipoQualidadeDefeito.D);
		List<GameTreinamento> treinamentos = treinamentoRepository.findByPersonagem(personagem.getId());
		List<GamePersonalidade> personalidade = personalidadeRepository.findByPersonagem(personagem.getId());
		List<GameConhecimento> conhecimentos = conhecimentoRepository.findByPersonagem(personagem.getId());
		List<GameArma> armas = gameArmaRepository.findByPersonagem(personagem.getId());

		Object somaCapacidades = capacidadeGameDataRepository.getSomaCapacidades(
				personagem.getEspeciesPersonagem().getCapacidades().getId(),
				personagem.getRacasPersonagem().getCapacidades().getId(),
				qualidade.getCaracteristica().getCapacidades().getId(),
				defeito.getCaracteristica().getCapacidades().getId(), treinamentos.get(0).getCapacidades().getId(),
				treinamentos.get(1).getCapacidades().getId(), treinamentos.get(2).getCapacidades().getId());

		CapacidadeGameData capacidadesSomadas = new CapacidadeGameData(somaCapacidades);

		SalaPersonagem salaPersonagem = null;
		try {
			salaPersonagem = salaPersonagemRepository.findByPersonagem(personagem.getId());
			if (salaPersonagem == null) {
				salaPersonagem = new SalaPersonagem();
			}
		} catch (Exception e) {
			throw new BadRequestException("Erro ao verificar sala");
		}

		PersonagemDTO personagemCarregado = new PersonagemDTO(personagem, qualidade, defeito, treinamentos,
				personalidade, conhecimentos, armas, capacidadesSomadas, salaPersonagem);

		return personagemCarregado;

	}
	
	

}
