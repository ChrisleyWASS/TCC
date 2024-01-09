package br.com.mysthenrpg.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpMethod;
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
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import br.com.mysthenrpg.dto.PersonagemDTO;
import br.com.mysthenrpg.dto.SalaDTO;
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

@RestController
@RequestMapping("api/salas")
public class SalaController {

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
    	
	@RequestMapping(method = RequestMethod.GET, value = "/{idSala}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SalaDTO> get(@PathVariable Long idSala) throws Exception {
		
		Usuario usuarioLogado = usuarioRepository.findById(SecurityContextHolder.getContext().getAuthentication().getName());		
		Sala sala = new Sala();
		
		try {
			sala =  salaRepository.findById(idSala).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Sala não encontrada");
		}
		
		Pageable limit = PageRequest.of(0, 50, Sort.by("id").descending());
		List<SalaLog> logs = salaLogRepository.findBySala(idSala, limit);
		List<UsuarioPersonagem> solicitacoes = usuarioPersonagemRepository.findSolicitacoes(idSala);
		List<UsuarioPersonagem> autorizados = usuarioPersonagemRepository.findAprovados(idSala);
				
		List<Personagem> personagens = salaPersonagemRepository.findPersonagens(idSala);
		List<PersonagemDTO> listPersonagens = new ArrayList<PersonagemDTO>();
		for (Personagem personagem : personagens) {				
			listPersonagens.add(carregaDadosPersonagem(personagem));		
		}
				
		SalaDTO salaCarregada = new SalaDTO(sala, solicitacoes, autorizados, listPersonagens, logs); 				
		return ResponseEntity.ok(salaCarregada);
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/byPersonagem/{idPersonagem}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SalaDTO> getbyPersonagem(@PathVariable Long idPersonagem) throws Exception {
		
		Usuario usuarioLogado = usuarioRepository.findById(SecurityContextHolder.getContext().getAuthentication().getName());		
		Sala sala = new Sala();
		
		try {
			sala =  salaRepository.findByPersonagem(idPersonagem);
		} catch (Exception e) {
			throw new RecordNotFoundException("Sala não encontrada");
		}
		
		SalaDTO salaCarregada = new SalaDTO();
		
		if(sala != null) {					
			List<Personagem> personagens = salaPersonagemRepository.findPersonagens(sala.getId());
			List<PersonagemDTO> listPersonagens = new ArrayList<PersonagemDTO>();
			for (Personagem personagem : personagens) {				
				listPersonagens.add(carregaDadosPersonagem(personagem));		
			}					
			salaCarregada = new SalaDTO(sala, null, null, listPersonagens, null); 			
		}		
						
		return ResponseEntity.ok(salaCarregada);
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/novo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Sala> create(@RequestBody Sala sala) throws Exception {
		
		Usuario usuarioLogado = usuarioRepository.findById(SecurityContextHolder.getContext().getAuthentication().getName());
		
		if((sala.getNome().isBlank()) || (sala.getNome().isEmpty()) || (sala.getNome() == null)) {
			throw new BadRequestException("Nome de sala inválido");
		}
		
		if((sala.getCodigo().isBlank()) || (sala.getCodigo().isEmpty()) || (sala.getCodigo() == null)) {
			throw new BadRequestException("Código de sala inválido");
		}

		Sala currentSala = salaRepository.findByCodigo(sala.getCodigo());
		if(currentSala != null) {
			throw new RecordNotFoundException("Código indisponível");
		}
				
		sala.setMestre(usuarioLogado);
		sala.setUsuarioCriacao(usuarioLogado.getId());
		sala.setDataCriacao(new Date());
				
		salaRepository.save(sala);
			
		return ResponseEntity.ok(sala);		
	}
	
	@RequestMapping(value = {"/list"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Sala>> list() throws Exception {
		
		Usuario usuarioLogado = usuarioRepository.findById(SecurityContextHolder.getContext().getAuthentication().getName());
		
		List<Sala> salas = new ArrayList<Sala>();
		try {
			salas = salaRepository.findByUsuario(usuarioLogado.getId());
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao obter salas.");
		}				
		 			
		return ResponseEntity.ok(salas);
	}
	
	private PersonagemDTO carregaDadosPersonagem(Personagem personagem) {
			
			PersonagemCaracteristica qualidade = personagemCaracteristicaRepository.findByPersonagemAndTipo(personagem.getId(), TipoQualidadeDefeito.Q);
			PersonagemCaracteristica defeito = personagemCaracteristicaRepository.findByPersonagemAndTipo(personagem.getId(), TipoQualidadeDefeito.D);
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
	
			PersonagemDTO personagemCarregado = new PersonagemDTO(personagem, 
																  qualidade, 
																  defeito, 
																  treinamentos,
																  personalidade, 
																  conhecimentos, 
																  armas, 
																  capacidadesSomadas, 
																  salaPersonagem);
			
			return personagemCarregado;
			
		}
	
}
