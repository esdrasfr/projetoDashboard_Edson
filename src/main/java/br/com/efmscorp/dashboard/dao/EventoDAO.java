package br.com.efmscorp.dashboard.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.efmscorp.dashboard.model.Evento;

public interface EventoDAO extends CrudRepository<Evento, Integer>{
		
}
