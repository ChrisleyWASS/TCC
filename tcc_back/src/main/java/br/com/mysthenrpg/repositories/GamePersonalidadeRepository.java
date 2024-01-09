package br.com.mysthenrpg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.GamePersonalidade;
import br.com.mysthenrpg.entities.GameTreinamento;
import br.com.mysthenrpg.entities.Personagem;

@Repository
public interface GamePersonalidadeRepository extends JpaRepository<GamePersonalidade, Long>{
	
	static final String FIND_BY_PERSONAGEM =  " select"
											+ " gp"
											+ " FROM GamePersonalidade as gp"
											+ " INNER JOIN PersonagemPersonalidade as pp"
											+ " ON pp.personalidade.id = gp.id"
											+ " WHERE pp.personagem.id = :idPersonagem";
	
	@Query(value = FIND_BY_PERSONAGEM, nativeQuery = false)
	List<GamePersonalidade> findByPersonagem(@Param("idPersonagem") Long idPersonagem);
	
}
