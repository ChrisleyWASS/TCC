package br.com.mysthenrpg.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.GameEtnia;
import br.com.mysthenrpg.entities.GameRaca;
import br.com.mysthenrpg.entities.Personagem;

@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long>, PersonagemRepositoryCustom{
	
	static final String FIND_BY_USER =    " SELECT "
										+ " p"
										+ " FROM Personagem as p"
										+ " INNER JOIN UsuarioPersonagem as up"
										+ " ON up.personagem.id = p.id"
										+ " WHERE up.usuario.id = :idUser";
	
	static final String FIND_BY_ID_USER =     " SELECT "
											+ " p"
											+ " FROM Personagem as p"
											+ " INNER JOIN UsuarioPersonagem as up"
											+ " ON up.personagem.id = p.id"
											+ " WHERE "
											+ " up.usuario.id = :idUser and"
											+ " p.id = :idPersonagem";

	@Query(value = FIND_BY_USER, nativeQuery = false)
	List<Personagem> findByUser(@Param("idUser") Long idUser);

	@Query(value = FIND_BY_ID_USER, nativeQuery = false)
	Personagem findByIdAndUser(@Param("idPersonagem") Long idPersonagem, @Param("idUser") Long idUser);
	
}