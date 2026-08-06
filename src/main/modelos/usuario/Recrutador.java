package main.modelos.usuario;

import java.util.ArrayList;
import java.util.List;

import main.modelos.Candidatura;
import main.modelos.Vaga;
import main.modelos.enums.StatusCandidatura;
import main.modelos.enums.TipoUsuario;

public class Recrutador extends Usuario {

	private String empresa;
	private List<Vaga> vagasCriadas;
	
	public Recrutador(String nome, String cpf, String email, String senha, String empresa) throws IllegalArgumentException {
		super(nome, cpf, email, senha);
		if(empresa == null) {
			throw new IllegalArgumentException("Empresa inválida");
		}
		
		this.empresa = empresa;
		this.vagasCriadas = new ArrayList<Vaga>();
	}
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	@Override
	public TipoUsuario getTipo() {
		return TipoUsuario.RECRUTADOR;
	}
	
	public boolean cadastrarVaga(Vaga vaga) {
		return vagasCriadas.add(vaga);
	}
	
	public boolean editarVaga(int indice, Vaga vaga) {
		if((indice >= 0 && indice < vagasCriadas.size()) && vaga != null ) {
			vagasCriadas.set(indice, vaga);
			return true;
		}
		
		return false;
	}
	
	public boolean removerVaga(Vaga vaga) {
		return vagasCriadas.remove(vaga);
	}
	
	public boolean alterarStatusCandidatura(Candidatura candidatura, StatusCandidatura status) {
		return candidatura.alterarStatus(status);
	}
	
	public String visualizarCandidatosDaVaga(Vaga vaga) {
		String relatorio = "";
		List<Candidatura> inscritos = vaga.getCandidaturas();
		
		for(Candidatura v : inscritos) {
			relatorio += v.toString() + "\n";
		}
		
		return relatorio;
	}
}
