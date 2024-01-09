package br.com.mysthenrpg.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.mysthenrpg.entities.CapacidadeGameData;
import br.com.mysthenrpg.entities.GameConhecimento;
import br.com.mysthenrpg.entities.GameTipoConhecimento;

@Repository
public interface CapacidadeGameDataRepository extends JpaRepository<CapacidadeGameData, Long>{
	
	static final String SOMA_CAPACIDADES = "SELECT "
			 + " SUM(cp.FRC),"
			 + " SUM(cp.MOB),"
			 + " SUM(cp.RES),"
			 + " SUM(cp.AGL),"
			 + " SUM(cp.STZ),"
			 + " SUM(cp.DSV),"
			 + " SUM(cp.TNA),"
			 + " SUM(cp.VIG),"
			 + " SUM(cp.IMD),"
			 + " SUM(cp.RAZ),"
			 + " SUM(cp.ATN),"
			 + " SUM(cp.OBT),"
			 + " SUM(cp.RET),"
			 + " SUM(cp.CAR),"
			 + " SUM(cp.IMP) "
			 + "FROM CapacidadeGameData cp "
			 + "WHERE cp.id IN (:idEspecie, :idRaca, :idQld, :idDft, :idTr1, :idTr2, :idTr3)";

@Query(value = SOMA_CAPACIDADES, nativeQuery = false)
Object getSomaCapacidades(@Param("idEspecie") Long idEspecie, 
			@Param("idRaca") Long idRaca, 
			@Param("idQld") Long idQld, 
			@Param("idDft") Long idDft, 
			@Param("idTr1") Long idTr1,
			@Param("idTr2") Long idTr2,
			@Param("idTr3") Long idTr3);

	
	
}
