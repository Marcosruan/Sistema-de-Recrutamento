package main.modelos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import main.modelos.interfaces.ControleAcesso;
import main.modelos.usuario.Candidato;
import main.modelos.usuario.Usuario;

public class Curriculo implements ControleAcesso{
	private String formacao;
	private String experiencia;
	private Set<String> habilidades;
	private List<String> cursos;
	private List<String> idiomas;
	private Candidato candidatoDono;
	
	public Curriculo(String formacao, String experiencia, Candidato candidatoDono) {
		validaString(formacao);
		validaString(experiencia);
		validaCandidato(candidatoDono);
		this.formacao = formacao;
		this.experiencia = experiencia;
		this.candidatoDono = candidatoDono;
		this.habilidades = new HashSet<String>();
		this.cursos = new ArrayList<String>();
		this.idiomas = new ArrayList<String>();
	}
	
	private void validaString(String texto) throws IllegalArgumentException {
		if (texto.isBlank() || texto == null) {
			throw new IllegalArgumentException();
		}
	}

	private void validaCandidato(Object obj) throws IllegalArgumentException {
		if (obj == null) {
			throw new IllegalArgumentException();
		}
	}

	public void adicionarHabilidade(String[] habilidades) {
		
	}
	
	public void adicionarCurso(String[] cursos) {
		
	}
	
	public void adicionarIdioma(String[] idiomas) {
		
	}

	@Override
	public boolean podeVisualizar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean podeEditar(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean podeRemover(Usuario usuario) {
		// TODO Auto-generated method stub
		return false;
	}
}
