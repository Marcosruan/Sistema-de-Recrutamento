package main.modelos;

import main.modelos.enums.StatusCandidatura;
import main.modelos.usuario.Candidato;
import main.modelos.usuario.Usuario;

public class Candidatura {
	
	private StatusCandidatura status;
	private Candidato candidato;
	private Vaga vaga;
	
	public Candidatura(StatusCandidatura status, Candidato candidato, Vaga vaga) {
		this.status = StatusCandidatura.EM_ANALISE;
		this.candidato = candidato;
		this.vaga = vaga;
	}

	public Candidato getCandidato() {
		return candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public StatusCandidatura alterarStatus(StatusCandidatura novoStatus) {
		this.status = novoStatus;
		return this.status;
	}

	@Override
	public String toString() {
		return "[" + vaga.getTitulo() + "] Candidatura de: " + candidato.toString() + "\nStatus da cadidatura: " + status;
	}
	
}
