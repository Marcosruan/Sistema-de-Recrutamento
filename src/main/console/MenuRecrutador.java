package main.console;

import main.controlador.Controlador;
import main.modelos.interfaces.EstrategiaMenuUsuario;

public class MenuRecrutador implements EstrategiaMenuUsuario {
	
	private Controlador controlador;
	
	public MenuRecrutador(Controlador controlador) {
		this.controlador = controlador;
	}

	@Override
	public void cadastrar() {
		System.out.println("\n=== Cadastro ===");
		String nome = SistemaConsole.lerTexto("Digite o nome: ");
		int idade = SistemaConsole.lerInteiro("Digite a idade: ");
		String cpf = SistemaConsole.lerTexto("Digite o cpf: ");
		String email = SistemaConsole.lerTexto("Digite o email: ");
		String senha = SistemaConsole.lerTexto("Digite a senha: ");
		String empresa = SistemaConsole.lerTexto("Digite a empresa: ");
		
		boolean resultado = controlador.cadastrarRecrutador(nome, idade, cpf, email, senha, empresa);
		
		if(resultado) {
			System.out.println("Recrutador cadastrado com sucesso.");
		} else {
			System.out.println("Não foi possível cadastrar o recrutador.");
		}
	}
	
	@Override
	public void menu() {
		int opcao;
		
		do {
			exibirMenu();
			opcao = SistemaConsole.lerInteiro("Sua escolha: ");
			switch(opcao) {
				case 0:
					System.out.println("Voltando...");
					break;
				case 1:
					exibirMenuVaga();
					opcoesDeVaga();
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
		System.out.println("\n=== Menu Recrutador ===");
		System.out.println("1 - Vagas");	
		System.out.println("2 - Candidaturas");	
		System.out.println("3 - Dados pessoais");	
		System.out.println("0 - Sair");
	}

	private void exibirMenuVaga() {
		System.out.println("\n=== Menu Vaga ===");
		System.out.println("1 - Cadastrar vaga");
		System.out.println("2 - Ver vagas");
		System.out.println("3 - Abrir vaga");
		System.out.println("4 - Fechar vaga");
		System.out.println("5 - Alterar título da vaga");
		System.out.println("6 - Alterar descrição da vaga");
		System.out.println("7 - Alterar requisitos da vaga");
		System.out.println("8 - Alterar salário da vaga");
		System.out.println("9 - Alterar cidade da vaga");
		System.out.println("0 - Sair");
	}
	
	private void opcoesDeVaga() {
		int opcao = SistemaConsole.lerInteiro("Selecione uma opcao: ");
		switch(opcao) {
			case 0:
				System.out.println("Voltando...");
				break;
			case 1:
				cadastrarVaga();
				break;
			case 2:
				System.out.println(controlador.verVagas());
				break;
			case 3:
				abrirVaga();
				break;
			case 4:
				fecharVaga();
				break;
			case 5:
				alterarTitulo();
				break;
			case 6:
				alterarDescricao();
				break;
			case 7:
				alterarRequisitos();
				break;
			case 8:
				alterarSalario();
				break;
			case 9:
				alterarCidade();
				break;
			default:
				System.out.println("Opção inválida.");
		}
	}
	
	private void cadastrarVaga() {
		String codigo = SistemaConsole.lerTexto("\nDigite o codigo: ");
		String titulo = SistemaConsole.lerTexto("Digite o titulo: ");
		String descricao = SistemaConsole.lerTexto("Digite a descricao: ");
		String requisitos = SistemaConsole.lerTexto("Digite os requisitos: ");
		double salario = SistemaConsole.lerDouble("Digite o salario: ");
		String cidade = SistemaConsole.lerTexto("Digite a cidade: ");
		
		boolean resultado = controlador.cadastrarVaga(codigo, titulo, descricao, requisitos, salario, cidade);
		
		if(resultado) {
			System.out.println("Vaga cadastrada com sucesso.");
		} else {
			System.out.println("Não foi possível cadastrar a vaga.");
		}
	}
	
	private void abrirVaga() {
		String codigo = SistemaConsole.lerTexto("\nDigite o codigo da vaga: ");
		boolean resulatado = controlador.abrirVaga(codigo);
		if(resulatado){
			System.out.println("Vaga aberta");
		} else {
			System.out.println("Não foi possível abrir a vaga.");
		}
	}
	
	private void fecharVaga() {
		String codigo = SistemaConsole.lerTexto("\nDigite o codigo da vaga: ");
		boolean resulatado = controlador.fecharVaga(codigo);
		if(resulatado){
			System.out.println("Vaga fechada");
		} else {
			System.out.println("Não foi possível fechar a vaga.");
		}
	}
	
	private void alterarTitulo() {
		String codigo = SistemaConsole.lerTexto("\nCodigo da vaga: ");
		String novoTitulo = SistemaConsole.lerTexto("Digite o novo titulo: ");
		boolean resultado = controlador.alterarTituloVaga(codigo, novoTitulo);
		
		if(resultado) {
			System.out.println("Título da vaga alterado.");
		} else {
			System.out.println("Não foi possível alterar o título.");
		}
	}
	
	private void alterarDescricao() {
		String codigo = SistemaConsole.lerTexto("\nCodigo da vaga: ");
		String novaDescricao = SistemaConsole.lerTexto("Digite a nova descrição: ");
		boolean resultado = controlador.alterarDescricaoVaga(codigo, novaDescricao);
		
		if(resultado) {
			System.out.println("Descrição da vaga alterada.");
		} else {
			System.out.println("Não foi possível alterar a descrição.");
		}
	}

	private void alterarRequisitos() {
		String codigo = SistemaConsole.lerTexto("\nCodigo da vaga: ");
		String novosRequisitos = SistemaConsole.lerTexto("Digite os novos requisitos: ");
		boolean resultado = controlador.alterarRequisitosVaga(codigo, novosRequisitos);
		
		if(resultado) {
			System.out.println("Requisitos da vaga alterados.");
		} else {
			System.out.println("Não foi possível alterar os requisitos.");
		}
	}

	private void alterarSalario() {
		String codigo = SistemaConsole.lerTexto("\nCodigo da vaga: ");
		double novoSalario = SistemaConsole.lerDouble("Digite o novo salário: ");
		boolean resultado = controlador.alterarSalarioVaga(codigo, novoSalario);
		
		if(resultado) {
			System.out.println("Salário da vaga alterado.");
		} else {
			System.out.println("Não foi possível alterar o salário.");
		}
	}

	private void alterarCidade() {
		String codigo = SistemaConsole.lerTexto("\nCodigo da vaga: ");
		String novaCidade = SistemaConsole.lerTexto("Digite a nova cidade: ");
		boolean resultado = controlador.alterarCidadeVaga(codigo, novaCidade);
		
		if(resultado) {
			System.out.println("Cidade da vaga alterada.");
		} else {
			System.out.println("Não foi possível alterar a cidade.");
		}
	}
	
	private void exibirMenuCandidatura() {
		System.out.println("\n=== Menu Candidatura ===");
		System.out.println("1 - Ver candidaturas");
		System.out.println("2 - Ver currículo do candidato");
		System.out.println("3 - Colocar candidatura em análise");
		System.out.println("4 - Marcar entrevista de candidato");
		System.out.println("5 - Aprovar candidatura");
		System.out.println("6 - Reprovar candidatura");
		System.out.println("0 - Sair");
	}
	
	private void opcoesDeCandidatura() {
		int opcao = SistemaConsole.lerInteiro("Digite sua opcao: ");
		
		switch(opcao) {
			case 0:
				System.out.println("Voltando...");
				break;
			case 1:
				verCandidaturas();
				break;
			case 2:
				verCurriculoDoCandidato();
				break;
			case 3:
				candidaturaEmAnalise();
				break;
			case 4:
				marcarEntrevista();
				break;
			case 5:
				aprovarCandidatura();
				break;
			case 6:
				reprovarCandidatura();
				break;
			default:
				System.out.println("Opção inválida.");
		}
	}
	
	private void verCurriculoDoCandidato() {
		String codigoDaVaga = SistemaConsole.lerTexto("\nInforme o codigo da vaga: ");
		int idDaCandidatura = SistemaConsole.lerInteiro("Digite o id da candidatura: ");
		
		String resultado = controlador.exibirCurriculoDoCandidato(codigoDaVaga, idDaCandidatura);
		System.out.println(resultado);
	}

	private void verCandidaturas() {
		String codigoDaVaga = SistemaConsole.lerTexto("\nInforme o codigo da vaga: ");
		System.out.println("Candidaturas para esta vaga: ");
		System.out.println(controlador.verCandidaturasPorVaga(codigoDaVaga));
	}
	
	private void candidaturaEmAnalise() {
		String codigoDaVaga = SistemaConsole.lerTexto("\nDigite o codigo da vaga: ");
		int idDaCandidatura = SistemaConsole.lerInteiro("Digite o id da candidatura: ");
		
		boolean resultado = controlador.colocarCandidaturaEmAnalise(codigoDaVaga, idDaCandidatura);
		if(resultado) {
			System.out.println("Status da cadidatura mudado para em analise.");
		} else {
			System.out.println("Não possível mudar o status.");
		}
	}
	
	private void marcarEntrevista() {
		String codigoDaVaga = SistemaConsole.lerTexto("\nDigite o codigo da vaga: ");
		int idDaCandidatura = SistemaConsole.lerInteiro("Digite o id da candidatura: ");

		boolean resultado = controlador.marcarEntrevista(codigoDaVaga, idDaCandidatura);
		if(resultado) {
			System.out.println("Entrevista marcada para o candidato.");
		} else {
			System.out.println("Não foi possível marcar a entrevista.");
		}
	}

	private void aprovarCandidatura() {
		String codigoDaVaga = SistemaConsole.lerTexto("\nDigite o codigo da vaga: ");
		int idDaCandidatura = SistemaConsole.lerInteiro("Digite o id da candidatura: ");

		boolean resultado = controlador.aprovarCandidatura(codigoDaVaga, idDaCandidatura);
		if(resultado) {
			System.out.println("Candidatura aprovada.");
		} else {
			System.out.println("Não foi possível aprovar a candidatura.");
		}
	}

	private void reprovarCandidatura() {
		String codigoDaVaga = SistemaConsole.lerTexto("\nDigite o codigo da vaga: ");
		int idDaCandidatura = SistemaConsole.lerInteiro("Digite o id da candidatura: ");

		boolean resultado = controlador.reprovarCandidatura(codigoDaVaga, idDaCandidatura);
		if(resultado) {
			System.out.println("Candidatura reprovada.");
		} else {
			System.out.println("Não foi possível reprovar a candidatura.");
		}
	}
	
	private void exibirMenuDadosPessoais() {
		System.out.println("\n=== Dados Pessoais ===");
		System.out.println("1 - Ver dados pessoais");
		System.out.println("2 - Alterar nome");
		System.out.println("3 - Alterar senha");
		System.out.println("4 - Alterar empresa");
		System.out.println("0 - Sair");
	}

	private void opcoesDeDadosPessoais() {
		int opcao = SistemaConsole.lerInteiro("Digite sua opcao: ");
		
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
			case 4:
				alterarEmpresa();
				break;
			default:
				System.out.println("Opção inválida.");
		}
	}
	
	private void alterarNome() {
		String novoNome = SistemaConsole.lerTexto("\nDigite o novo nome: ");
		
		boolean resultdao = controlador.alterarNome(novoNome);
		if(resultdao) {
			System.out.println("Nome alterado com sucesso.");
		} else {
			System.out.println("Não foi possível alterar o nome.");
		}
	}
	
	private void alterarSenha() {
		String novaSenha = SistemaConsole.lerTexto("\nDigite a nova senha: ");

		boolean resultado = controlador.alterarSenha(novaSenha);
		if(resultado) {
			System.out.println("Senha alterada com sucesso.");
		} else {
			System.out.println("Não foi possível alterar a senha.");
		}
	}

	private void alterarEmpresa() {
		String novaEmpresa = SistemaConsole.lerTexto("\nDigite a nova empresa: ");

		boolean resultado = controlador.alterarEmpresa(novaEmpresa);
		if(resultado) {
			System.out.println("Empresa alterada com sucesso.");
		} else {
			System.out.println("Não foi possível alterar a empresa.");
		}
	}
}
