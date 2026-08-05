package main.modelos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.modelos.enums.TipoUsuario;
import main.modelos.usuario.Candidato;
import main.modelos.usuario.Recrutador;
import main.modelos.usuario.Usuario;

public class Sistema {
	private Map<String, Usuario> usuarios;
	private List<Vaga> vagas;
	private Usuario usuarioLogado;
	
	public Sistema() {
		this.usuarios = new HashMap<String, Usuario>();
		this.vagas = new ArrayList<Vaga>();
	}
	
	
	public boolean cadastrarCandidato(String nome,String cpf,String email,String senha) {
		try {
			Usuario novoUsuario = new Candidato(nome, cpf, email, senha);
			usuarios.put(email, novoUsuario);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean cadastrarRecrutador(String nome,String cpf,String email,String senha, String empresa) {
		try {
			Usuario novoUsuario = new Recrutador(nome, cpf, email, senha, empresa);
			usuarios.put(email, novoUsuario);
			return true;
		} catch (Exception e) {
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
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	//seção do recrutador

	public boolean cadastrarVaga(String codigo, String titulo, String descricao, String requisitos, double salario, String cidade, String empresa, boolean aberta) {
		try {
			if (usuarioLogado.getTipo() == TipoUsuario.RECRUTADOR) {
				Vaga novaVaga = new Vaga(codigo, titulo, descricao, requisitos, salario, cidade, empresa, aberta);
				return vagas.add(novaVaga);		
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarTituloVaga(String codigo, String novoTitulo) {
		try {
			if (usuarioLogado.getTipo() == TipoUsuario.RECRUTADOR) {
				for (Vaga vaga: vagas) {
					if (vaga.getCodigo() == codigo) {
						vaga.setTitulo(novoTitulo);
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarDescricaoVaga(String codigo, String novoDescricao) {
		try {
			if (usuarioLogado.getTipo() == TipoUsuario.RECRUTADOR) {
				for (Vaga vaga: vagas) {
					if (vaga.getCodigo() == codigo) {
						vaga.setDescricao(novoDescricao);
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarRequisitosVaga(String codigo, String novoRequisitos) {
		try {
			if (usuarioLogado.getTipo() == TipoUsuario.RECRUTADOR) {
				for (Vaga vaga: vagas) {
					if (vaga.getCodigo() == codigo) {
						vaga.setRequisitos(novoRequisitos);
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarSalarioVaga(String codigo, double novoSalario) {
		try {
			if (usuarioLogado.getTipo() == TipoUsuario.RECRUTADOR) {
				for (Vaga vaga: vagas) {
					if (vaga.getCodigo() == codigo) {
						vaga.setSalario(novoSalario);
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean alterarCidadeVaga(String codigo, String novoCidade) {
		try {
			if (usuarioLogado.getTipo() == TipoUsuario.RECRUTADOR) {
				for (Vaga vaga: vagas) {
					if (vaga.getCodigo() == codigo) {
						if (vaga.podeEditar(usuarioLogado)) {
							vaga.setCidade(novoCidade);
							return true;							
						}
					}
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean abrirVaga(String codigo) {
		try {
			if (usuarioLogado.getTipo() == TipoUsuario.RECRUTADOR) {
				for (Vaga vaga: vagas) {
					if (vaga.getCodigo() == codigo) {
						vaga.abrirVaga();
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean fecharVaga(String codigo) {
		try {
			if (usuarioLogado.getTipo() == TipoUsuario.RECRUTADOR) {
				for (Vaga vaga: vagas) {
					if (vaga.getCodigo() == codigo) {
						vaga.fecharVaga();
						return true;
					}
				}
			}
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
