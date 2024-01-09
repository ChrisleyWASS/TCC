package br.com.mysthenrpg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.Personagem;
import br.com.mysthenrpg.entities.Usuario;
import br.com.mysthenrpg.entities.UsuarioPersonagem;

@Repository
public interface UsuarioPersonagemRepository extends JpaRepository<UsuarioPersonagem, Long>{
	
	static final String FIND_SOLICITACOES =  
			  "Select"
			+ "     up "
			+ "    FROM UsuarioPersonagem as up"
			+ "    INNER JOIN SalaPersonagem as sp"
			+ "    ON sp.personagem.id = up.personagem.id"
			+ "    where"
			+ "     sp.acesso = 'SO' and"
			+ "     sp.sala.id = :idSala";
	
	static final String FIND_APROVADOS =  
			  "Select"
			+ "     up "
			+ "    FROM UsuarioPersonagem as up"
			+ "    INNER JOIN SalaPersonagem as sp"
			+ "    ON sp.personagem.id = up.personagem.id"
			+ "    where"
			+ "     sp.acesso = 'AP' and"
			+ "     sp.sala.id = :idSala";


	@Query(value = FIND_SOLICITACOES, nativeQuery = false)
	List<UsuarioPersonagem> findSolicitacoes(@Param("idSala") Long idSala);
	
	@Query(value = FIND_APROVADOS, nativeQuery = false)
	List<UsuarioPersonagem> findAprovados(@Param("idSala") Long idSala);
}
