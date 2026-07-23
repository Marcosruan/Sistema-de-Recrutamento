package main.modelos.interfaces;

import main.modelos.usuario.Usuario;

public interface ControleAcesso {

	boolean podeVisualizarUsuario(Usuario usuario);
	
	boolean podeEditar(Usuario usuario);
	
	boolean podeRemover(Usuario usuario);
}
