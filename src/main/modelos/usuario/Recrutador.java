package main.modelos.usuario;

import main.modelos.enums.TipoUsuario;

public class Recrutador extends Usuario {

	private String empresa;
	
	public Recrutador(String nome, int idade, String cpf, String email, String senha, String empresa) throws IllegalArgumentException {
		super(nome, idade, cpf, email, senha);
		validarEmpresa(empresa);
		this.empresa = empresa;
	}
	public void validarEmpresa(String texto) {
		if(texto == null || texto.isBlank()) {
			throw new IllegalArgumentException("Nome de empresa inválido");
		}
		
	}
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) throws IllegalArgumentException{
		validarEmpresa(empresa);
		this.empresa = empresa;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(" | Empresa: %s",empresa);
	}
	@Override
	public String toSummaryString() {
		return "[Recrutador] Nome: " + getNome() + " | Email: " + getEmail() + " | Empresa: " + getEmpresa();
	}
	@Override
	public boolean ehPermitidoCadastrarVagas() {
		return true;
	}
	@Override
	public boolean ehPermitidoAlterarVagas() {
		return true;
	}
	@Override
	public boolean ehPermitidoCadastrarAlterarCurriculo() {
		return false;
	}
	@Override
	protected TipoUsuario getTipo() {
		return TipoUsuario.RECRUTADOR;
	}

}
