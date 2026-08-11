package main.console;

import java.util.Scanner;

import main.controlador.Controlador;
import main.modelos.enums.TipoUsuario;
import main.modelos.interfaces.EstrategiaMenuUsuario;

public class SistemaConsole {
	private static Scanner scanner = new Scanner(System.in);
	private Controlador controlador;
	private EstrategiaMenuUsuario estrategia;
	
	public SistemaConsole() {
		this.controlador = new Controlador();
		this.estrategia = null;
	}
	
	public void iniciarConsole() {
		int opcao = 0;
		do {
			exibirMenu();
			opcao = lerInteiro("Sua escolha: ");
			switch (opcao) {
			case 1 -> cadastrarUsuario();
			case 2 -> fazerLogin();
			case 0 -> System.out.println("Programa encerrado.");
			default -> System.out.println("Opção inválida.");
			}
		} while(opcao != 0);
		scanner.close();
	}
	
	private void fazerLogin() {
		TipoUsuario tipo = escolherTipo() == 1 ? TipoUsuario.CANDIDATO : TipoUsuario.RECRUTADOR;
		System.out.println("\n=== Login ===");
		String email = lerTexto("E-mail: ");
		String senha = lerTexto("Senha: ");
		boolean sucesso = controlador.login(email, senha, tipo);
		if (sucesso) {
			estrategia.menu();
		} else {
			System.out.println("Não foi possível fazer login.");
		}
	}
	
	private void cadastrarUsuario() {
		escolherTipo();
		estrategia.cadastrar();
	}

	private int escolherTipo() {
		int opcao = 0;
		do {
			exibirTipos();
			opcao = lerInteiro("Sua escolha: ");
			switch (opcao) {
			case 1 -> mudarEstrategia(new MenuCandidato(controlador));
			case 2 -> mudarEstrategia(new MenuRecrutador(controlador));
			default -> System.out.println("Opção inválida.");
			}
		} while(opcao <= 0 || opcao > 2);
		
		return opcao;
	}

	private void exibirMenu() {
		System.out.println("\n=== Menu Inicial ===");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Login");
		System.out.println("0 - Sair");
	}
	
	private void exibirTipos() {
		System.out.println("\nDeseja continuar como:");
		System.out.println("1 - Candidato");
		System.out.println("2 - Recrutador");
	}
	
	private void mudarEstrategia(EstrategiaMenuUsuario estrategia) {
		this.estrategia = estrategia;
	}
	
	public static int lerInteiro(String mensagem) {
		while (true) {
			System.out.print(mensagem);
			String entrada = scanner.nextLine();

			try {
				return Integer.parseInt(entrada);

			} catch (NumberFormatException e) {
				System.out.println("Digite um numero inteiro valido.");
			}
		}
	}
	
	public static double lerDouble(String mensagem) {
		while (true) {
			System.out.print(mensagem);
			String entrada = scanner.nextLine();

			try {
				return Double.parseDouble(entrada);

			} catch (NumberFormatException e) {
				System.out.println("Digite um numero real valido.");
			}
		}
	}

	public static String lerTexto(String mensagem) {
		System.out.print(mensagem);
		return scanner.nextLine();
	}
}
