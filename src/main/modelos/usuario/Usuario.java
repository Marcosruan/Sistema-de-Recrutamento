package main.modelos.usuario;

import java.util.Objects;

import main.modelos.enums.TipoUsuario;

public abstract class Usuario {
	
	protected String nome;
	protected int idade;
	protected String cpf;
	protected String email;
	protected String senha;
	
	public Usuario(String nome, int idade, String cpf, String email, String senha) throws IllegalArgumentException {
		validarString(nome, "Nome inválido!");
		validarIdade(idade);
		validarCPF(cpf);
		validarString(email, "Email inválido!");
		validarString(senha, "Senha inválida!");
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}
	private void validarString(String texto,String mensagem) throws IllegalArgumentException {
		if (texto == null || texto.isBlank()) {
			throw new IllegalArgumentException(mensagem);
		}
	}
	
	private void validarIdade(int idade) throws IllegalArgumentException{
		if(idade < 18 || idade > 100) {
			throw new IllegalArgumentException("Idade inválida. É preciso ter entre 18 e 100 anos.");
		}
	}
	
	private void validarCPF(String texto) throws IllegalArgumentException {
		if (texto == null || texto.isBlank() || texto.length() != 11) {
			throw new IllegalArgumentException("CPF inválido. Deve possuir exatamente 11 digitos!");
		}
	}
	
	public boolean autenticar(String senha) {
		if(this.senha.equals(senha)) return true;
		return false;
	}
	
	public String getNome() {
		return nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setNome(String nome) throws IllegalArgumentException{
		validarString(nome,"Nome inválido!");
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws IllegalArgumentException{
		validarString(senha,"Senha inválido!");
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
		return String.format("Nome: %s | Idade: %d | CPF: %s | Email: %s | Senha: %s",
				nome,
				idade,
				cpf,
				email,
				senha);
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
	
	public abstract TipoUsuario getTipo();
	
}
