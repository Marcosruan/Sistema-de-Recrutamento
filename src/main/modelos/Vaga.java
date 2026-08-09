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
	
	public Vaga(String codigo, String titulo, String descricao, String requisitos, double salario, String cidade, String empresa) {
		this.codigo = codigo;
		this.titulo = titulo;
		this.descricao = descricao;
		this.requisitos = requisitos;
		this.salario = salario;
		this.cidade = cidade;
		this.empresa = empresa;
		this.aberta = true;
		this.candidaturas = new ArrayList<Candidatura>();
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

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getRequisitos() {
		return requisitos;
	}

	public void setRequisitos(String requisitos) {
		this.requisitos = requisitos;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getCidade() {
		return cidade;
	}
	public boolean getAberta() {
		return aberta;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	public List<Candidatura> getCandidaturas() {
		return candidaturas;
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
