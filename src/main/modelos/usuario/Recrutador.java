package main.modelos.usuario;

public class Recrutador extends Usuario {

	private String empresa;
	
	public Recrutador(String nome, String cpf, String email, String senha, String empresa) throws IllegalArgumentException {
		super(nome, cpf, email, senha);
		if(empresa == null) {
			throw new IllegalArgumentException("Empresa inválida");
		}
		
		this.empresa = empresa;
	}
	
	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) throws IllegalArgumentException{
		if(empresa.isBlank() || empresa == null) {
			throw new IllegalArgumentException("Nome de empresa inválido");
		}
		
		this.empresa = empresa;
	}

	@Override
	public String toSummaryString() {
		return "[Recrutador] Nome: " + getNome() + " | Email: " + getEmail() + " | Empresa: " + getEmpresa();
	}

}
