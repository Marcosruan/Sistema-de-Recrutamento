package main.modelos.enums;

public enum StatusCandidatura {
	EM_ANALISE("Em análise"),
	ENTREVISTA("Em entrevista"),
	APROVADO("Aprovada"),
	REPROVADO("Reprovada"),
	CANCELADA("Cancelada");
	
	private String texto;
	
	private StatusCandidatura(String texto) {
		this.texto = texto;
	}

	public String getTexto() {
		return texto;
	}
}
