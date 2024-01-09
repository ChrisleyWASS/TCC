package br.com.mysthenrpg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.GameEtnia;

@Repository
public interface GameEtniaRepository extends JpaRepository<GameEtnia, Long>{
	
	static final String FIND_BY_RACA =  "Select"
			   + "     e "
			   + "     from GameEtnia as e"
			   + "    where"
			   + "     e.raca.id = :idRaca";

@Query(value = FIND_BY_RACA, nativeQuery = false)
List<GameEtnia> findByRaca(@Param("idRaca") Long idRaca);

	
}
