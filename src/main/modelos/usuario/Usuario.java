package main.modelos.usuario;

import java.util.Objects;

import main.modelos.enums.TipoUsuario;


public abstract class Usuario {
	
	protected String nome;
	protected String cpf;
	protected String email;
	protected String senha;
	
	public Usuario(String nome, String cpf, String email, String senha) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}
	
	public boolean autenticar(String senha) {
		if(this.senha.equals(senha)) return true;
		return false;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) throws IllegalArgumentException{
		if(nome.isBlank() || nome == null) {
			throw new IllegalArgumentException("Nome inválido");
		}
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws IllegalArgumentException{
		if(senha.isBlank() || senha == null) {
			throw new IllegalArgumentException("Senha inválida");
		}
		if(senha.equals(this.senha)) {
			throw new IllegalArgumentException("Nova senha igual a anterior");
		}
		
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}
	
	public abstract String toSummaryString();
	
	@Override
	public String toString() {
		return "Nome: " + nome + " | CPF: " + cpf + " | Email: " + email + " | Senha: " + senha;
	}

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
