package br.com.mysthenrpg.repositories;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mysthenrpg.entities.GameArma;
import br.com.mysthenrpg.entities.GameCaracteristica;
import br.com.mysthenrpg.entities.GameConhecimento;
import br.com.mysthenrpg.entities.GameEspecie;
import br.com.mysthenrpg.entities.GameEtnia;
import br.com.mysthenrpg.entities.GameRaca;
import br.com.mysthenrpg.entities.GameTreinamento;
import br.com.mysthenrpg.entities.Personagem;
import br.com.mysthenrpg.entities.PersonagemArma;
import br.com.mysthenrpg.entities.PersonagemCaracteristica;
import br.com.mysthenrpg.entities.PersonagemConhecimento;
import br.com.mysthenrpg.entities.PersonagemTreinamento;
import br.com.mysthenrpg.entities.Usuario;
import br.com.mysthenrpg.entities.UsuarioPersonagem;

@Repository
public class PersonagemRepositoryCustomImpl implements PersonagemRepositoryCustom{
	
	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	GameArmaRepository gameArmaRepository;

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public Personagem createPersonagem(String nome, String linhagem, String alternativo, GameEspecie especie, GameRaca raca,
			GameEtnia etnia, GameCaracteristica qualidade, GameCaracteristica defeito, ArrayList<GameTreinamento> treinamentos,
			ArrayList<GameConhecimento> conhecimentos, Usuario usuario_criador) throws Exception {
		
		Personagem personagem = new Personagem();
		try {
			personagem.setNome(nome);
			personagem.setLinhagem(linhagem);
			personagem.setAlternativo(alternativo);
			personagem.setEspeciesPersonagem(especie);
			personagem.setRacasPersonagem(raca);
			personagem.setEtniasPersonagem(etnia);
			personagem.setDataCriacao(new Date());
			personagem.setUsuarioCriacao(usuario_criador.getId());
			personagem = entityManager.merge(personagem);
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}
		
		try {
			UsuarioPersonagem usuarioPersonagem = new UsuarioPersonagem(usuario_criador, personagem);
			entityManager.merge(usuarioPersonagem);
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}
		
		try {
			PersonagemCaracteristica personagemQualidade = new PersonagemCaracteristica(personagem, qualidade);
			PersonagemCaracteristica personagemDefeito = new PersonagemCaracteristica(personagem, defeito);
			entityManager.merge(personagemQualidade);
			entityManager.merge(personagemDefeito);
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}
		
		
		for (GameTreinamento treinamento : treinamentos) {
			PersonagemTreinamento personagemTreinamento = new PersonagemTreinamento(personagem, treinamento);
			try {
				entityManager.merge(personagemTreinamento);	
			} catch (Exception e) {
				throw new PersistenceException(e.getMessage());
			}			
		}
		
		for (GameConhecimento conhecimento : conhecimentos) {
			PersonagemConhecimento personagemConhecimento = new PersonagemConhecimento(personagem, conhecimento);
			try {
				entityManager.merge(personagemConhecimento);	
			} catch (Exception e) {
				throw new PersistenceException(e.getMessage());
			}			
		}
		
		try {
			GameArma desarmado = gameArmaRepository.findById((long) 1).get();
			PersonagemArma personagemDesarmado = new PersonagemArma(personagem, desarmado);
			entityManager.merge(personagemDesarmado);
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}

		return personagem;
				
		}
	}