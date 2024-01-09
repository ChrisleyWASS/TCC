package br.com.mysthenrpg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.GameEspecie;

@Repository
public interface GameEspecieRepository extends JpaRepository<GameEspecie, Long>{
	
}
