package main.modelos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import main.modelos.usuario.Candidato;
import main.modelos.usuario.Usuario;

public class Curriculo {
	private Set<String> formacoes;
	private String experiencia;
	private Set<String> habilidades;
	private Set<String> idiomas;
	private Candidato candidatoDono;
	
	public Curriculo(Candidato candidatoDono) {
		validaCandidato(candidatoDono);
		this.formacoes = new HashSet<String>();
		this.habilidades = new HashSet<String>();
		this.idiomas = new HashSet<String>();
		this.candidatoDono = candidatoDono;
	}
	
	private void validaString(String texto) throws IllegalArgumentException {
		if (texto == null || texto.isBlank()) {
			throw new IllegalArgumentException();
		}
	}

	private void validaCandidato(Object obj) throws IllegalArgumentException {
		if (obj == null) {
			throw new IllegalArgumentException();
		}
	}
	public void adicionarFormacao(String formacao) throws IllegalArgumentException{
		validaString(formacao);
		formacoes.add(formacao);
	}
	public void adicionarExperiencia(String experiencia) throws IllegalArgumentException{
		validaString(experiencia);
		this.experiencia = experiencia;
	}
	public void adicionarHabilidade(String habilidade) {
		validaString(habilidade);
		habilidades.add(habilidade);
	}
	public void adicionarIdiomas(String idioma) {
		validaCandidato(idioma);
		idiomas.add(idioma);
	}
	public void editarrFormacao(String formacao) throws IllegalArgumentException{
		validaString(formacao);
		formacoes.clear();
		formacoes.add(formacao);
	}
	public void editarExperiencia(String experiencia) throws IllegalArgumentException{
		validaString(experiencia);
		this.experiencia = experiencia;
	}
	public void editarHabilidade(String habilidade) {
		validaString(habilidade);
		habilidades.clear();
		habilidades.add(habilidade);
	}
	public void editarIdiomas(String idioma) {
		validaCandidato(idioma);
		idiomas.clear();
		idiomas.add(idioma);
	}
	
	@Override
	public String toString() {
		String curriculo = "";
		curriculo += """
			    ==================================================
			    |                  CURRICULO                     |
			    ==================================================
			    """;
		curriculo += String.format("| Nome: %s%n", candidatoDono.getNome());
		curriculo += String.format("| Idade: %d%n", candidatoDono.getIdade());
		curriculo += String.format("| Email: %s%n", candidatoDono.getEmail());
		curriculo += "----------------------------------------";
		List<String> experienciaFormatada = quebrarTexto(experiencia, " ", 40 - 14);
		for (int i = 0; i < experienciaFormatada.size(); i++) {
		    if (i == 0) {
		        curriculo += ("| Experiencia: ") +
 		                 experienciaFormatada.get(i) +
		                 "\n";
		    } else {
		        curriculo += "|\t\t\t" + 
		                 experienciaFormatada.get(i) +
		                 "\n";
		    }
		}
		List<String> formacoesFormatada = quebrarTexto(String.join(", "), ", ", 40 - 13);
		for (int i = 0; i < formacoesFormatada.size(); i++) {
		    if (i == 0) {
		        curriculo += ("| Formações: ") +
		        		formacoesFormatada.get(i) +
		                 "\n";
		    } else {
		        curriculo += "|\t\t\t" + 
		        		formacoesFormatada.get(i) +
		                 "\n";
		    }
		}
		List<String> habilidadesFormatadas = quebrarTexto(String.join(", ", habilidades), ", ", 40 - 15);
		for (int i = 0; i < habilidadesFormatadas.size(); i++) {
		    if (i == 0) {
		        curriculo += ("| Habilidades: ") +
		        		habilidadesFormatadas.get(i) +
		                 "\n";
		    } else {
		        curriculo += "|\t\t\t" + 
		        		habilidadesFormatadas.get(i) +
		                 "\n";
		    }
		}
		List<String> idiomasFormatados = quebrarTexto(String.join(", ",idiomas), ", ", 40 - 11);
		for (int i = 0; i < idiomasFormatados.size(); i++) {
		    if (i == 0) {
		        curriculo += ("| Idiomas: ") +
		        		idiomasFormatados.get(i) +
		                 "\n";
		    } else {
		        curriculo += "|\t\t" + 
		        		idiomasFormatados.get(i) +
		                 "\n";
		    }
		}

				
 		curriculo += "========================================";
		return curriculo;
				
	}
	private static List<String> quebrarTexto(String texto,String delimitador, int tamanhoMaximo) {
	    List<String> linhas = new ArrayList<String>();

	    String[] palavras = texto.split(delimitador);
	    String linhaAtual = "";
	    	
	    for (String palavra : palavras) {

	        if (linhaAtual.length() + palavra.length() + 1 > tamanhoMaximo) {
	            linhas.add(linhaAtual);
	            linhaAtual = "";
	        }

	        if (!linhaAtual.isEmpty()) {
	            linhaAtual += delimitador;
	        }

	        linhaAtual += palavra;
	    }

	    if (!linhaAtual.isEmpty()) {
	        linhas.add(linhaAtual);
	    }

	    return linhas;
	}
}
