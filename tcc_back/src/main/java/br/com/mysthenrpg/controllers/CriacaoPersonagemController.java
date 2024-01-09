package br.com.mysthenrpg.controllers;

import java.util.ArrayList;
import java.util.Date;
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
import br.com.mysthenrpg.entities.GameCaracteristica;
import br.com.mysthenrpg.entities.GameConhecimento;
import br.com.mysthenrpg.entities.GameEspecie;
import br.com.mysthenrpg.entities.GameEtnia;
import br.com.mysthenrpg.entities.GameRaca;
import br.com.mysthenrpg.entities.GameTipoConhecimento;
import br.com.mysthenrpg.entities.GameTreinamento;
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
import br.com.mysthenrpg.repositories.GameCaracteristicaRepository;
import br.com.mysthenrpg.repositories.GameConhecimentoRepository;
import br.com.mysthenrpg.repositories.GameEspecieRepository;
import br.com.mysthenrpg.repositories.GameEtniaRepository;
import br.com.mysthenrpg.repositories.GameRacaRepository;
import br.com.mysthenrpg.repositories.GameTipoConhecimentoRepository;
import br.com.mysthenrpg.repositories.GameTreinamentoRepository;
import br.com.mysthenrpg.repositories.PersonagemRepository;
import br.com.mysthenrpg.repositories.UsuarioRepository;
import br.com.mysthenrpg.rules.UsuarioRules;
import br.com.mysthenrpg.util.FieldNotValid;
import br.com.mysthenrpg.util.UtilPassword;

@RestController
@RequestMapping("/api/criar")
public class CriacaoPersonagemController {
	
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
	CapacidadeGameDataRepository capacidadeGameDataRepository;	
	
	@RequestMapping(method = RequestMethod.GET, value = "/especie", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GameEspecie> getRacas() throws Exception {
		
		List<GameEspecie> listEspecies = new ArrayList<GameEspecie>();
		try {
			listEspecies.add(especieRepository.findById((long) 1).get());
			listEspecies.add(especieRepository.findById((long) 2).get());
			listEspecies.add(especieRepository.findById((long) 5).get());
			
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao obter a lista de espécies");
		}
		
		try {
			for (GameEspecie especie : listEspecies) {
				
					List<GameRaca> listRacas = racaRepository.findByEspecie(especie.getId());
					especie.setRacas(listRacas);	
					
					for (GameRaca raca : especie.getRacas()) {
						List<GameEtnia> listEtnias = etniaRepository.findByRaca(raca.getId());
						raca.setEtnias(listEtnias);							
					}													
			}
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao obter a lista de raças");
		}
		
		return listEspecies;		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/caracteristica/{tipo}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GameCaracteristica> getCaracteristicas(@PathVariable("tipo") TipoQualidadeDefeito tipo) throws Exception {			
		
		List<GameCaracteristica> listCaracteristicas = new ArrayList<GameCaracteristica>();
		try {
			listCaracteristicas = caracteristicaRepository.findByTipo(tipo);			
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao obter a lista de características");
		}
		
		return listCaracteristicas;		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/treinamentos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GameTreinamento> getTreinamentos() throws Exception {			
		
		List<GameTreinamento> listTreinamentos = new ArrayList<GameTreinamento>();
		try {
			listTreinamentos = treinamentoRepository.findAll(Sort.by("id"));		
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao obter a lista de treinamentos");
		}
		
		return listTreinamentos;		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/conhecimentos", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<GameConhecimento> getConhecimentos() throws Exception {			
		
		List<GameConhecimento> listConhecientos = new ArrayList<GameConhecimento>();
		try {
			listConhecientos = conhecimentoRepository.findAll();		
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao obter tipos de conhecimentos");
		}
		
		return listConhecientos;		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/finalizar", produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonagemDTO getPerson(@RequestBody CapacidadesPersonagemFilter personagem, BindingResult result) throws Exception {
		
		GameEspecie especie = new GameEspecie();
		try {
			especie	= especieRepository.findById(personagem.getIdEspecie()).get();
		} catch (Exception e) {
			throw new BadRequestException("Erro ao obter espécie");
		}
		
		GameRaca raca = new GameRaca();
		try {
			raca = racaRepository.findById(personagem.getIdRaca()).get();
		} catch (Exception e) {
			throw new BadRequestException("Erro ao obter raça");
		}
		
		GameEtnia etnia = new GameEtnia();
		try {
			etnia = etniaRepository.findById(personagem.getIdEtnia()).get();
		} catch (Exception e) {
			throw new BadRequestException("Erro ao obter etnia");
		}
			
		
		GameCaracteristica qualidade = new GameCaracteristica();
		try {
			qualidade = caracteristicaRepository.findById(personagem.getIdQualidade()).get();
		} catch (Exception e) {
			throw new BadRequestException("Erro ao obter qualidade");
		}
			
		
		GameCaracteristica defeito = new GameCaracteristica();
		try {
			defeito	= caracteristicaRepository.findById(personagem.getIdDefeito()).get();
		} catch (Exception e) {
			throw new BadRequestException("Erro ao obter defeito");
		}
			
		
		GameTreinamento Trein1 = new GameTreinamento();
		try {
			Trein1	= treinamentoRepository.findById(personagem.getIdTrein1()).get();
		} catch (Exception e) {
			throw new BadRequestException("Erro ao obter treinamento 1");
		}
		
		GameTreinamento Trein2 = new GameTreinamento();
		try {
			Trein2	= treinamentoRepository.findById(personagem.getIdTrein2()).get();
		} catch (Exception e) {
			throw new BadRequestException("Erro ao obter treinamento 2");
		}
			
		
		GameTreinamento Trein3 = new GameTreinamento();
		try {
			Trein3	= treinamentoRepository.findById(personagem.getIdTrein3()).get();
		} catch (Exception e) {
			throw new BadRequestException("Erro ao obter treinamento 3");
		}
		
		Object somaCapacidades = capacidadeGameDataRepository.getSomaCapacidades(especie.getCapacidades().getId(), 
																						raca.getCapacidades().getId(), 
																						qualidade.getCapacidades().getId(), 
																						defeito.getCapacidades().getId(), 
																						Trein1.getCapacidades().getId(), 
																						Trein2.getCapacidades().getId(), 
																						Trein3.getCapacidades().getId());
		
		
		CapacidadeGameData capacidadesSomadas = new CapacidadeGameData(somaCapacidades);
		
		PersonagemDTO personagemDefult = new PersonagemDTO(null, capacidadesSomadas, especie, raca, etnia, null, null, null);
				
		return personagemDefult;		
		
	}	 	
}
