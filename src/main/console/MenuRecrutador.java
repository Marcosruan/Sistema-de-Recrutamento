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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cadastrar() {
		// TODO Auto-generated method stub
		
	}
	
}
