package com.unicauca.edu.co.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.unicauca.edu.co.model.Horario;
import com.unicauca.edu.co.model.projection.HorarioProjection;

public interface IHorarioDao extends CrudRepository<Horario, Long> {
	
	@Query(nativeQuery=true, value="SELECT h.hor_id, h.hor_dia, h.hor_hora_fin, h.hor_hora_inicio, h.curso_cur_id AS cur_id, h.recurso_rec_id AS rec_id FROM horario h WHERE h.recurso_rec_id = ?1 AND h.hor_dia = ?2 AND h.hor_hora_inicio = ?3 AND h.hor_hora_fin = ?4 ")
	List<HorarioProjection> buscarRecursoDiaHIniHFin(Long recurso_id, String dia, String HoraInicio, String HoraFin);
	
	@Query(nativeQuery=true, value="SELECT h.hor_id, h.hor_dia, h.hor_hora_fin, h.hor_hora_inicio, h.curso_cur_id AS cur_id, h.recurso_rec_id AS rec_id FROM horario  h WHERE h.recurso_rec_id = ?1 ")
	List<HorarioProjection> listarHorariosDeRecurso(Long recurso_id);
}
//@Query("SELECT new com.chapumix.apihusj.app.model.entity.dto.GenPacienDTO(p.pacNumDoc, p.pacPriNom, p.pacSegNom, p.pacPriApe, p.pacSegApe, p.gpafecnac) FROM GenPacien p JOIN p.adnIngreso i WHERE i.ainEstado = 0 AND p.pacNumDoc LIKE %?1%")
//List<GenPacienDTO> pacienteSticker(String numDoc);