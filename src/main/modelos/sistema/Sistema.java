package main.modelos.sistema;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.modelos.Candidatura;
import main.modelos.Curriculo;
import main.modelos.Vaga;
import main.modelos.enums.StatusCandidatura;
import main.modelos.enums.TipoUsuario;
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
	
	public boolean login(String email, String senha, TipoUsuario tipo) {
		Usuario usuario = usuarios.get(email);
		if(usuario == null) return false;
		if(usuario.getTipo() != tipo) return false;
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
	
	public boolean cadastrarVaga(String codigo, String titulo, String descricao, String requisitos, double salario, String cidade) {
		if(vagas.containsKey(codigo)) return false;
		try {
			Recrutador recrutador = (Recrutador) usuarioLogado;
			Vaga novaVaga = new Vaga(codigo, titulo, descricao, requisitos, salario, cidade, recrutador.getEmpresa());
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
		if(!vaga.getAberta()) return false;
		try {
			Candidato candidato = (Candidato) usuarioLogado;
			Candidatura candidatura = new Candidatura(candidato, vaga);
			candidato.candidatarVaga(candidatura);
			vaga.setCandidaturas(candidatura);
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
		
		for(Candidatura candidatura: candidaturasDaVaga) {
			if (candidatura.getStatus() != StatusCandidatura.CANCELADA) {
				logCandidaturas.add(candidatura.toString());				
			}
		}
		
		return String.join("\n", logCandidaturas);
	}
	
	public String exibirCurriculoDoCandidato(String codigo, int id) {
		try {
			Candidatura candidatura = getCandidatura(codigo, id);
			if(candidatura == null) return "Candidatura não registrada"; 
			Candidato candidato = (Candidato) candidatura.getCandidato();
			if (candidato.getCurriculo() == null) return "Nenhum curriculo cadastrado.";
			return candidato.getCurriculo().toString();
	  } catch (IllegalStateException e) {
			System.out.println(e.getMessage());
			return "Nenhum curriculo cadastrado.";
	  }
	}
	
	public Candidatura getCandidatura(String codigo, int id) {
		Vaga vaga = buscarVaga(codigo);
		if(vaga == null) return null;
		List<Candidatura> candidaturasDaVaga = vaga.getCandidaturas();
		for(Candidatura candidatura: candidaturasDaVaga) {
			if(candidatura.getId() == id) {
				if(candidatura.getStatus() == StatusCandidatura.REPROVADO || candidatura.getStatus() == StatusCandidatura.CANCELADA) {
					return null;
				}
				
				return candidatura;
			}
		}
		
		return null;
	}
	
	public String getCandidaturaDoCandidato() {
		Candidato usuarioCandidato = (Candidato) usuarioLogado;
		List<Candidatura> candidaturas = usuarioCandidato.getCandidaturas();
		if (candidaturas.size() == 0) return "Nenhuma candidatura cadastrada.";
		String texto = "";
		for (Candidatura candidatura: candidaturas) {
			if (candidatura.getStatus() != StatusCandidatura.CANCELADA) {
				texto += candidatura.toString() + "\n";				
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
	

	public boolean cadastrarCurriculo(Set<String> formacoes,String experiencia,Set<String> habilidades,Set<String> idiomas) {
		try {
			Candidato candidato = (Candidato) usuarioLogado;
			if (candidato.getCurriculo() != null) return false;
			Curriculo curriculo = new Curriculo(formacoes, experiencia, habilidades, idiomas, candidato);
			candidato.cadastrarCurriculo(curriculo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean adicionarExperienciaCurriculo(String experiencia) {
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

	public boolean editarFormacoesCurriculo(String formacaoAntiga,String formacaoNova) {
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

	public boolean editarHabilidadesCurriculo(String habilidadeAntiga,String habilidadeNova) {
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

	public boolean editarIdiomasCurriculo(String idiomaAntiga,String idiomaNovo) {
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

	public String exibirCurriculo() {
		  try {
			Candidato candidato = (Candidato) usuarioLogado;
			if (candidato.getCurriculo() == null) return "Nenhum curriculo cadastrado.";
			return candidato.getCurriculo().toString();
		  } catch (IllegalStateException e) {
				System.out.println(e.getMessage());
				return "Nenhum curriculo cadastrado.";
		  }
		
	}
	public int calcularTotalUsuarios() {
		return usuarios.size();
	}
	
	public int calcularTotalVagas() {
		return vagas.size();
	}

}
