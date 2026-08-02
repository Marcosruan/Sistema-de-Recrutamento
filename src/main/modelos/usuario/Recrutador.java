package main.modelos.usuario;

import java.util.ArrayList;
import java.util.List;

import main.modelos.Candidatura;
import main.modelos.Empresa;
import main.modelos.Vaga;
import main.modelos.enums.StatusCandidatura;
import main.modelos.enums.TipoUsuario;

public class Recrutador extends Usuario{

	private Empresa empresa;
	private List<Vaga> vagasCriadas;
	
	public Recrutador(String nome, String cpf, String email, String senha, Empresa empresa) {
		super(nome, cpf, email, senha);
		this.empresa = empresa;
		this.vagasCriadas = new ArrayList<Vaga>();
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
	
	public String visualizarCandidatosDaEmpresa(Vaga vaga) {
		String relatorio = "";
		List<String> inscritos = vaga.getCandidatos();
		
		for(String v : inscritos) {
			relatorio += v;
		}
		
		return relatorio;
	}
}
