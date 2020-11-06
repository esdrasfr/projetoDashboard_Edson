package br.com.efmscorp.dashboard.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import br.com.efmscorp.dashboard.dto.VolumeAlarmes;
import br.com.efmscorp.dashboard.model.Evento;

public interface EventoDAO extends CrudRepository<Evento, Integer>{
	
	public ArrayList<Evento> findAllByDtEventoBetween(LocalDate inicio, LocalDate fim);
	
	/* Precisamos converter o select abaixo para JAVA-Objetos
	 * select nome, count(itmn_evento.id_alarme)
		from itmn_evento inner join itmn_alarme on itmn_evento.id_alarme = itmn_alarme.id_alarme
		group by itmn_evento.id_alarme
	 * */
	@Query("SELECT new br.com.efmscorp.dashboard.dto.VolumeAlarmes(evt.alarme.nome, count(evt.alarme.id)) "
			+ " FROM Evento evt Group By evt.alarme.id")
	public ArrayList<VolumeAlarmes> gettAllVolumes();

	/*
	 * Agora vamos aplicar o filtro de Data no mesmo Select do getAllVolumes
	 * */
	@Query("SELECT new br.com.efmscorp.dashboard.dto.VolumeAlarmes(evt.alarme.nome, count(evt.alarme.id)) "
			+ " FROM Evento evt "
			+ " WHERE evt.dtEvento >= :dataInicio AND evt.dtEvento <= :dataFim"
			+ " Group By evt.alarme.id")
	public ArrayList<VolumeAlarmes> getAllByDatas(@Param("dataInicio")LocalDate dataInicio, 
												@Param("dataFim")LocalDate dataFim);

	
}
