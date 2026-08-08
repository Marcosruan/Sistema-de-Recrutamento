package main.modelos.usuario;

import java.util.ArrayList;
import java.util.List;

import main.modelos.Candidatura;
import main.modelos.Curriculo;
import main.modelos.enums.TipoUsuario;

public class Candidato extends Usuario {
	
	private Curriculo curriculo;
	private List<Candidatura> candidaturas;

	public Candidato(String nome, String cpf, String email, String senha) throws IllegalArgumentException {
		super(nome, cpf, email, senha);
		this.candidaturas = new ArrayList<Candidatura>();
	}

	@Override
	public String toSummaryString() {
		return "[Candidato] Nome: " + getNome() + " | Email: " + getEmail() + " | Formação: " + curriculo.getFormacao();
	}
	


}
