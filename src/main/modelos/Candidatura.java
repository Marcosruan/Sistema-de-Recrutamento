package main.modelos;

import main.modelos.enums.StatusCandidatura;
import main.modelos.interfaces.ControleAcesso;
import main.modelos.usuario.Candidato;
import main.modelos.usuario.Usuario;

public class Candidatura implements ControleAcesso {
	
	private StatusCandidatura status;
	private Candidato candidato;
	private Vaga vaga;
	
	public Candidatura() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean alterarStatus(StatusCandidatura novoStatus) {
		return false;
	}

	@Override
	public boolean podeVisualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean podeEditar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean podeRemover(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

}
