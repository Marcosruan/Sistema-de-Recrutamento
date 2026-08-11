package main.modelos;

import java.util.ArrayList;
import java.util.List;

public class Vaga {
	
	private String codigo;
	private String titulo;
	private String descricao;
	private String requisitos;
	private double salario;
	private String cidade;
	private String empresa;
	private boolean aberta;
	private List<Candidatura> candidaturas;
	private int totalDeCandidaturas = 0;

	public Vaga(String codigo, String titulo, String descricao, String requisitos, double salario, String cidade, String empresa) throws IllegalArgumentException {
		validarString(codigo, "Código inválido!");
		validarString(titulo, "Título inválido!");
		validarString(descricao, "Descrição inválida!");
		validarString(requisitos, "Requisitos inválidos!");
		validarSalario(salario);
		validarString(cidade, "Cidade inválida!");
		validarString(empresa, "Empresa inválida");
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.requisitos = requisitos;
		this.salario = salario;
		this.cidade = cidade;
		this.empresa = empresa;
		this.aberta = true;
		this.candidaturas = new ArrayList<Candidatura>();
		totalDeCandidaturas++;
	}
	
	private void validarSalario(double salario) {
		if(salario <= 0.0) {
			throw new IllegalArgumentException("Salário inválido. Informe um valor maior que zero!");
		}
		
	}

	private void validarString(String texto,String mensagem) throws IllegalArgumentException {
		if (texto == null || texto.isBlank()) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	public void abrirVaga() {
		this.aberta = true;
	}
	
	public void fecharVaga() {
		this.aberta = false;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) throws IllegalArgumentException {
		validarString(titulo, "Título inválido!");
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) throws IllegalArgumentException {
		validarString(descricao, "Descrição inválida!");
		this.descricao = descricao;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) throws IllegalArgumentException {
		validarString(requisitos, "Requisitos inválidos!");
		this.requisitos = requisitos;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) throws IllegalArgumentException {
		validarSalario(salario);
		this.salario = salario;
	}

	public String getCidade() {
		return cidade;
	}
	
	public boolean getAberta() {
		return aberta;
	}
	
	public void setCidade(String cidade) throws IllegalArgumentException {
		validarString(cidade, "Cidade inválida!");
		this.cidade = cidade;
	}
	
	public List<Candidatura> getCandidaturas() {
		return candidaturas;
	}
	
	public void setCandidaturas(Candidatura candidatura) {
		this.candidaturas.add(candidatura);
	}
	
	public int getTotalDeCandidaturas() {
		return totalDeCandidaturas;
	}
	
	@Override
	public String toString() {
		String estado = aberta == true ? "Aberta" : "Fechada";
		return String.format("Codigo: %s | Titulo: %s | Descricao: %s | Requisitos: %s | Salario: %,.2f | Cidade: %s | Empresa: %s | Estado: %s",
				codigo,
				titulo,
				descricao,
				requisitos,
				salario,
				cidade,
				empresa,
				estado
				);
	}
}
