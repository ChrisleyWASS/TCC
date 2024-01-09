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
import br.com.mysthenrpg.entities.PersonagemCaracteristica;
import br.com.mysthenrpg.enuns.TipoQualidadeDefeito;

@Repository
public interface PersonagemCaracteristicaRepository extends JpaRepository<PersonagemCaracteristica, Long>, PersonagemRepositoryCustom{
	
	static final String FIND_BY_USER =    " SELECT "
										+ " pc"
										+ " FROM PersonagemCaracteristica as pc"
										+ " WHERE "
										+ " pc.personagem.id = :idPersonagem and"
										+ " pc.caracteristica.tipo_qualidade_defeito = :tipo";

	@Query(value = FIND_BY_USER, nativeQuery = false)
	PersonagemCaracteristica findByPersonagemAndTipo(@Param("idPersonagem") Long idPersonagem, @Param("tipo") TipoQualidadeDefeito tipo);

	
}