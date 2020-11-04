package br.com.efmscorp.dashboard.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.efmscorp.dashboard.dao.UsuarioDAO;
import br.com.efmscorp.dashboard.model.Usuario;

@RestController
public class UsuarioController {

	/*
	 * A anotação Autowired indica a injeção da dependência da interface UsuarioDAO
	 * no meu Controller Ou seja, não precisamos nos preocupar com: 1 - Quem vai
	 * instanciar o objeto que implementa esta interface 2 - se este objeto não
	 * existir, a JVM cria uma implementação em tempo de execução para suprir essa
	 * necessidade
	 */
	@Autowired
	private UsuarioDAO dao; // Este é o objetivo que irá manipular o Banco de Dados

	@GetMapping("/usuarios")
	public ArrayList<Usuario> recuperaTodoMundo() {
		ArrayList<Usuario> lista;
		lista = (ArrayList<Usuario>) dao.findAll();
		return lista;
	}

	@GetMapping("/teste")
	public Usuario recuperar() {
		Usuario u = dao.findByRacfAndSenha("msilvae", "123456");
		return u;
	}

	@PostMapping("/login")
	public ResponseEntity<Usuario> logarUsuario(@RequestBody Usuario dadosLogin) {
		Usuario resultado = dao.findByRacfOrEmail(dadosLogin.getRacf(), dadosLogin.getEmail());
		if (resultado != null) {
			if (resultado.getSenha().equals(dadosLogin.getSenha()))
				return ResponseEntity.ok(resultado);
			else
				return ResponseEntity.status(401).build();
		} else { // Usuario não encontrado
			return ResponseEntity.notFound().build(); // equivale ao status(404).build()
		}
	}

}
