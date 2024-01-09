package br.com.mysthenrpg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.GameRaca;

@Repository
public interface GameRacaRepository extends JpaRepository<GameRaca, Long>{
	
	
	static final String FIND_BY_ESPECIE =  "Select"
										   + "     r "
										   + "     from GameRaca as r"
										   + "    where"
										   + "     r.especie.id = :idEspecie";

@Query(value = FIND_BY_ESPECIE, nativeQuery = false)
List<GameRaca> findByEspecie(@Param("idEspecie") Long idEspecie);
	
}
