package br.com.mysthenrpg.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.Personagem;
import br.com.mysthenrpg.entities.Sala;
import br.com.mysthenrpg.entities.SalaLog;
import br.com.mysthenrpg.entities.SalaPersonagem;

@Repository
public interface SalaLogRepositoryCustom{
	
	public SalaPersonagem saveSolicitacao(SalaPersonagem salaPersonagem, String log);
	
	public SalaPersonagem saveAprovacaoAcesso(SalaPersonagem salaPersonagem, String log);
	
	public void saveRedutor(SalaPersonagem salaPersonagem, String log);
	
}
