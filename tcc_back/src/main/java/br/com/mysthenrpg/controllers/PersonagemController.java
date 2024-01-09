package br.com.mysthenrpg.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mysthenrpg.dto.PersonagemDTO;
import br.com.mysthenrpg.entities.CapacidadeGameData;
import br.com.mysthenrpg.entities.GameArma;
import br.com.mysthenrpg.entities.GameCaracteristica;
import br.com.mysthenrpg.entities.GameConhecimento;
import br.com.mysthenrpg.entities.GameEspecie;
import br.com.mysthenrpg.entities.GameEtnia;
import br.com.mysthenrpg.entities.GamePersonalidade;
import br.com.mysthenrpg.entities.GameRaca;
import br.com.mysthenrpg.entities.GameTipoConhecimento;
import br.com.mysthenrpg.entities.GameTreinamento;
import br.com.mysthenrpg.entities.Personagem;
import br.com.mysthenrpg.entities.PersonagemArma;
import br.com.mysthenrpg.entities.PersonagemCaracteristica;
import br.com.mysthenrpg.entities.SalaPersonagem;
import br.com.mysthenrpg.entities.Usuario;
import br.com.mysthenrpg.enuns.TipoQualidadeDefeito;
import br.com.mysthenrpg.exceptions.BadRequestException;
import br.com.mysthenrpg.exceptions.ConstraintViolationException;
import br.com.mysthenrpg.exceptions.RecordDuplicatedException;
import br.com.mysthenrpg.exceptions.RecordNotFoundException;
import br.com.mysthenrpg.filters.CapacidadesPersonagemFilter;
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
import br.com.mysthenrpg.repositories.PersonagemArmaRepository;
import br.com.mysthenrpg.repositories.PersonagemCaracteristicaRepository;
import br.com.mysthenrpg.repositories.PersonagemRepository;
import br.com.mysthenrpg.repositories.SalaPersonagemRepository;
import br.com.mysthenrpg.repositories.UsuarioRepository;
import br.com.mysthenrpg.rules.UsuarioRules;
import br.com.mysthenrpg.util.FieldNotValid;
import br.com.mysthenrpg.util.UtilPassword;

@RestController
@RequestMapping("/api/personagem")
public class PersonagemController {

	@Autowired
	UsuarioRepository usuarioRepository;

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
	SalaPersonagemRepository salaPersonagemRepository;

	@RequestMapping(method = RequestMethod.GET, value = "/{idPersonagem}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonagemDTO> get(@PathVariable Long idPersonagem) throws Exception {

		Usuario usuarioLogado = usuarioRepository.findById(SecurityContextHolder.getContext().getAuthentication().getName());
		Personagem personagem = new Personagem();
		PersonagemDTO personagemCarregado = null;

		try {
			personagem = personagemRepository.findByIdAndUser(idPersonagem, usuarioLogado.getId());
			personagemCarregado = carregaDadosPersonagem(personagem);
		} catch (Exception e) {
			throw new RecordNotFoundException("Personagem não encontrado");
		}

		return ResponseEntity.ok(personagemCarregado);
	}

	@RequestMapping(method = RequestMethod.GET, value = "/list", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<PersonagemDTO>> list() throws Exception {

		List<PersonagemDTO> listaPersonagens = new ArrayList<PersonagemDTO>();

		Usuario usuarioLogado = usuarioRepository
				.findById(SecurityContextHolder.getContext().getAuthentication().getName());

		List<Personagem> personagens = new ArrayList<Personagem>();
		try {
			personagens = personagemRepository.findByUser(usuarioLogado.getId());
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao obter lista de personagens");
		}

		for (Personagem personagem : personagens) {
			PersonagemDTO personagemCarregado = carregaDadosPersonagem(personagem);
			listaPersonagens.add(personagemCarregado);
		}

		return ResponseEntity.ok(listaPersonagens);

	}

	@RequestMapping(method = RequestMethod.POST, value = "/novo", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> create(@RequestBody PersonagemFilter personagem, BindingResult result)
			throws Exception {

		Usuario usuarioLogado = new Usuario();
		try {
			usuarioLogado = usuarioRepository.findByLogin(personagem.getUsuario());
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao verificar usuário");
		}

		GameEspecie especie = new GameEspecie();
		try {
			especie = especieRepository.findById(personagem.getIdEspecie()).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao verificar espécie");
		}

		GameRaca raca = new GameRaca();
		try {
			raca = racaRepository.findById(personagem.getIdRaca()).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao verificar raça");
		}

		GameEtnia etnia = new GameEtnia();
		try {
			etnia = etniaRepository.findById(personagem.getIdEtnia()).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao verificar etnia");
		}

		GameCaracteristica qualidade = new GameCaracteristica();
		try {
			qualidade = caracteristicaRepository.findById(personagem.getIdQualidade()).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao verificar qualidade");
		}

		GameCaracteristica defeito = new GameCaracteristica();
		try {
			defeito = caracteristicaRepository.findById(personagem.getIdDefeito()).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao verificar defeito");
		}

		ArrayList<GameTreinamento> treinamentos = new ArrayList<GameTreinamento>();
		int i = 0;
		for (GameTreinamento treinamento : personagem.getTreinamentos()) {
			try {
				treinamentos.add(treinamentoRepository.findById(personagem.getTreinamentos().get(i).getId()).get());
			} catch (Exception e) {
				throw new RecordNotFoundException("Erro ao verificar defeito");
			}
			i++;
		}

		ArrayList<GameConhecimento> conhecimentos = new ArrayList<GameConhecimento>();
		int z = 0;
		for (GameConhecimento conhecimento : personagem.getConhecimentos()) {
			try {
				conhecimentos.add(conhecimentoRepository.findById(personagem.getConhecimentos().get(z).getId()).get());
			} catch (Exception e) {
				throw new RecordNotFoundException("Erro ao verificar defeito");
			}
			z++;
		}

		if (personagem.getAlternativo() == null) {
			personagem.setAlternativo("");
		}

		if (personagem.getLinhagem() == null) {
			personagem.setLinhagem("");
		}

		return ResponseEntity.ok(personagemRepository.createPersonagem(personagem.getNome(), personagem.getLinhagem(),
				personagem.getAlternativo(), especie, raca, etnia, qualidade, defeito, treinamentos, conhecimentos,
				usuarioLogado));

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
