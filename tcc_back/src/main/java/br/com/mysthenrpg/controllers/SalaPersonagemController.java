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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mysthenrpg.dto.PersonagemDTO;
import br.com.mysthenrpg.entities.GameCaracteristica;
import br.com.mysthenrpg.entities.Personagem;
import br.com.mysthenrpg.entities.Sala;
import br.com.mysthenrpg.entities.SalaLog;
import br.com.mysthenrpg.entities.SalaPersonagem;
import br.com.mysthenrpg.entities.Usuario;
import br.com.mysthenrpg.enuns.AcessoPersonagemSala;
import br.com.mysthenrpg.enuns.StatusPersonagemSala;
import br.com.mysthenrpg.enuns.TipoQualidadeDefeito;
import br.com.mysthenrpg.exceptions.BadRequestException;
import br.com.mysthenrpg.exceptions.ConstraintViolationException;
import br.com.mysthenrpg.exceptions.RecordDuplicatedException;
import br.com.mysthenrpg.exceptions.RecordNotFoundException;
import br.com.mysthenrpg.filters.PersonagemFilter;
import br.com.mysthenrpg.filters.UsuarioUpdateFilter;
import br.com.mysthenrpg.repositories.PersonagemRepository;
import br.com.mysthenrpg.repositories.SalaLogRepository;
import br.com.mysthenrpg.repositories.SalaPersonagemRepository;
import br.com.mysthenrpg.repositories.SalaRepository;
import br.com.mysthenrpg.repositories.UsuarioRepository;
import br.com.mysthenrpg.rules.UsuarioRules;
import br.com.mysthenrpg.util.FieldNotValid;
import br.com.mysthenrpg.util.UtilPassword;

@RestController
@RequestMapping("api/salaspersonagens")
public class SalaPersonagemController {

	@Autowired
	SalaRepository salaRepository;
	
	@Autowired
	SalaPersonagemRepository salaPersonagemRepository;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PersonagemRepository personagemRepository;
	
	@Autowired
	SalaLogRepository salaLogRepository;
	
	@RequestMapping(method = RequestMethod.POST, value = "/solicita/{idPersonagem}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SalaPersonagem> create(@RequestBody Sala sala, @PathVariable Long idPersonagem) throws Exception {
		
		Usuario usuarioLogado = usuarioRepository.findById(SecurityContextHolder.getContext().getAuthentication().getName());
		
		Personagem personagem = new Personagem();
		try {
			personagem = personagemRepository.findByIdAndUser(idPersonagem, usuarioLogado.getId());
		} catch (Exception e) {
			throw new RecordNotFoundException("Personagem não encontrado");
		}
		
		SalaPersonagem salaPersonagemAtual = null;
		try {
			salaPersonagemAtual = salaPersonagemRepository.findByPersonagem(idPersonagem);
			if(salaPersonagemAtual != null){
				throw new BadRequestException("Este personagem já solicitou acesso a sala " + salaPersonagemAtual.getSala().getNome());
			}
		} catch (Exception e) {
			throw new BadRequestException("Este personagem já solicitou acesso a sala " + salaPersonagemAtual.getSala().getNome());
		}
		
		try {
			sala = salaRepository.findByCodigo(sala.getCodigo());			
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao verificar sala");
		}
		
		if(sala == null) {
			throw new RecordNotFoundException("Nenhuma sala correspondente a este código");
		}
		
		if(sala.getAtiva() == false) {
			throw new BadRequestException("Sala " + sala.getNome() + " está desativada no momento");
		}
		
		SalaPersonagem salaPersonagem = new SalaPersonagem(AcessoPersonagemSala.SO, personagem, sala);
		salaPersonagem.setUsuarioCriacao(usuarioLogado.getId());
		salaPersonagem.setDataCriacao(new Date());
		
		String log = "SOLICITAÇÃO DE ACESSO -" 
				 + personagem.getNome() + " " 
				 + personagem.getLinhagem() + " " 
				 + personagem.getAlternativo() + " (" 
				 + usuarioLogado.getNome() + ")";
		try {
			salaLogRepository.saveSolicitacao(salaPersonagem, log);
			SSEController sse = new SSEController();
			sse.udateSala(sala.getId());
		} catch (Exception e) {
			throw new BadRequestException("Erro ao registrar operação");
		}
			
		return ResponseEntity.ok(salaPersonagem);		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/aprova/{idSala}/{idPersonagem}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SalaPersonagem> aprovar(@RequestBody Object aprovado, @PathVariable Long idSala,  @PathVariable Long idPersonagem) throws Exception {
		
		Map<String, Object> aprovacao = (Map<String, Object>) aprovado;
		Boolean isAprovado = Boolean.valueOf(aprovacao.get("autorizado").toString());
		
		Usuario usuarioLogado = usuarioRepository.findById(SecurityContextHolder.getContext().getAuthentication().getName());
		
		Sala sala = new Sala();
		try {
			sala = salaRepository.findByIdSalaMestre(idSala, usuarioLogado.getId());			
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao verificar sala");
		}
				
		Personagem personagem = new Personagem();
		try {
			personagem = personagemRepository.findById(idPersonagem).get();
		} catch (Exception e) {
			throw new RecordNotFoundException("Personagem não encontrado");
		}
		
		SalaPersonagem salaPersonagem = new SalaPersonagem();
		try {
			salaPersonagem = salaPersonagemRepository.findBySalaPersonagem(sala.getId(), personagem.getId());
			if(salaPersonagem == null) {
				throw new RecordNotFoundException("Erro ao obter solicitação");
			}
		} catch (Exception e) {
			throw new RecordNotFoundException("Erro ao obter solicitação");
		}		
		
		String log = null;
		if(isAprovado) {
			salaPersonagem.setAcesso(AcessoPersonagemSala.AP);
			log = "ACEITO - " 
					 + personagem.getNome() + " " 
					 + personagem.getLinhagem() + " " 
					 + personagem.getAlternativo() + " (" 
					 + usuarioLogado.getNome() + ") entrou na campanha";
		} else {
			salaPersonagem.setAcesso(AcessoPersonagemSala.NG);
			log = "NEGADO - " 
					 + personagem.getNome() + " " 
					 + personagem.getLinhagem() + " " 
					 + personagem.getAlternativo() + " (" 
					 + usuarioLogado.getNome() + ") não entrou na campanha";
		}
		
		salaPersonagem.setDataAtualizacao(new Date());
		salaPersonagem.setUsuarioAtualizacao(usuarioLogado.getId());
		
		try {
			salaLogRepository.saveAprovacaoAcesso(salaPersonagem, log);
			SSEController sse = new SSEController();
			sse.udateSala(sala.getId());
		} catch (Exception e) {
			throw new BadRequestException("Erro ao registrar operação");
		}
		
		return ResponseEntity.ok(salaPersonagem);		
	}
		

}
