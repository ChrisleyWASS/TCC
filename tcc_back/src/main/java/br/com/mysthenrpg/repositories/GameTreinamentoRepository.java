package br.com.mysthenrpg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.GameEspecie;
import br.com.mysthenrpg.entities.GameTreinamento;
import br.com.mysthenrpg.entities.Personagem;

@Repository
public interface GameTreinamentoRepository extends JpaRepository<GameTreinamento, Long>{
	
	static final String FIND_BY_PERSONAGEM =  " select"
											+ " gt"
											+ " FROM GameTreinamento as gt"
											+ " INNER JOIN PersonagemTreinamento as pt"
											+ " ON pt.treinamento.id = gt.id"
											+ " WHERE pt.personagem.id = :idPersonagem";
	
	@Query(value = FIND_BY_PERSONAGEM, nativeQuery = false)
	List<GameTreinamento> findByPersonagem(@Param("idPersonagem") Long idPersonagem);
	
}
