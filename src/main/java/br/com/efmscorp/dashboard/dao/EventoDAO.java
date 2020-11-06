package br.com.efmscorp.dashboard.dao;

import java.time.LocalDate;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import br.com.efmscorp.dashboard.model.Evento;

public interface EventoDAO extends CrudRepository<Evento, Integer>{
	
	public ArrayList<Evento> findAllByDtEventoBetween(LocalDate inicio, LocalDate fim);
	
}
