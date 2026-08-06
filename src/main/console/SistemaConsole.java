package main.console;

import java.util.Scanner;

import main.controlador.Controlador;
import main.modelos.interfaces.EstrategiaMenuUsuario;

public class SistemaConsole {
	
	private Scanner scanner;
	private Controlador controlador;
	private EstrategiaMenuUsuario estrategia;
	
	public SistemaConsole() {
		this.estrategia = new MenuInicial();
	}
	
	public void iniciarConsole() {
		try {
			estrategia.exibirMenu();
			int opcao = lerInteiro("Sua escolha: ");
			estrategia.escolha(opcao, controlador);			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private int lerInteiro(String mensagem) {
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

	private String lerTexto(String mensagem) {
		System.out.print(mensagem);
		return scanner.nextLine();
	}
}
