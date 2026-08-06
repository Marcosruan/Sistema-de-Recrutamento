package main;

import java.util.Scanner;

import main.console.SistemaConsole;

public class Main {
	
	private static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		SistemaConsole console = new SistemaConsole();
		console.iniciarConsole();
		scanner.close();
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

	public static String lerTexto(String mensagem) {
		System.out.print(mensagem);
		return scanner.nextLine();
	}
}
