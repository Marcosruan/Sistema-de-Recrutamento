package main.console;

import main.controlador.Controlador;
import main.modelos.interfaces.EstrategiaMenuUsuario;

public class MenuInicial implements EstrategiaMenuUsuario {

	@Override
	public void exibirMenu() {
		System.out.println("=== Menu Inicial ===");
		System.out.println("1 - Cadastrar");
		System.out.println("2 - Login");
		System.out.println("0 - Sair");
	}

	@Override
	public void escolha(int opcao, Controlador controlador) {
		switch (opcao) {
		case 1 -> cadastrarUsuario();
		case 2 -> fazerLogin();
		case 0 -> System.out.println("");
		default -> System.out.println("Opção inválida.");
		}
	}

	private void fazerLogin() {
		
	}

	private void cadastrarUsuario() {
		
	}
	
}
