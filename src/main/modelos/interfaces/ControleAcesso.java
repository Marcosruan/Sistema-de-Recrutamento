package main.modelos.interfaces;

import main.modelos.usuario.Usuario;

public interface ControleAcesso {

	boolean podeVisualizar();
	
	boolean podeEditar();
	
	boolean podeRemover();
}
