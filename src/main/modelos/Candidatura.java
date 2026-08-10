package main.modelos;

import main.modelos.enums.StatusCandidatura;
import main.modelos.usuario.Candidato;

public class Candidatura {
	
	private StatusCandidatura status;
	private Candidato candidato;
	private Vaga vaga;
	private int id;

	
	public Candidatura(Candidato candidato, Vaga vaga) {
		this.status = StatusCandidatura.EM_ANALISE;
		this.candidato = candidato;
		this.vaga = vaga;
		this.id = vaga.getTotalDeCandidaturas();
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
	
	public int getId() {
		return id;
	}



	public StatusCandidatura alterarStatus(StatusCandidatura novoStatus) {
		this.status = novoStatus;
		return this.status;
	}
	
	public StatusCandidatura getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return (id) + "# [" + vaga.getTitulo() + "] Candidatura de: " + candidato.toSummaryString() + "\nStatus da cadidatura: " + status.getTexto();
	}
	
}
