package br.com.efmscorp.dashboard.dao;

import org.springframework.data.repository.CrudRepository;

import br.com.efmscorp.dashboard.model.Usuario;

/*
 * Param1 = Nome da Classe que será feito o CRUD
 * Param2 = Tipo da classe da ChavePrimaria
 * 
 * a interface UsuarioDAO automaticamente herda as funcionalidades basicas de CRUD da CrudRepository
 * e nesta declaração apenas criamos coisas específicas (ex.: login por racf)
 * 
 * */

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{

	public Usuario findByRacfAndSenha(String racf, String senha);
	public Usuario findByRacfOrEmail(String racf, String email);
	
}



