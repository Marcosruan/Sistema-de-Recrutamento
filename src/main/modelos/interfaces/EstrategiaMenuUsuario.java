package main.modelos.interfaces;

import main.controlador.Controlador;

public interface EstrategiaMenuUsuario {
	void exibirMenu();
	void escolha(int opcao, Controlador controlador);
}
