package br.com.mysthenrpg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import br.com.mysthenrpg.entities.GameConhecimento;
import br.com.mysthenrpg.entities.GameTipoConhecimento;
import br.com.mysthenrpg.entities.GameTreinamento;

@Repository
public interface GameConhecimentoRepository extends JpaRepository<GameConhecimento, Long>{
	
	static final String FIND_BY_TIPO =   "Select"
			   + "     c "
			   + "     from GameConhecimento as c"
			   + "    where"
			   + "    c.tipo.id = :tipo";
	
	static final String FIND_BY_PERSONAGEM =  
      " select"
	+ " gc"
	+ " FROM GameConhecimento as gc"
	+ " INNER JOIN PersonagemConhecimento as pc"
	+ " ON pc.conhecimento.id = gc.id"
	+ " WHERE pc.personagem.id = :idPersonagem";


@Query(value = FIND_BY_TIPO, nativeQuery = false)
List<GameConhecimento> findByTipo(@Param("tipo") Long tipo);


@Query(value = FIND_BY_PERSONAGEM, nativeQuery = false)
List<GameConhecimento> findByPersonagem(@Param("idPersonagem") Long idPersonagem);
	
}
