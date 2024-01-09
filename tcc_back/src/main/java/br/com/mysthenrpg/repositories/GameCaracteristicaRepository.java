package br.com.mysthenrpg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.GameCaracteristica;
import br.com.mysthenrpg.enuns.TipoQualidadeDefeito;

@Repository
public interface GameCaracteristicaRepository extends JpaRepository<GameCaracteristica, Long>{
	
	static final String FIND_BY_RACA =   "Select"
									   + "     gc "
									   + "     from GameCaracteristica as gc"
									   + "    where"
									   + "     gc.tipo_qualidade_defeito = :tipo"
									   + "    order by"
									   + "     gc.id";

@Query(value = FIND_BY_RACA, nativeQuery = false)
List<GameCaracteristica> findByTipo(@Param("tipo") TipoQualidadeDefeito tipo);

	
}
