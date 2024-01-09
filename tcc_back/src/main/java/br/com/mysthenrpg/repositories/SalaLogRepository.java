package br.com.mysthenrpg.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.Sala;
import br.com.mysthenrpg.entities.SalaLog;

@Repository
public interface SalaLogRepository extends JpaRepository<SalaLog, Long>, SalaLogRepositoryCustom{
	
	static final String FIND_BY_SALA =  
			  "Select"
			+ "     sl "
			+ "     from SalaLog as sl"
			+ "    where"
			+ "     sl.sala.id = :idSala"
			+ "     ORDER BY sl.id DESC ";
	
	@Query(value = FIND_BY_SALA, nativeQuery = false)
	List<SalaLog> findBySala(@Param("idSala") Long idSala, Pageable pageable);	
	
	
}
