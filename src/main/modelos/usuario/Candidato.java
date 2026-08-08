package main.modelos.usuario;

import java.util.ArrayList;
import java.util.List;

import main.modelos.Candidatura;
import main.modelos.Curriculo;
import main.modelos.enums.TipoUsuario;

public class Candidato extends Usuario {
	
	private Curriculo curriculo;
	private List<Candidatura> candidaturas;

	public Candidato(String nome, int idade, String cpf, String email, String senha) throws IllegalArgumentException {
		super(nome, idade, cpf, email, senha);
		this.candidaturas = new ArrayList<Candidatura>();
	}
	
	public void cadastrarCurriculo() {}
	public void editarCurriculo() {}
	public void candidatarVaga() {}
	public void cancelarCandidatura() {}
	public void visualizarCandidaturas() {}

	@Override
	public TipoUsuario getTipo() {
		return TipoUsuario.CANDIDATO;
	}
}
