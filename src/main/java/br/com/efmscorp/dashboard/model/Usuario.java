package br.com.efmscorp.dashboard.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/*Necessidade de anotar as classes para fazer DE-PARA da Tabela
 * */
@Entity //Esta anotação indica que a classe é armazenavel em banco
@Table (name="tbl_usuario") //indicação do nome da tabela
public class Usuario {

	@Id  //Indica que o atributo é chave primario
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //indica que o valor do atributo é gerado automaticamente
	@Column(name="id") //mapeia o nome da coluna
	private int id;
	
	@Column(name="nome", length = 100, nullable = false)
	private String nome;
	
	@Column(name="email", length = 100, nullable = false)
	private String email;
	
	@Column(name="racf", length = 7, nullable = false)
	private String racf;
	
	@Column(name="senha", length = 20, nullable = false)
	private String senha;
	
	@Column(name="link_foto", length = 255)
	private String linkFoto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRacf() {
		return racf;
	}
	public void setRacf(String racf) {
		this.racf = racf;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLinkFoto() {
		return linkFoto;
	}
	public void setLinkFoto(String linkFoto) {
		this.linkFoto = linkFoto;
	}
	
	
	
	
	
}
