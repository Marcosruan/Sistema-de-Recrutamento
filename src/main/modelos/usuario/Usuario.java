package main.modelos.usuario;

public class Usuario {

import main.modelos.enums.TipoUsuario;

public abstract class Usuario {
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	
	public Usuario(String nome,String cpf,String email,String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}
	
	public boolean altenticar(String email,String senha) {
		if(this.email.equals(email) && this.senha.equals(senha)) {
			return true;
		}
		return false;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public abstract TipoUsuario getTipo();
	
	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(cpf, other.cpf);
	}
}
