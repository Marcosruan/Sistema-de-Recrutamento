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
	
	public void cadastrarCurriculo(Curriculo curriculo) {
		this.curriculo = curriculo;
	}
	
	public void editarCurriculo(Curriculo novoCurriculo) {
	    if (novoCurriculo == null) {
	        throw new IllegalArgumentException("O novo currículo não pode ser nulo.");
	    }
	    this.curriculo = novoCurriculo;
	}
	
	public void candidatarVaga(Candidatura candidatura) {
		candidaturas.add(candidatura);
	}
	
	public void cancelarCandidatura() {
		
	}
	
	public String visualizarCandidaturas() {
		if(candidaturas.size() == 0) return "Sem candidaturas registrada!";
		List<String> TextoCandidaturas = new ArrayList<String>();
		for(Candidatura candidatura: candidaturas) {
			TextoCandidaturas.add(candidatura.toString());
		}
		return String.join("\n", TextoCandidaturas);
	}

	@Override
	public String toSummaryString() {
		return "[Candidato] Nome: " + getNome() + " | Email: " + getEmail();
	}
	
	@Override
	public boolean ehPermitidoCadastrarVagas() {
		return false;
	}

	@Override
	public boolean ehPermitidoAlterarVagas() {
		return false;
	}
	
	public List<Candidatura> getCandidaturas() {
		return candidaturas;
	}

	public void setCandidaturas(Candidatura candidatura) {
		this.candidaturas.add(candidatura);
	}
}
