package main.console;

import main.controlador.Controlador;
import main.modelos.interfaces.EstrategiaMenuUsuario;

public class MenuCandidato implements EstrategiaMenuUsuario {

	private Controlador controlador;
	
	public MenuCandidato(Controlador controlador) {
		this.controlador = controlador;
	}
	
	@Override
	public void menu() {
		exibirMenu();
	}
	
	private void exibirMenu() {
		System.out.println("=== Menu Candidato ===");
		System.out.println("1 - Curriculo");	
		System.out.println("2 - Candidaturas");	
		System.out.println("3 - Dados pessoais");
		System.out.println("0 - Sair");
	}
	
	private void exibirMenuCandidatura() {
		System.out.println("=== Menu Candidatura ===");
		System.out.println("1 - Ver vagas");
		System.out.println("2 - Ver candidaturas");
		System.out.println("3 - Se candidatar à vaga");
		System.out.println("4 - Remover candidatura");
		System.out.println("0 - Sair");
	}
	
	private void exibirMenuCurriculo() {
		System.out.println("=== Menu Curriculo ===");
		System.out.println("1 - Cadastrar currículo");
		System.out.println("2 - Ver curriculo");
		System.out.println("3 - Alterar formação");
		System.out.println("4 - Alterar experiência");
		System.out.println("5 - Alterar habilidades");
		System.out.println("6 - Alterar idiomas");
		System.out.println("7 - Alterar cidade da vaga");
		System.out.println("0 - Sair");
	}
	
	private void exibirMenuDadosPessoais() {
		System.out.println("=== Dados Pessoais ===");
		System.out.println("1 - Ver dados pessoais");
		System.out.println("2 - Alterar nome");
		System.out.println("3 - Alterar senha");
		System.out.println("0 - Sair");
	}

	@Override
	public void cadastrar() {
		// TODO Auto-generated method stub
		
	}

}
