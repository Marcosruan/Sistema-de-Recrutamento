package main.console;

import java.util.HashSet;
import java.util.Set;

import main.Main;
import main.controlador.Controlador;
import main.modelos.interfaces.EstrategiaMenuUsuario;

public class MenuCandidato implements EstrategiaMenuUsuario {

	private Controlador controlador;
	
	public MenuCandidato(Controlador controlador) {
		this.controlador = controlador;
	}
	
	@Override
	public void cadastrar() {
		System.out.println("\n=== Cadastro ===");
		String nome = Main.lerTexto("Digite o nome: ");
		int idade = Main.lerInteiro("Digite a idade: ");
		String cpf = Main.lerTexto("Digite o cpf: ");
		String email = Main.lerTexto("Digite o email: ");
		String senha = Main.lerTexto("Digite a senha: ");	
		
		boolean resultado = controlador.cadastrarCandidato(nome, idade, cpf, email, senha);
		
		if(resultado) {
			System.out.println("Candidato cadastrado com sucesso.");
		} else {
			System.out.println("Não foi possível cadastrar o candidato.");
		}
	}
	
	@Override
	public void menu() {
		int opcao;
		
		do {
			exibirMenu();
			opcao = Main.lerInteiro("Sua escolha: ");
			switch(opcao) {
				case 0:
					System.out.println("Voltando...");
					break;
				case 1:
					exibirMenuCurriculo();
					opcoesDeCurriculo();
					break;
				case 2:
					exibirMenuCandidatura();
					opcoesDeCandidatura();
					break;
				case 3:
					exibirMenuDadosPessoais();
					opcoesDeDadosPessoais();
					break;
				default:
					System.out.println("Opcao inválida.");
			}
		} while(opcao != 0);
	}
		
	private void exibirMenu() {
		System.out.println("\n=== Menu Candidato ===");
		System.out.println("1 - Curriculo");	
		System.out.println("2 - Candidaturas");
		System.out.println("3 - Dados pessoais");
		System.out.println("0 - Sair");
	}
	
	private void exibirMenuCurriculo() {
		System.out.println("\n=== Menu Curriculo ===");
		System.out.println("1 - Cadastrar currículo");
		System.out.println("2 - Ver curriculo");
		System.out.println("3 - Adicionar formação");
		System.out.println("4 - Alterar formação");
		System.out.println("5 - Alterar experiência");
		System.out.println("6 - Adicionar habilidades");
		System.out.println("7 - Alterar habilidades");
		System.out.println("8 - Adicionar idiomas");
		System.out.println("9 - Alterar idiomas");
		System.out.println("0 - Sair");
	}
	
	private void opcoesDeCurriculo() {
		int opcao = Main.lerInteiro("Selecione uma opcao: ");
		switch(opcao) {
			case 0:
				System.out.println("Voltando...");
				break;
			case 1:
				cadastrarCurriculo();
				break;
			case 2:
				System.out.println(controlador.exibirCurriculo());
				break;
			case 3:
				adicionarFormacao();
				break;
			case 4:
				alterarFormacao();
				break;
			case 5:
				alterarExperiencia();
				break;
			case 6:
				adicionarHabilidades();
				break;
			case 7:
				alterarHabilidades();
				break;
			case 8:
				adicionarIdiomas();
				break;
			case 9:
				alterarIdiomas();
				break;
			default:
				System.out.println("Opção inválida.");
		}
	}
	
	private void cadastrarCurriculo() {
		System.out.println();
		Set<String> formacoes = cadastrarFormacoes();
		String experiencia = Main.lerTexto("Digite a experiência: ");
		Set<String> habilidades = cadastrarHabilidades();
		Set<String> idiomas = cadastrarIdiomas();
		
		boolean resultado = controlador.cadastrarCurriculo(formacoes, experiencia, habilidades, idiomas);
		if(resultado) {
			System.out.println("Currículo cadastrado com sucesso.");
		} else {
			System.out.println("Não foi possível cadastrar o currículo.");
		}
	}
	
	private Set<String> cadastrarFormacoes() {
		String opcao = "";
		Set<String> formacoes = new HashSet<String>();
		do {
			String formacao = Main.lerTexto("Digite a formação: ");
			formacoes.add(formacao);
			opcao = Main.lerTexto("Deseja adicionar mais formações? (N/S) ");
		} while(opcao.equalsIgnoreCase("S"));
		
		return formacoes;
	}
	
	private Set<String> cadastrarHabilidades() {
		String opcao = "";
		Set<String> habilidades = new HashSet<String>();
		do {
			String habilidade = Main.lerTexto("Digite a habilidade: ");
			habilidades.add(habilidade);
			opcao = Main.lerTexto("Deseja adicionar mais habilidades? (N/S) ");
		} while(opcao.equalsIgnoreCase("S"));
		
		return habilidades;
	}
	
	private Set<String> cadastrarIdiomas() {
		String opcao = "";
		Set<String> idiomas = new HashSet<String>();
		do {
			String idioma = Main.lerTexto("Digite o idioma: ");
			idiomas.add(idioma);
			opcao = Main.lerTexto("Deseja adicionar mais idiomas? (N/S) ");
		} while(opcao.equalsIgnoreCase("S"));
		
		return idiomas;
	}

	private void adicionarFormacao() {
		String formacao = Main.lerTexto("\nDigite a formação: ");
		boolean resultado = controlador.adicionarFormacao(formacao);
		if(resultado) {
			System.out.println("Formação adicionada com sucesso.");
		} else {
			System.out.println("Não foi possível adicionar a formação.");
		}
	}
	
