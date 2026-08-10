package main.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.modelos.enums.StatusCandidatura;
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
	
	
	public boolean cadastrarCandidato(String nome, int idade, String cpf, String email, String senha) {
		try {
			Usuario novoUsuario = new Candidato(nome, idade, cpf, email, senha);
			usuarios.put(email, novoUsuario);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean cadastrarRecrutador(String nome, int idade, String cpf, String email, String senha, String empresa) {
		try {
			Usuario novoUsuario = new Recrutador(nome, idade, cpf, email, senha, empresa);
			usuarios.put(email, novoUsuario);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean login(String email, String senha) {
		Usuario usuario = usuarios.get(email);
		if(usuario == null) return false;
		try {
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
	
	public boolean logout() {
		if(usuarioLogado == null) return false;
		usuarioLogado = null;
		return true;
	}
	
	public String exibirDadosDoUsuario() {
		return usuarioLogado.toString();
	}
	
	public boolean alterarNome(String novoNome) {
		try {
			usuarioLogado.setNome(novoNome);
			return true;
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarSenha(String novaSenha) {
		try {
			usuarioLogado.setSenha(novaSenha);;
			return true;
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarEmpresa(String empresa) {
		Recrutador recrutadorLogado = (Recrutador) usuarioLogado;
		try {
			recrutadorLogado.setEmpresa(empresa);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean cadastrarVaga(String codigo, String titulo, String descricao, String requisitos, double salario, String cidade, String empresa) {
		if(!usuarioLogado.ehPermitidoCadastrarVagas()) return false;
		try {
			Vaga novaVaga = new Vaga(codigo, titulo, descricao, requisitos, salario, cidade, empresa);
			vagas.put(codigo, novaVaga);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public String verVagas() {
		if(vagas.isEmpty()) {
			return "Nenhuma vaga cadastrada.";
		}
		
		String logDeVagas = "";
		
		for(Map.Entry<String, Vaga> vaga : vagas.entrySet()) {
			logDeVagas += vaga.getValue().toString() + "\n";
		}
		
		return logDeVagas.trim();
	}
	
	public boolean alterarTituloVaga(String codigo, String novoTitulo) {
		if(!usuarioLogado.ehPermitidoAlterarVagas()) return false;
		Vaga vaga = buscarVaga(codigo);
		if(vaga == null) return false;
		try {	
			vaga.setTitulo(novoTitulo);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarDescricaoVaga(String codigo, String novoDescricao) {
		if(!usuarioLogado.ehPermitidoAlterarVagas()) return false;
		Vaga vaga = buscarVaga(codigo);
		if(vaga == null) return false;
		try {
			vaga.setDescricao(novoDescricao);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarRequisitosVaga(String codigo, String novoRequisitos) {
		if(!usuarioLogado.ehPermitidoAlterarVagas()) return false;
		Vaga vaga = buscarVaga(codigo);
		if(vaga == null) return false;
		try {
			vaga.setRequisitos(novoRequisitos);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarSalarioVaga(String codigo, double novoSalario) {
		if(!usuarioLogado.ehPermitidoAlterarVagas()) return false;
		Vaga vaga = buscarVaga(codigo);
		if(vaga == null) return false;
		try {
			vaga.setSalario(novoSalario);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarCidadeVaga(String codigo, String novoCidade) {
		if(!usuarioLogado.ehPermitidoAlterarVagas()) return false;
		Vaga vaga = buscarVaga(codigo);
		if(vaga == null) return false;
		try {
			vaga.setCidade(novoCidade);
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean abrirVaga(String codigo) {
		if(!usuarioLogado.ehPermitidoAlterarVagas()) return false;
		Vaga vaga = buscarVaga(codigo);
		if(vaga == null) return false;
		if(vaga.getAberta()) return false;
		try {
			vaga.abrirVaga();
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean fecharVaga(String codigo) {
		if(!usuarioLogado.ehPermitidoAlterarVagas()) return false;
		Vaga vaga = buscarVaga(codigo);
		if(vaga == null) return false;
		try {
			vaga.fecharVaga();
			return true;
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public Vaga buscarVaga(String codigo) {
		if(calcularTotalUsuarios() == 0) return null;
		return vagas.get(codigo);
	}
	
	public boolean registrarCandidatura(String codigo) {
		if(vagas.size() == 0) return false;
		Vaga vaga = buscarVaga(codigo);
		if(vaga == null) return false;
		try {
			Candidato candidato = (Candidato) usuarioLogado;
			Candidatura candidatura = new Candidatura(candidato,vaga);
			candidato.candidatarVaga(candidatura);
			return true;
		} catch (Exception e) {
			return false;
		}
		
	}
	
	public String verCadidaturasPorVaga(String codigo) {
		Vaga vaga = buscarVaga(codigo);
		if(vaga == null) return "Vaga não foi encontrada!";
		
		List<Candidatura> candidaturasDaVaga = vaga.getCandidaturas();
		if(candidaturasDaVaga.isEmpty()) {
			return "Não há candidaturas para esta vaga";
		}
		
		List<String> logCandidaturas = new ArrayList<String>();
		
		for(Candidatura c: candidaturasDaVaga) {
			if (c.getStatus() != StatusCandidatura.CANCELADA) {
				logCandidaturas.add(c.toString());				
			}
		}
		
		return String.join("\n", logCandidaturas);
	}
	
	public Candidatura getCandidatura(String codigo, int id) {
		Vaga vaga = buscarVaga(codigo);
		if(vaga == null) return null;
		List<Candidatura> candidaturasDaVaga = vaga.getCandidaturas();
		for(Candidatura c: candidaturasDaVaga) {
			if(c.getId() == id) {
				return c;
			}
		}
		
		return null;
	}
	
	public String getCandidaturaDoCandidato() {
		Candidato usuarioCandidato = (Candidato) usuarioLogado;
		List<Candidatura> candidaturas = usuarioCandidato.getCandidaturas();
		String texto = "";
		for (Candidatura c: candidaturas) {
			if (c.getStatus() != StatusCandidatura.CANCELADA) {
				texto += c.toString() + "\n";				
			}
		}
		return texto.trim();
	}
	
	public boolean colocarCandidaturaEmAnalise(String codigo, int id) {
		Candidatura candidatura = getCandidatura(codigo, id);
		if(candidatura == null) {
			return false;
		}
		
		candidatura.alterarStatus(StatusCandidatura.EM_ANALISE);
		return true;
	}
	
	public boolean marcarEntrevista(String codigo, int id) {
		Candidatura candidatura = getCandidatura(codigo, id);
		if(candidatura == null) {
			return false;
		}
		
		candidatura.alterarStatus(StatusCandidatura.ENTREVISTA);
		return true;
	}
	
	public boolean aprovarCandidatura(String codigo, int id) {
		Candidatura candidatura = getCandidatura(codigo, id);
		if(candidatura == null) {
			return false;
		}
		
		candidatura.alterarStatus(StatusCandidatura.APROVADO);
		fecharVaga(codigo);
		return true;
	}
	
	public boolean reprovarCandidatura(String codigo, int id) {
		Candidatura candidatura = getCandidatura(codigo, id);
		if(candidatura == null) {
			return false;
		}
		
		candidatura.alterarStatus(StatusCandidatura.REPROVADO);
		return true;
	}
	
	public boolean cancelarCandidatura(String codigo, int id) {
		Candidatura candidatura = getCandidatura(codigo, id);
		if(candidatura == null) {
			return false;
		}
		
		candidatura.alterarStatus(StatusCandidatura.CANCELADA);
		return true;
	}
	
	public boolean cadastrarCurriculo(Set<String> formacoes, String experiencia, Set<String> habilidades, Set<String> idiomas) {
		if(!usuarioLogado.ehPermitidoCadastrarAlterarCurriculo()) return false;
		try {
			Candidato candidato = (Candidato) usuarioLogado;
			Curriculo curriculo = new Curriculo(formacoes, experiencia, habilidades, idiomas, candidato);
			candidato.cadastrarCurriculo(curriculo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean adicionarExperienciaCurriculo(String experiencia) {
		if(!usuarioLogado.ehPermitidoCadastrarAlterarCurriculo()) return false;
		try {
			Candidato candidato = (Candidato) usuarioLogado;
			candidato.adicionarExperienciaCurriculo(experiencia);
			return true;
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
		return false;
	}
	
	public boolean adicionarFormacaoCurriculo(String Formacao) {
		if(!usuarioLogado.ehPermitidoCadastrarAlterarCurriculo()) return false;
		try {
			Candidato candidato = (Candidato) usuarioLogado;
			candidato.adicionarFormacaoCurriculo(Formacao);;
			return true;
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
		return false;
	}
	
	public boolean adicionarHabilidadeCurriculo(String habilidade) {
		if(!usuarioLogado.ehPermitidoCadastrarAlterarCurriculo()) return false;
		try {
			Candidato candidato = (Candidato) usuarioLogado;
			candidato.adicionarHabilidadeCurriculo(habilidade);
			return true;
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
		return false;
	}
	
	public boolean adicionarIdiomaCurriculo(String idioma) {
		if(!usuarioLogado.ehPermitidoCadastrarAlterarCurriculo()) return false;
		try {
			Candidato candidato = (Candidato) usuarioLogado;
			candidato.adicionarIdiomasCurriculo(idioma);;
			return true;
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
		return false;
	}
	
	public boolean editarExperienciaCurriculo(String experienciaNova) {
		if(!usuarioLogado.ehPermitidoCadastrarAlterarCurriculo()) return false;
		try {
			Candidato candidato = (Candidato) usuarioLogado;
			candidato.editarExperienciaCurriculo(experienciaNova);
			return true;
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
		return false;
	}
	
	public boolean editarFormacoesCurriculo(String formacaoAntiga, String formacaoNova) {
		if(!usuarioLogado.ehPermitidoCadastrarAlterarCurriculo()) return false;
		try {
			Candidato candidato = (Candidato) usuarioLogado;
			candidato.editarFormacaoCurriculo(formacaoAntiga, formacaoNova);
			return true;
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
		return false;
	}
	
	public boolean editarHabilidadesCurriculo(String habilidadeAntiga, String habilidadeNova) {
		if(!usuarioLogado.ehPermitidoCadastrarAlterarCurriculo()) return false;
		try {
			Candidato candidato = (Candidato) usuarioLogado;
			candidato.editarHabilidadeCurriculo(habilidadeAntiga, habilidadeNova);;
			return true;
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
		return false;
	}
	
	public boolean editarIdiomasCurriculo(String idiomaAntiga, String idiomaNovo) {
		if(!usuarioLogado.ehPermitidoCadastrarAlterarCurriculo()) return false;
		try {
			Candidato candidato = (Candidato) usuarioLogado;
			candidato.editarIdiomasCurriculo(idiomaAntiga, idiomaNovo);
			return true;
		} catch (IllegalStateException e) {
			System.out.println(e.getMessage());
		}
		catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} 
		return false;
	}
	
	public boolean excluirCurriculo() {
		if(!usuarioLogado.ehPermitidoCadastrarAlterarCurriculo()) return false;
		  try {
			Candidato candidato = (Candidato) usuarioLogado;
			candidato.deletarCurriculo();
			return true;
		  }catch (IllegalStateException e) {
				System.out.println(e.getMessage());
				return false;
		  }
	}
	
	public int calcularTotalUsuarios() {
		return usuarios.size();
	}
	
	public int calcularTotalVagas() {
		return vagas.size();
	}

	public boolean candidatar(String codigo) {
		try {
			Vaga vaga = buscarVaga(codigo);
			if(vaga == null) return false;
			Candidato usuarioCandidato = (Candidato) usuarioLogado;
			Candidatura novaCandidatura = new Candidatura(usuarioCandidato, vaga);
			usuarioCandidato.setCandidaturas(novaCandidatura);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}

	public String verCurriculo() {
		Candidato usuarioCandidato = (Candidato) usuarioLogado;
		return usuarioCandidato.getCurriculo().toString();
	}
}
