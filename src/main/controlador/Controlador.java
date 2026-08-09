package main.controlador;

import java.util.Set;

import main.modelos.Candidatura;
import main.modelos.Sistema;
import main.modelos.Vaga;

public class Controlador {
	
	private Sistema sistema;
	
	public Controlador() {
		this.sistema = new Sistema();
	}
	
	public boolean cadastrarCandidato(String nome, int idade, String cpf, String email, String senha) {
		return sistema.cadastrarCandidato(nome, idade, cpf, email, senha);
	}
	public boolean cadastrarRecrutador(String nome, int idade, String cpf, String email, String senha, String empresa) {
		return sistema.cadastrarRecrutador(nome, idade, cpf, email, senha, empresa);
	}
	public boolean login(String email, String senha) {
		return sistema.login(email, senha);
	}
	public boolean logout() {
		return sistema.logout();
	}

	public String exibirDadosDoUsuario() {
		return sistema.exibirDadosDoUsuario();
	}
	public boolean alterarNome(String novoNome) {
		return sistema.alterarNome(novoNome);
	}
	public boolean alterarSenha(String novaSenha) {
		return sistema.alterarSenha(novaSenha);
	}
	public boolean alterarEmpresa(String empresa) {
		return sistema.alterarEmpresa(empresa);
	}
	public boolean cadastrarVaga(String codigo, String titulo, String descricao, String requisitos, double salario, String cidade, String empresa) {
		return sistema.cadastrarVaga(codigo, titulo, descricao, requisitos, salario, cidade, empresa);
	}
	public Vaga buscarVaga(String codigo) {
		return sistema.buscarVaga(codigo);
	}
	public String verVagas() {
		return sistema.verVagas();
	}
	public boolean alterarTituloVaga(String codigo, String novoTitulo) {
		return sistema.alterarTituloVaga(codigo, novoTitulo);
	}
	public boolean alterarDescricaoVaga(String codigo, String novoDescricao) {
		return sistema.alterarDescricaoVaga(codigo, novoDescricao);
	}
	public boolean alterarRequisitosVaga(String codigo, String novoRequisitos) {
		return sistema.alterarRequisitosVaga(codigo, novoRequisitos);
	}
	public boolean alterarSalarioVaga(String codigo, double novoSalario) {
		return sistema.alterarSalarioVaga(codigo, novoSalario);
	}
	public boolean alterarCidadeVaga(String codigo, String novoCidade) {
		return sistema.alterarCidadeVaga(codigo, novoCidade);
	}
	public boolean abrirVaga(String codigo) {
		return sistema.abrirVaga(codigo);
	}
	public boolean fecharVaga(String codigo) {
		return sistema.fecharVaga(codigo);
	}
	public boolean registrarCandidatura(String codigo) {
		return sistema.registrarCandidatura(codigo);
	}
	public String verCadidaturas(String codigo) {
		return sistema.verCadidaturas(codigo);
	}
	public Candidatura getCandidatura(String codigo, int id) {
		return sistema.getCandidatura(codigo, id);
	}
	public boolean colocarCandidaturaEmAnalise(String codigo, int id) {
		return sistema.colocarCandidaturaEmAnalise(codigo, id);
	}
	public boolean marcarEntrevista(String codigo, int id) {
		return sistema.marcarEntrevista(codigo, id);
	}
	public boolean aprovarCandidatura(String codigo, int id) {
		return sistema.aprovarCandidatura(codigo, id);
	}
	public boolean reprovarCandidatura(String codigo, int id) {
		return sistema.reprovarCandidatura(codigo, id);
	}
	public int calcularTotalUsuarios() {
		return sistema.calcularTotalUsuarios();
	}
	public int calcularTotalVagas() {
		return sistema.calcularTotalVagas();
	}
	public boolean cadastrarCurriculo(Set<String> formacoes,String experiencia,Set<String> habilidades,Set<String> idiomas) {
		return sistema.cadastrarCurriculo(formacoes, experiencia, habilidades, idiomas);
	}
	public boolean adicionarExperienciaCurriculo(String experiencia) {
		return sistema.adicionarExperienciaCurriculo(experiencia);
	}
	public boolean adicionarFormacaoCurriculo(String Formacao) {
		return sistema.adicionarFormacaoCurriculo(Formacao);
	}
	public boolean adicionarHabilidadeCurriculo(String habilidade) {
		return sistema.adicionarHabilidadeCurriculo(habilidade);
	}
	public boolean adicionarIdiomaCurriculo(String idioma) {
		return sistema.adicionarIdiomaCurriculo(idioma);
	}
	public boolean editarExperienciaCurriculo(String experienciaNova) {
		return sistema.editarExperienciaCurriculo(experienciaNova);
	}
	public boolean editarFormacoesCurriculo(String formacaoAntiga,String formacaoNova) {
		return sistema.editarFormacoesCurriculo(formacaoAntiga, formacaoNova);
	}
	public boolean editarHabilidadesCurriculo(String habilidadeAntiga,String habilidadeNova) {
		return sistema.editarHabilidadesCurriculo(habilidadeAntiga, habilidadeNova);
	}
	public boolean editarIdiomasoCurriculo(String idiomaAntiga,String idiomaNovo) {
		return sistema.editarIdiomasCurriculo(idiomaAntiga, idiomaNovo);
	}
	public boolean excluirCurriculo() {
		return sistema.excluirCurriculo();
	}
}
