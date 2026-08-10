package main.modelos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import main.modelos.usuario.Candidato;

public class Curriculo {
	private Set<String> formacoes;
	private String experiencia;
	private Set<String> habilidades;
	private Set<String> idiomas;
	private Candidato candidatoDono;
	
	public Curriculo(Set<String> formacoes, String experiencia, Set<String> habilidades, Set<String> idiomas, Candidato candidatoDono) {
		this.formacoes = new HashSet<String>(formacoes);
		this.experiencia = experiencia;
		this.habilidades = new HashSet<String>(habilidades);
		this.idiomas = new HashSet<String>(idiomas);
		this.candidatoDono = candidatoDono;
	}
	
	private void validaString(String texto) throws IllegalArgumentException {
		if (texto == null || texto.isBlank()) {
			throw new IllegalArgumentException();
		}
	}
	
	public void adicionarFormacao(String formacao) throws IllegalArgumentException{
		validaString(formacao);
		formacoes.add(formacao);
	}
	
	public void adicionarExperiencia(String experiencia) throws IllegalArgumentException{
		validaString(experiencia);
		this.experiencia += " " + experiencia;
	}
	
	public void adicionarHabilidade(String habilidade) {
		validaString(habilidade);
		habilidades.add(habilidade);
	}
	
	public void adicionarIdiomas(String idioma) {
		idiomas.add(idioma);
	}
	
	public void editarExperiencia(String experiencia) throws IllegalArgumentException{
		validaString(experiencia);
		this.experiencia = experiencia;
	}
	
	public void editarFormacao(String formacaoAntiga, String formacaoNova) throws IllegalArgumentException{
		validaString(formacaoAntiga);
		validaString(formacaoNova);
		if (this.formacoes.contains(formacaoAntiga)) {
	        this.formacoes.remove(formacaoAntiga);
	        this.formacoes.add(formacaoNova);
	    } else {
	        throw new IllegalArgumentException("Formação não encontrada para edição.");
	    }
	}
	
	public void editarHabilidade(String habilidadeAntiga, String habilidadeNova) throws IllegalArgumentException {
		validaString(habilidadeAntiga);
		validaString(habilidadeNova);
		if (this.habilidades.contains(habilidadeAntiga)) {
	        this.habilidades.remove(habilidadeAntiga);
	        this.habilidades.add(habilidadeNova);
	    } else {
	        throw new IllegalArgumentException("Formação não encontrada para edição.");
	    }
	}
	
	public void editarIdiomas(String IdiomaAntigo, String idiomaNovo) throws IllegalArgumentException{
		validaString(IdiomaAntigo);
		validaString(idiomaNovo);
		if (this.idiomas.contains(IdiomaAntigo)) {
	        this.idiomas.remove(IdiomaAntigo);
	        this.idiomas.add(idiomaNovo);
	    } else {
	        throw new IllegalArgumentException("Formação não encontrada para edição.");
	    }
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
		curriculo += "----------------------------------------\n";

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

		List<String> formacoesFormatada = quebrarTexto(String.join(", ",formacoes), ", ", 40 - 13);

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
	
	private static List<String> quebrarTexto(String texto, String delimitador, int tamanhoMaximo) {
	    List<String> linhas = new ArrayList<String>();

	    String[] palavras = texto.split(delimitador);
	    String linhaAtual = "";
	    	
	    for (String palavra : palavras) {

	        if (linhaAtual.length() + palavra.length() + 1 > tamanhoMaximo) {
	            if (!linhaAtual.isEmpty()) {
	                linhas.add(linhaAtual);
	            }
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
