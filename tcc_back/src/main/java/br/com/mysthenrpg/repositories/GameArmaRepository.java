package br.com.mysthenrpg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.GameArma;

@Repository
public interface GameArmaRepository extends JpaRepository<GameArma, Long>{
	
	
	static final String FIND_BY_PERSONAGEM =  " select"
											+ " ga"
											+ " FROM GameArma as ga"
											+ " INNER JOIN PersonagemArma as pa"
											+ " ON pa.arma.id = ga.id"
											+ " WHERE pa.personagem.id = :idPersonagem";
	
@Query(value = FIND_BY_PERSONAGEM, nativeQuery = false)
List<GameArma> findByPersonagem(@Param("idPersonagem") Long idPersonagem);
	
}