	private void alterarFormacao() {
		String formacaoAntiga = Main.lerTexto("\nDigite a formação que deseja alterar: ");
		String formacaoNova = Main.lerTexto("Digite a nova formação: ");
		boolean resultado = controlador.editarFormacao(formacaoAntiga, formacaoNova);
		if(resultado) {
			System.out.println("Formação alterada com sucesso.");
		} else {
			System.out.println("Não foi possível alterar a formação.");
		}		
	}
	
	private void alterarExperiencia() {
		String experiencia = Main.lerTexto("\nDigite a nova experiência: ");
		boolean resultado = controlador.editarExperiencia(experiencia);
		if(resultado) {
			System.out.println("Experiência alterada com sucesso.");
		} else {
			System.out.println("Não foi possível alterar a experiência.");
		}		
	}
	
	private void adicionarHabilidades() {
		String habilidade = Main.lerTexto("\nDigite a habilidade: ");
		boolean resultado = controlador.adicionarHabilidade(habilidade);
		if(resultado) {
			System.out.println("Habilidade adicionada com sucesso.");
		} else {
			System.out.println("Não foi possível adicionar a habilidade.");
		}		
	}
		
	private void alterarHabilidades() {
		String habilidadeAntiga = Main.lerTexto("\nDigite a habilidade que deseja alterar: ");
		String habilidadeNova = Main.lerTexto("Digite a nova habilidade: ");
		boolean resultado = controlador.editarHabilidade(habilidadeAntiga, habilidadeNova);
		if(resultado) {
			System.out.println("Habilidade alterada com sucesso.");
		} else {
			System.out.println("Não foi possível alterar a habilidade.");
		}		
	}
	
	private void adicionarIdiomas() {
		String idioma = Main.lerTexto("\nDigite o idioma: ");
		boolean resultado = controlador.adicionarIdioma(idioma);
		if(resultado) {
			System.out.println("Idioma adicionado com sucesso.");
		} else {
			System.out.println("Não foi possível adicionar o idioma.");
		}
	}
	
	private void alterarIdiomas() {
		String idiomaAntigo = Main.lerTexto("\nDigite o idioma que deseja alterar: ");
		String idiomaNova = Main.lerTexto("Digite o novo idioma: ");
		boolean resultado = controlador.editarIdioma(idiomaAntigo, idiomaNova);
		if(resultado) {
			System.out.println("Idioma alterado com sucesso.");
		} else {
			System.out.println("Não foi possível alterar o idioma.");
		}			
	}

	private void exibirMenuCandidatura() {
		System.out.println("\n=== Menu Candidatura ===");
		System.out.println("1 - Ver vagas");
		System.out.println("2 - Ver candidaturas");
		System.out.println("3 - Se candidatar à vaga");
		System.out.println("4 - Cancelar candidatura");
		System.out.println("0 - Sair");
	}

	private void opcoesDeCandidatura() {
		int opcao = Main.lerInteiro("Selecione uma opcao: ");
		switch(opcao) {
			case 0:
				System.out.println("Voltando...");
				break;
			case 1:
				System.out.println(controlador.verVagas());
				break;
			case 2:
				System.out.println(controlador.getCandidaturaDoCandidato());
				break;
			case 3:
				candidatar();
				break;
			case 4:
				cancelarCandidatura();
				break;
			default:
				System.out.println("Opção inválida.");
		}
	}
	
	private void candidatar() {
		String codigo = Main.lerTexto("\nDigite o codigo da vaga: ");
		boolean resultado = controlador.registrarCandidatura(codigo);
		if(resultado) {
			System.out.println("Candidatura realizada com sucesso.");
		} else {
			System.out.println("Não foi possível realizar a candidatura.");
		}
	}
	
	private void cancelarCandidatura() {
		String codigoDaVaga = Main.lerTexto("\nDigite o codigo da vaga: ");
		int idDaCandidatura = Main.lerInteiro("Digite o id da candidatura: ");
		boolean resultado = controlador.cancelarCandidatura(codigoDaVaga, idDaCandidatura);
		if(resultado) {
			System.out.println("Candidatura cancelada.");
		} else {
			System.out.println("Não foi possível cancelar a candidatura.");
		}
	}

	private void exibirMenuDadosPessoais() {
		System.out.println("\n=== Dados Pessoais ===");
		System.out.println("1 - Ver dados pessoais");
		System.out.println("2 - Alterar nome");
		System.out.println("3 - Alterar senha");
		System.out.println("0 - Sair");
	}
	
	private void opcoesDeDadosPessoais() {
		int opcao = Main.lerInteiro("Selecione uma opcao: ");
		switch(opcao) {
			case 0:
				System.out.println("Voltando...");
				break;
			case 1:
				System.out.println(controlador.exibirDadosDoUsuario());
				break;
			case 2:
				alterarNome();
				break;
			case 3:
				alterarSenha();
				break;
			default:
				System.out.println("Opção inválida.");
		}		
	}

	private void alterarNome() {
		String novoNome = Main.lerTexto("Digite o novo nome: ");
		
		boolean resultdao = controlador.alterarNome(novoNome);
		if(resultdao) {
			System.out.println("Nome alterado com sucesso.");
		} else {
			System.out.println("Não foi possível alterar o nome.");
		}
	}
	
	private void alterarSenha() {
		String novaSenha = Main.lerTexto("Digite a nova senha: ");

		boolean resultado = controlador.alterarSenha(novaSenha);
		if(resultado) {
			System.out.println("Senha alterada com sucesso.");
		} else {
			System.out.println("Não foi possível alterar a senha.");
		}
	}
}
