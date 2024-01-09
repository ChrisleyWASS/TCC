package br.com.mysthenrpg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.Personagem;
import br.com.mysthenrpg.entities.Sala;
import br.com.mysthenrpg.entities.SalaPersonagem;
import br.com.mysthenrpg.entities.Usuario;

@Repository
public interface SalaPersonagemRepository extends JpaRepository<SalaPersonagem, Long>{
	
	static final String FIND_BY_PERSONAGEM =  
									  "Select"
									+ "     sp "
									+ "     from SalaPersonagem as sp"
									+ "    where"
									+ "     sp.personagem.id = :idPersonagem";
	
	static final String FIND_SOLICITACOES =  
			  "Select"
			+ "     p "
			+ "    FROM Personagem as p"
			+ "    INNER JOIN SalaPersonagem as sp"
			+ "    ON sp.personagem.id = p.id"
			+ "    where"
			+ "     sp.acesso = 'SO' and"
			+ "     sp.sala.id = :idSala";
	
	static final String FIND_PERSONAGENS =  
			  "Select"
			+ "     p "
			+ "    FROM Personagem as p"
			+ "    INNER JOIN SalaPersonagem as sp"
			+ "    ON sp.personagem.id = p.id"
			+ "    where"
			+ "     sp.acesso = 'AP' and"
			+ "     sp.sala.id = :idSala";
	
	static final String FIND_BY_SALA_PERSONAGEM =  
			  "Select"
			+ "     sp "
			+ "     from SalaPersonagem as sp"
			+ "    where"
			+ "     sp.personagem.id = :idPersonagem and"
			+ "     sp.sala.id = :idSala";
	
	@Query(value = FIND_BY_PERSONAGEM, nativeQuery = false)
	SalaPersonagem findByPersonagem(@Param("idPersonagem") Long idPersonagem);
	
	@Query(value = FIND_SOLICITACOES, nativeQuery = false)
	List<Personagem> findSolicitacoes(@Param("idSala") Long idSala);
	
	@Query(value = FIND_PERSONAGENS, nativeQuery = false)
	List<Personagem> findPersonagens(@Param("idSala") Long idSala);	

	@Query(value = FIND_BY_SALA_PERSONAGEM, nativeQuery = false)
	SalaPersonagem findBySalaPersonagem(@Param("idSala") Long idSala, @Param("idPersonagem") Long idPersonagem);
	
}
