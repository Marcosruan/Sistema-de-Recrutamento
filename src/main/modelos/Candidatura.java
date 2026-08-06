package main.modelos;

import main.modelos.enums.StatusCandidatura;
import main.modelos.usuario.Candidato;
import main.modelos.usuario.Usuario;

public class Candidatura {
	
	private StatusCandidatura status;
	private Candidato candidato;
	private Vaga vaga;
	
	public Candidatura() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean alterarStatus(StatusCandidatura novoStatus) {
		return false;
	}
}
