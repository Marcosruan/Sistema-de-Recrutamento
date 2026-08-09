package main.modelos.usuario;

import java.util.Objects;

import main.modelos.enums.TipoUsuario;


public abstract class Usuario {
	
	protected String nome;
	protected int idade;
	protected String cpf;
	protected String email;
	protected String senha;
	
	public Usuario(String nome, int idade, String cpf, String email, String senha) {
		validarNome(nome);
		validarIdade(idade);
		validarCPF(cpf);
		validarEmail(email);
		validarSenha(senha);
		this.nome = nome;
		this.idade = idade;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
	}
	private void validarNome(String texto) throws IllegalArgumentException {
		if(texto == null || texto.isBlank()) {
			throw new IllegalArgumentException("Nome inválido!");
		}
	}
	private void validarIdade(int idade) {
		if(idade <= 14 || idade > 100) {
			throw new IllegalArgumentException("Idade inválida. É preciso ter entre 14 e 100 anos.");
		}
	}
	private void validarCPF(String texto) throws IllegalArgumentException {
		if (texto == null || texto.isBlank()) {
			throw new IllegalArgumentException("CPF inválido!");
		}
	}
	private void validarEmail(String texto) throws IllegalArgumentException {
		if (texto == null || texto.isBlank()) {
			throw new IllegalArgumentException("Email inválido!");
		}
	}
	private void validarSenha(String texto) throws IllegalArgumentException {
		if (texto == null || texto.isBlank()) {
			throw new IllegalArgumentException("Senha inválida!");
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
		validarNome(nome);
		this.nome = nome;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws IllegalArgumentException{
		validarSenha(senha);
		if(senha.equals(this.senha)) {
			throw new IllegalArgumentException("Nova senha igual a anterior");
		}
		
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}
	
	public abstract String toSummaryString();
	
	public abstract boolean ehPermitidoCadastrarVagas();
	
	public abstract boolean ehPermitidoAlterarVagas();
	
	public abstract boolean ehPermitidoCadastrarAlterarCurriculo();
	
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
}
