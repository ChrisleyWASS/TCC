package br.com.mysthenrpg.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.GameCaracteristica;
import br.com.mysthenrpg.entities.GameConhecimento;
import br.com.mysthenrpg.entities.GameEspecie;
import br.com.mysthenrpg.entities.GameEtnia;
import br.com.mysthenrpg.entities.GameRaca;
import br.com.mysthenrpg.entities.GameTreinamento;
import br.com.mysthenrpg.entities.Personagem;
import br.com.mysthenrpg.entities.Usuario;

@Repository
public interface PersonagemRepositoryCustom {
	
	public Personagem createPersonagem(String nome, 
									   String linhagem, 
									   String alternativo, 
									   GameEspecie especie, 
									   GameRaca raca, 
									   GameEtnia etnia,
									   GameCaracteristica qualidade, 
									   GameCaracteristica defeito, 
									   ArrayList<GameTreinamento> treinamentos,
									   ArrayList<GameConhecimento> conhecimentos,
									   Usuario usuario_criador) throws Exception;
	
	

	
}