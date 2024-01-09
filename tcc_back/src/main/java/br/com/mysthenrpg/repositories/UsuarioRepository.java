package br.com.mysthenrpg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	
	static final String FIND_BY_ID =  "Select"
									+ "     u "
									+ "     from Usuario as u"
									+ "    where"
									+ "     CAST(u.id as string) = :idUsuario and"
									+ "     u.ativo = true";
	
	static final String FIND_BY_LOGIN =  "Select"
									   + "     u "
									   + "     from Usuario as u"
									   + "    where"
									   + "     u.login = :login";

	@Query(value = FIND_BY_ID, nativeQuery = false)
	Usuario findById(@Param("idUsuario") String idUsuario);
	
	@Query(value = FIND_BY_LOGIN, nativeQuery = false)
	Usuario findByLogin(@Param("login") String login);
	
}
