package br.com.mysthenrpg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.Sala;
import br.com.mysthenrpg.entities.Usuario;

@Repository
public interface SalaRepository extends JpaRepository<Sala, Long>{
	
	static final String FIND_BY_COD =  
									  "Select"
									+ "     s "
									+ "     from Sala as s"
									+ "    where"
									+ "     s.codigo = :codigo";
	
	static final String FIND_BY_PERSONAGEM =  
			  "Select"
			+ "     s "
			+ "     from Sala as s"
			+ "     inner join SalaPersonagem sp"
			+ "     on sp.sala.id = s.id"
			+ "    where"
			+ "     sp.personagem.id = :idPersonagem";
	
	static final String FIND_BY_USER =  
			  "Select"
			+ "     s "
			+ "     from Sala as s"
			+ "    where"
			+ "     s.mestre.id = :idUsuario";
	
	
	static final String FIND_BY_ID_USER =  
			  "Select"
			+ "     s "
			+ "     from Sala as s"
			+ "    where"
			+ "     s.mestre.id = :idUsuario and"
			+ "     s.id = :idSala";
	
	@Query(value = FIND_BY_COD, nativeQuery = false)
	Sala findByCodigo(@Param("codigo") String codigo);
	
	@Query(value = FIND_BY_USER, nativeQuery = false)
	List<Sala> findByUsuario(@Param("idUsuario") Long idUsuario);	
	
	@Query(value = FIND_BY_PERSONAGEM, nativeQuery = false)
	Sala findByPersonagem(@Param("idPersonagem") Long idPersonagem);	

	@Query(value = FIND_BY_ID_USER, nativeQuery = false)
	Sala findByIdSalaMestre(@Param("idSala") Long idSala, @Param("idUsuario") Long idUsuario);
	
}
