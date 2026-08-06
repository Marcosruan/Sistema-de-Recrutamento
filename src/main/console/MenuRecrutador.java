package main.console;

import main.controlador.Controlador;
import main.modelos.interfaces.EstrategiaMenuUsuario;

public class MenuRecrutador implements EstrategiaMenuUsuario {
	
	private Controlador controlador;
	
	public MenuRecrutador(Controlador controlador) {
		this.controlador = controlador;
	}

	@Override
	public void menu() {
		exibirMenu();
	}

	private void exibirMenu() {
		System.out.println("=== Menu Recrutador ===");
		System.out.println("1 - Vagas");	
		System.out.println("2 - Candidaturas");	
		System.out.println("3 - Dados pessoais");	
		System.out.println("0 - Sair");
	}

	private void exibirMenuVaga() {
		System.out.println("=== Menu Vaga ===");
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
	
	private void exibirMenuCandidatura() {
		System.out.println("=== Menu Candidatura ===");
		System.out.println("1 - Ver candidaturas");
		System.out.println("2 - Colocar candidatura em análise");
		System.out.println("3 - Marcar entrevista de candidato");
		System.out.println("4 - Aprovar candidatura");
		System.out.println("5 - Reprovar candidatura");
		System.out.println("0 - Sair");
	}
	
	private void exibirMenuDadosPessoais() {
		System.out.println("=== Dados Pessoais ===");
		System.out.println("1 - Ver dados pessoais");
		System.out.println("2 - Alterar nome");
		System.out.println("3 - Alterar senha");
		System.out.println("4 - Alterar empresa");
		System.out.println("0 - Sair");
	}

	@Override
	public void cadastrar() {
		// TODO Auto-generated method stub
		
	}
	
}
