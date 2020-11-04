package br.com.efmscorp.dashboard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.efmscorp.dashboard.dao.EventoDAO;
import br.com.efmscorp.dashboard.model.Evento;

@RestController
public class EventoController {

	@Autowired
	EventoDAO dao;
	
	@GetMapping("/eventos")
	public ArrayList<Evento> recuperarTodosEventos(){
		ArrayList<Evento> lista;
		lista = (ArrayList<Evento>)dao.findAll();
		return lista;
	}

	@GetMapping("/eventos/{id}")
	public Evento recuperaEventoPorId(@PathVariable int id) {
		Evento evt = dao.findById(id).get();
		return evt;
	}
		
}
