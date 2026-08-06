package main.controlador;

import main.modelos.Sistema;

public class Controlador {
	
	private Sistema sistema;
	
	public Controlador() {
		this.sistema = new Sistema();
	}
	
	public boolean cadastrarCandidato(String nome,String cpf,String email,String senha) {
		return sistema.cadastrarCandidato(nome, cpf, email, senha);
	}
}
