package main.controlador;

import main.modelos.Sistema;

public class Controlador {
	
	private Sistema sistema;
	
	public Controlador() {
		this.sistema = new Sistema();
	}
	
	public boolean cadastrarCandidato(String nome, int idade, String cpf, String email, String senha) {
		return sistema.cadastrarCandidato(nome, idade, cpf, email, senha);
	}
	
	public boolean login(String email, String senha) {
		return sistema.login(email, senha);
	}
}
