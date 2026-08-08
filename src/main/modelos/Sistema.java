package main.modelos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.modelos.usuario.Candidato;
import main.modelos.usuario.Recrutador;
import main.modelos.usuario.Usuario;

public class Sistema {
	private Map<String, Usuario> usuarios;
	private Map<String, Vaga> vagas;
	private Usuario usuarioLogado;
	
	public Sistema() {
		this.usuarios = new HashMap<String, Usuario>();
		this.vagas = new HashMap<String, Vaga>();
	}
	
	
	public boolean cadastrarCandidato(String nome, String cpf, String email, String senha) {
		try {
			Usuario novoUsuario = new Candidato(nome, cpf, email, senha);
			usuarios.put(email, novoUsuario);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean cadastrarRecrutador(String nome, String cpf, String email, String senha, String empresa) {
		try {
			Usuario novoUsuario = new Recrutador(nome, cpf, email, senha, empresa);
			usuarios.put(email, novoUsuario);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean login(String email, String senha) {
		try {
			Usuario usuario = usuarios.get(email);
			if (usuario.autenticar(senha)) {
				usuarioLogado = usuario;
				return true;
			}
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean cadastrarVaga(String codigo, String titulo, String descricao, String requisitos, double salario, String cidade, String empresa, boolean aberta) {
		try {
			Vaga novaVaga = new Vaga(codigo, titulo, descricao, requisitos, salario, cidade, empresa);
			vagas.put(codigo, novaVaga);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarTituloVaga(String codigo, String novoTitulo) {
		try {	
			vagas.get(codigo).setTitulo(novoTitulo);
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarDescricaoVaga(String codigo, String novoDescricao) {
		try {
			vagas.get(codigo).setDescricao(novoDescricao);
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarRequisitosVaga(String codigo, String novoRequisitos) {
		try {
			vagas.get(codigo).setRequisitos(novoRequisitos);
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarSalarioVaga(String codigo, double novoSalario) {
		try {
			vagas.get(codigo).setSalario(novoSalario);
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarCidadeVaga(String codigo, String novoCidade) {
		try {
			vagas.get(codigo).setCidade(novoCidade);
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean abrirVaga(String codigo) {
		try {
			vagas.get(codigo).abrirVaga();
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean fecharVaga(String codigo) {
		try {
			vagas.get(codigo).fecharVaga();
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public String verCadidaturas(String codigo) {
		String logCandidaturas = "";
		
		List<Candidatura> candidaturasDaVaga = vagas.get(codigo).getCandidaturas();
		for(Candidatura c: candidaturasDaVaga) {
			logCandidaturas += "";
		}
		
		return logCandidaturas;
	}
}
