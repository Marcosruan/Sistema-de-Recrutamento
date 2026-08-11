package main.modelos.usuario;

import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;

import main.modelos.Candidatura;
import main.modelos.Curriculo;
import main.modelos.enums.TipoUsuario;

public class Candidato extends Usuario {
	
	private Curriculo curriculo;
	private Set<Candidatura> candidaturas;

	public Candidato(String nome, int idade, String cpf, String email, String senha) throws IllegalArgumentException {
		super(nome, idade, cpf, email, senha);
		this.candidaturas = new HashSet<Candidatura>();
	}
	
	private void validarCurriculo() throws IllegalStateException{
		if(curriculo == null) {
			throw new IllegalStateException("O candidato ainda não possui um currículo cadastrado.");
		}
	}
	
	public void cadastrarCurriculo(Curriculo curriculo) throws IllegalArgumentException{
		if(curriculo == null) {
	        throw new IllegalArgumentException("O currículo não pode ser nulo.");
		}
		this.curriculo = curriculo;
	}
	
	public void adicionarExperienciaCurriculo(String novaExperiencia) {
        validarCurriculo();
        this.curriculo.adicionarExperiencia(novaExperiencia); 
	}
	
	public void adicionarFormacaoCurriculo(String novaFormacao) {
        validarCurriculo();
        this.curriculo.adicionarFormacao(novaFormacao); 
	}
	
	public void adicionarHabilidadeCurriculo(String novaHabilidade) {
        validarCurriculo();
        this.curriculo.adicionarHabilidade(novaHabilidade);
	}
	
	public void adicionarIdiomasCurriculo(String novoIdioma) {
        validarCurriculo();
        this.curriculo.adicionarIdiomas(novoIdioma); 
	}
	
	public void editarFormacaoCurriculo(String formacaoAntiga, String formacaoNova) throws IllegalArgumentException, IllegalStateException{
        validarCurriculo();
        this.curriculo.editarFormacao(formacaoAntiga, formacaoNova); 
    }
	
	public void editarHabilidadeCurriculo(String habilidadeAntiga, String habilidadeNova) throws IllegalArgumentException, IllegalStateException{
        validarCurriculo();
        this.curriculo.editarHabilidade(habilidadeAntiga, habilidadeNova); 
	}
	
	public void editarIdiomasCurriculo(String idiomaAntigo, String idiomaNovo) throws IllegalArgumentException, IllegalStateException {
        validarCurriculo();
        this.curriculo.editarIdiomas(idiomaAntigo, idiomaNovo); 
	}
	
	public void deletarCurriculo()  throws IllegalStateException{
		validarCurriculo();
		curriculo = null;
	}
	
	public Curriculo getCurriculo() {
		return curriculo;
	}
	
	public boolean candidatarVaga(Candidatura candidatura) throws IllegalArgumentException, IllegalStateException {
		return candidaturas.add(candidatura);
	}
	
	public Set<Candidatura> getCandidaturas() {
		return candidaturas;
	}

	public String visualizarCandidaturas() {
		if(candidaturas.isEmpty()) return "Sem candidaturas registradas!";
		List<String> textoCandidaturas = new ArrayList<String>();
		for(Candidatura candidatura: candidaturas) {
			textoCandidaturas.add(candidatura.toString());
		}
		return String.join("\n", textoCandidaturas);
	}

	@Override
	public String toSummaryString() {
		return "[Candidato] Nome: " + getNome() + " | Email: " + getEmail();
	}

	@Override
	public TipoUsuario getTipo() {
		return TipoUsuario.CANDIDATO;
	}
}
