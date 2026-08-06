package main.console;

import main.Main;
import main.controlador.Controlador;
import main.modelos.interfaces.EstrategiaMenuUsuario;

public class SistemaConsole {
	
	private Controlador controlador;
	private EstrategiaMenuUsuario estrategia;
	
	public SistemaConsole() {
		this.estrategia = null;
	}
	
	public void iniciarConsole() {
		int opcao = 0;
		do {
			exibirMenu();
			opcao = Main.lerInteiro("Sua escolha: ");
			switch (opcao) {
			case 1 -> cadastrarUsuario();
			case 2 -> fazerLogin();
			case 0 -> System.out.println("Encerrando...");
			default -> System.out.println("Opção inválida.");
			}
		} while(opcao != 0);
	}
	
	private void fazerLogin() {
		escolherTipo();
		String email = Main.lerTexto("E-mail: ");
		String senha = Main.lerTexto("Senha: ");
		boolean sucesso = controlador.login(email, senha);
		if (sucesso) {
			estrategia.menu(controlador);		
		} else {
			System.out.println("Não foi possível fazer login.");
		}
	}
	
	private void cadastrarUsuario() {
		escolherTipo();
		estrategia.cadastrar(controlador);
	}

	private void escolherTipo() {
		int opcao = 0;
		do {
			exibirTipos();
			opcao = Main.lerInteiro("Sua escolha: ");
			switch (opcao) {
			case 1 -> mudarEstrategia(new MenuCandidato());
			case 2 -> mudarEstrategia(new MenuRecrutador());
			default -> System.out.println("Opção inválida.");
			}
		} while(opcao <= 0 || opcao > 2);
	}

	private void exibirMenu() {
		System.out.println("=== Menu Inicial ===");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Login");
		System.out.println("0 - Sair");
	}
	
	private void exibirTipos() {
		System.out.println("Deseja continuar como:");
		System.out.println("1 - Candidato");
		System.out.println("2 - Recrutador");
	}
	
	private void mudarEstrategia(EstrategiaMenuUsuario estrategia) {
		this.estrategia = estrategia;
	}
}
