package main.modelos.usuario;

import main.modelos.enums.TipoUsuario;

public class Admin extends Usuario {

	public Admin(String nome, String cpf, String email, String senha) {
		super(nome, cpf, email, senha);
		
	}
	
	@Override
	public TipoUsuario getTipo() {
		return TipoUsuario.ADMIN;
	}
}
