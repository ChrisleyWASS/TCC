package br.com.mysthenrpg.repositories;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.mysthenrpg.entities.Personagem;
import br.com.mysthenrpg.entities.Sala;
import br.com.mysthenrpg.entities.SalaLog;
import br.com.mysthenrpg.entities.SalaPersonagem;
import br.com.mysthenrpg.enuns.AcessoPersonagemSala;
import br.com.mysthenrpg.exceptions.BadRequestException;

@Repository
public class SalaLogRepositoryCustomImpl implements SalaLogRepositoryCustom{
	

	@Autowired
	private EntityManager entityManager;
	
	private void saveLog(String msg, Sala sala) {
		
		SalaLog log = new SalaLog(msg, new Date(), sala);
		try {
			entityManager.merge(log);
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}
		
	}
	
	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public SalaPersonagem saveSolicitacao(SalaPersonagem salaPersonagem, String log) {
		
		try {
			entityManager.merge(salaPersonagem);
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}
		
		try {
			saveLog(log, salaPersonagem.getSala());
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}
		
		return salaPersonagem;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public SalaPersonagem saveAprovacaoAcesso(SalaPersonagem salaPersonagem, String log) {
		
		if(salaPersonagem.getAcesso() == AcessoPersonagemSala.AP) {			
			try {
				entityManager.merge(salaPersonagem);
			} catch (Exception e) {
				throw new PersistenceException(e.getMessage());
			}								
		} else if (salaPersonagem.getAcesso() == AcessoPersonagemSala.NG) {			
			try {
				entityManager.remove(salaPersonagem);
			} catch (Exception e) {
				throw new PersistenceException(e.getMessage());
			}			
		}
		
		try {
			saveLog(log, salaPersonagem.getSala());
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}
		
		return salaPersonagem;
	}

	@Override
	@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
	public void saveRedutor(SalaPersonagem salaPersonagem, String log) {
		
		try {
			entityManager.merge(salaPersonagem);
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}
		
		try {
			saveLog(log, salaPersonagem.getSala());
		} catch (Exception e) {
			throw new PersistenceException(e.getMessage());
		}		
		
	}


	
}
