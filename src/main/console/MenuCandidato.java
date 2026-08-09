package main.console;

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
		exibirMenu();
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
		System.out.println("=== Menu Candidato ===");
		System.out.println("1 - Curriculo");	
		System.out.println("2 - Candidaturas");
		System.out.println("3 - Dados pessoais");
		System.out.println("0 - Sair");
	}
	
	private void exibirMenuCurriculo() {
		System.out.println("=== Menu Curriculo ===");
		System.out.println("1 - Cadastrar currículo");
		System.out.println("2 - Ver curriculo");
		System.out.println("3 - Adicionar formação");
		System.out.println("4 - Alterar formação");
		System.out.println("5 - Adicionar experiência");
		System.out.println("6 - Alterar experiência");
		System.out.println("7 - Adicionar habilidades");
		System.out.println("8 - Alterar habilidades");
		System.out.println("9 - Adicionar idiomas");
		System.out.println("10 - Alterar idiomas");
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
				System.out.println(controlador.verCurriculo());
				break;
			case 3:
				adicionarFormacao();
				break;
			case 4:
				alterarFormacao();
				break;
			case 5:
				adicionarExperiencia();
				break;
			case 6:
				alterarExperiencia();
				break;
			case 7:
				adicionarHabilidades();
				break;
			case 8:
				alterarHabilidades();
				break;
			case 9:
				adicionarIdiomas();
				break;
			case 10:
				alterarIdiomas();
				break;
			default:
				System.out.println("Opção inválida.");
		}
	}
	
	private void cadastrarCurriculo() {
		
	}
	
	private void adicionarIdiomas() {
		// TODO Auto-generated method stub
		
	}
	
	private void alterarFormacao() {
		// TODO Auto-generated method stub
		
	}
	
	private void adicionarHabilidades() {
		// TODO Auto-generated method stub
		
	}
	
	private void alterarExperiencia() {
		// TODO Auto-generated method stub
		
	}
	
	private void adicionarExperiencia() {
		// TODO Auto-generated method stub
		
	}
		
	private void alterarHabilidades() {
		// TODO Auto-generated method stub
		
	}
	
	private void adicionarFormacao() {
		// TODO Auto-generated method stub
		
	}
	
	private void alterarIdiomas() {
		// TODO Auto-generated method stub
		
	}

	private void exibirMenuCandidatura() {
		System.out.println("=== Menu Candidatura ===");
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
				verCandidaturas();
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
	
	private void verCandidaturas() {
		String resultado = controlador.getCandidaturaDoCandidato();
		System.out.println(resultado.toString());
	}
	
	private void candidatar() {
		String codigo = Main.lerTexto("Digite o codigo da vaga: ");
		boolean resultado = controlador.candidatar(codigo);
		if(resultado) {
			System.out.println("Candidatura realizada com sucesso.");
		} else {
			System.out.println("Não foi possível realizar a candidatura.");
		}
	}
	
	private void cancelarCandidatura() {
		String codigoDaVaga = Main.lerTexto("Digite o codigo da vaga: ");
		int idDaCandidatura = Main.lerInteiro("Digite o id da candidatura: ");
		controlador.reprovarCandidatura(codigoDaVaga, idDaCandidatura);
		boolean resultado = controlador.cancelarCandidatura(codigoDaVaga, idDaCandidatura);
		if(resultado) {
			System.out.println("Candidatura cancelada.");
		} else {
			System.out.println("Não foi possível cancelar a candidatura.");
		}
	}

	private void exibirMenuDadosPessoais() {
		System.out.println("=== Dados Pessoais ===");
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
				System.out.println(controlador.verVagas());
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
