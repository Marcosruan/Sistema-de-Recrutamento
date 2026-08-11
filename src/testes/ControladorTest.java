package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import main.controlador.Controlador;
import main.modelos.enums.TipoUsuario;


public class ControladorTest {
	
	private Controlador controlador;
	
	@Before
	public void inicializarControlador() {
		controlador = new Controlador();
	}
	
	@Test
	public void testCadastrarCandidatoComNomeVazio() {
		boolean resultado = controlador.cadastrarCandidato("", 19, "11122233345", "carlos2000@gmail.com", "desenvolvedorknex");
		
		int qtdUsuarios = controlador.calcularTotalUsuarios();
		
		assertFalse(resultado);
		assertEquals(0, qtdUsuarios);
	
	}
	
	@Test
	public void testCadastrarCandidatoComIdadeForaIntervalo() {
		boolean resultado = controlador.cadastrarCandidato("Carlos", 1, "11122233345", "carlos2000@gmail.com", "desenvolvedorknex");
		
		int qtdUsuarios = controlador.calcularTotalUsuarios();
		
		assertFalse(resultado);
		assertEquals(0, qtdUsuarios);
	}
	
	@Test
	public void testCadastrarCandidatoComCPFVazio() {
		boolean resultado = controlador.cadastrarCandidato("Carlos", 19, "", "carlos2000@gmail.com", "desenvolvedorknex");
		
		int qtdUsuarios = controlador.calcularTotalUsuarios();
		
		assertFalse(resultado);
		assertEquals(0, qtdUsuarios);
	}
	
	@Test
	public void testCadastrarCandidatoComEmailVazio() {
		boolean resultado = controlador.cadastrarCandidato("Carlos", 19, "11122233345", "", "desenvolvedorknex");
		
		int qtdUsuarios = controlador.calcularTotalUsuarios();
		
		assertFalse(resultado);
		assertEquals(0,qtdUsuarios);
	}
	
	@Test
	public void testCadastrarCandidatoComSenhaVazia() {
		boolean resultado = controlador.cadastrarCandidato("Carlos", 19, "11122233345", "carlos2000@gmail.com", "");
		
		int qtdUsuarios = controlador.calcularTotalUsuarios();
		
		assertFalse(resultado);
		assertEquals(0, qtdUsuarios);
	}
	
	@Test 
	public void testCadastrarCandidatoValido() {
		boolean resultado = controlador.cadastrarCandidato("Carlos", 19, "11122233345", "carlos2000@gmail.com", "desenvolvedorknex");
		
		int qtdUsuarios = controlador.calcularTotalUsuarios();
		
		assertTrue(resultado);
		assertEquals(1, qtdUsuarios);
	}
	
	@Test 
	public void testCadastrarRecrutadorEmpresaInvalido() {
		boolean resultado = controlador.cadastrarRecrutador("Marcos", 20, "66677788890", "Marcos2020@gmail.com", "desenvolvedorknex", "");
		
		int qtdUsuarios = controlador.calcularTotalUsuarios();
		
		assertFalse(resultado);
		assertEquals(0, qtdUsuarios);
	}
	
	@Test 
	public void testCadastrarRecrutadorValido() {
		boolean resultado = controlador.cadastrarRecrutador("Marcos", 20, "66677788890", "Marcos2020@gmail.com", "desenvolvedorknex", "KNEX");
		
		int qtdUsuarios = controlador.calcularTotalUsuarios();
		
		assertTrue(resultado);
		assertEquals(1, qtdUsuarios);
	}
	
	@Test
	public void testFalhaLoginPorEmailIncorreto() {
		controlador.cadastrarCandidato("Jonnas", 19, "55511133300", "jonnas1000@gmail.com","desenvolvedorJunior");
		
		boolean resultado = controlador.login("Marcos2020@gmail.com", "desenvolvedorJunior", TipoUsuario.CANDIDATO);
		
		assertFalse(resultado);

	}
	
	@Test
	public void testFalhaLoginPorSenhaIncorreto() {
		controlador.cadastrarCandidato("Jonnas", 19, "55511133300", "jonnas1000@gmail.com", "desenvolvedorJunior");
		
		boolean resultado = controlador.login("jonnas1000@gmail.com", "desenvolvedorknex", TipoUsuario.CANDIDATO);
		
		assertFalse(resultado);

	}
	
	@Test
	public void testLoginValido() {
		controlador.cadastrarCandidato("Jonnas", 19, "55511133300", "jonnas1000@gmail.com", "desenvolvedorJunior");
		
		boolean resultado = controlador.login("jonnas1000@gmail.com", "desenvolvedorJunior", TipoUsuario.CANDIDATO);
		
		assertTrue(resultado);

	}
	
	@Test
	public void testExibirDadosCandidato() {
		controlador.cadastrarCandidato("Jonnas", 19, "55511133300", "jonnas1000@gmail.com", "desenvolvedorJunior");
		controlador.login("jonnas1000@gmail.com", "desenvolvedorJunior", TipoUsuario.CANDIDATO);
		
		String resultado = controlador.exibirDadosDoUsuario();
		String esperado = "Nome: Jonnas | Idade: 19 | CPF: 55511133300 | Email: jonnas1000@gmail.com | Senha: desenvolvedorJunior";
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testExibirDadosRecrutador() {
		controlador.cadastrarCandidato("Jonnas", 19, "55511133300", "jonnas1000@gmail.com", "desenvolvedorJunior");
		controlador.login("jonnas1000@gmail.com", "desenvolvedorJunior", TipoUsuario.CANDIDATO);
		
		String resultado = controlador.exibirDadosDoUsuario();
		String esperado = "Nome: Jonnas | Idade: 19 | CPF: 55511133300 | Email: jonnas1000@gmail.com | Senha: desenvolvedorJunior";
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testAlterarNome() {
		controlador.cadastrarCandidato("Marcos", 20, "66677788890", "Marcos2020@gmail.com", "desenvolvedorknex");
		controlador.login("Marcos2020@gmail.com", "desenvolvedorknex", TipoUsuario.CANDIDATO);
		
		controlador.alterarNome("Ruan");
		
		String resultado = controlador.exibirDadosDoUsuario();
		String esperado = "Nome: Ruan | Idade: 20 | CPF: 66677788890 | Email: Marcos2020@gmail.com | Senha: desenvolvedorknex";
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testAlterarSenha() {
		controlador.cadastrarCandidato("Marcos", 20, "66677788890", "Marcos2020@gmail.com", "desenvolvedorknex");
		controlador.login("Marcos2020@gmail.com", "desenvolvedorknex", TipoUsuario.CANDIDATO);
		
		controlador.alterarSenha("Minecraft123");
		
		boolean resultadoLoginPosLogOut = controlador.login("Marcos2020@gmail.com", "Minecraft123", TipoUsuario.CANDIDATO);
		
		String resultado = controlador.exibirDadosDoUsuario();
		String esperado = "Nome: Marcos | Idade: 20 | CPF: 66677788890 | Email: Marcos2020@gmail.com | Senha: Minecraft123";
		
		assertTrue(resultadoLoginPosLogOut);
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testAlterarEmpresa() {
		controlador.cadastrarRecrutador("Marcos", 20, "66677788890", "Marcos2020@gmail.com", "desenvolvedorknex", "KNEX");
		controlador.login("Marcos2020@gmail.com", "desenvolvedorknex", TipoUsuario.RECRUTADOR);
		
		controlador.alterarEmpresa("Google");
		
		String resultado = controlador.exibirDadosDoUsuario();
		String esperado = "Nome: Marcos | Idade: 20 | CPF: 66677788890 | Email: Marcos2020@gmail.com | Senha: desenvolvedorknex | Empresa: Google";
		
		assertEquals(esperado, resultado);
	}
	
	@Test
	public void testCadastroInvalidoComoCandidato() {
		controlador.cadastrarCandidato("Jonnas", 19, "55511133300", "jonnas1000@gmail.com", "desenvolvedorJunior");
		controlador.login("jonnas1000@gmail.com", "desenvolvedorJunior", TipoUsuario.CANDIDATO);
		
		boolean resultadoCadastroVaga = controlador.cadastrarVaga("01", "Desenvolvedor Java Junior", "Desenvolvimento de aplicações", "Java, Spring Boot, Git", 3000.00, "São Paulo");
		int qtdVagas = controlador.calcularTotalVagas();
		
		assertFalse(resultadoCadastroVaga);
		assertEquals(0, qtdVagas);
		
	}
	
	@Test
	public void testCadastrarVagaComoRecrutador() {
		controlador.cadastrarRecrutador("Carlos", 19, "11122233345", "carlos2000@gmail.com", "desenvolvedor123", "Microsft");
		controlador.login("carlos2000@gmail.com", "desenvolvedor123", TipoUsuario.RECRUTADOR);
		
		boolean resultadoCadastroVaga = controlador.cadastrarVaga("01", "Desenvolvedor Java Junior", "Desenvolvimento de aplicações", "Java, Spring Boot, Git", 3000.00, "São Paulo");
		int qtdVagas = controlador.calcularTotalVagas();
		
		assertTrue(resultadoCadastroVaga);
		assertEquals(1, qtdVagas);
	}
	
	@Test
	public void testAlterarTituloComCodigoInvalidoComoRecrutador() {
		controlador.cadastrarRecrutador("Carlos", 19, "11122233345", "carlos2000@gmail.com", "desenvolvedor123", "Microsoft");
		controlador.login("carlos2000@gmail.com","desenvolvedor123", TipoUsuario.RECRUTADOR);
		
		controlador.cadastrarVaga("01", "Desenvolvedor Java Junior", "Desenvolvimento de aplicações", "Java, Spring Boot, Git", 3000.00, "São Paulo");
		
		boolean resultadoAlteracaoTitulo = controlador.alterarTituloVaga("03", "Desenvolvedor Java Pleno");
		
		String infoVaga = controlador.buscarVaga("01").toString();
		String infoVagaEsperado = "Codigo: 01 | Titulo: Desenvolvedor Java Junior | Descricao: Desenvolvimento de aplicações | Requisitos: Java, Spring Boot, Git | Salario: 3.000,00 | Cidade: São Paulo | Empresa: Microsoft | Estado: Aberta";
		
		assertFalse(resultadoAlteracaoTitulo);
		assertEquals(infoVagaEsperado, infoVaga);
	}
	
	@Test
	public void testAlterarTituloVagaComoRecrutador() {
		controlador.cadastrarRecrutador("Carlos", 19, "11122233345", "carlos2000@gmail.com", "desenvolvedor123", "Microsoft");
		controlador.login("carlos2000@gmail.com","desenvolvedor123", TipoUsuario.RECRUTADOR);
		
		controlador.cadastrarVaga("01", "Desenvolvedor Java Junior", "Desenvolvimento de aplicações", "Java, Spring Boot, Git", 3000.00, "São Paulo");
		
		boolean resultadoAlteracaoTitulo = controlador.alterarTituloVaga("01", "Desenvolvedor Java Pleno");
		
		String infoVaga = controlador.buscarVaga("01").toString();
		String infoVagaEsperado = "Codigo: 01 | Titulo: Desenvolvedor Java Pleno | Descricao: Desenvolvimento de aplicações | Requisitos: Java, Spring Boot, Git | Salario: 3.000,00 | Cidade: São Paulo | Empresa: Microsoft | Estado: Aberta";
		
		assertTrue(resultadoAlteracaoTitulo);
		assertEquals(infoVagaEsperado, infoVaga);
	}
	
	@Test
	public void testAlterarDescricaoVagaComoRecrutador() {
		controlador.cadastrarRecrutador("Carlos", 19, "11122233345", "carlos2000@gmail.com", "desenvolvedor123", "Microsoft");
		controlador.login("carlos2000@gmail.com","desenvolvedor123", TipoUsuario.RECRUTADOR);
		
		controlador.cadastrarVaga("01", "Desenvolvedor Java Junior", "Desenvolvimento de aplicações", "Java, Spring Boot, Git", 3000.00, "São Paulo");
		
		boolean resultadoAlteracaoDescricao = controlador.alterarDescricaoVaga("01", "Desenvolvimento e manutenção de microsserviços Java");
		
		String infoVaga = controlador.buscarVaga("01").toString();
		String infoVagaEsperado = "Codigo: 01 | Titulo: Desenvolvedor Java Junior | Descricao: Desenvolvimento e manutenção de microsserviços Java | Requisitos: Java, Spring Boot, Git | Salario: 3.000,00 | Cidade: São Paulo | Empresa: Microsoft | Estado: Aberta";
		
		assertTrue(resultadoAlteracaoDescricao);
		assertEquals(infoVagaEsperado, infoVaga);
	}
	
	@Test
	public void testAlterarRequisitosVagaComoRecrutador() {
		controlador.cadastrarRecrutador("Carlos", 19, "11122233345", "carlos2000@gmail.com", "desenvolvedor123", "Microsoft");
		controlador.login("carlos2000@gmail.com", "desenvolvedor123", TipoUsuario.RECRUTADOR);
		
		controlador.cadastrarVaga("01", "Desenvolvedor Java Junior", "Desenvolvimento de aplicações", "Java, Spring Boot, Git", 3000.00, "São Paulo");
		
		boolean resultadoAlteracaoRequisitos = controlador.alterarRequisitosVaga("01","Java, Spring Boot, Git, Banco de dados, Microserviços");
		
		String infoVaga = controlador.buscarVaga("01").toString();
		String infoVagaEsperado = "Codigo: 01 | Titulo: Desenvolvedor Java Junior | Descricao: Desenvolvimento de aplicações | Requisitos: Java, Spring Boot, Git, Banco de dados, Microserviços | Salario: 3.000,00 | Cidade: São Paulo | Empresa: Microsoft | Estado: Aberta";
		
		assertTrue(resultadoAlteracaoRequisitos);
		assertEquals(infoVagaEsperado, infoVaga);
	}
	
	@Test
	public void testAlterarSalarioVagaComoRecrutador() {
		controlador.cadastrarRecrutador("Carlos", 19, "11122233345", "carlos2000@gmail.com", "desenvolvedor123", "Microsoft");
		controlador.login("carlos2000@gmail.com","desenvolvedor123", TipoUsuario.RECRUTADOR);
		
		controlador.cadastrarVaga("01", "Desenvolvedor Java Junior", "Desenvolvimento de aplicações", "Java, Spring Boot, Git", 3000.00, "São Paulo");
		
		boolean resultadoAlteracaoSalario = controlador.alterarSalarioVaga("01",2500);
		
		String infoVaga = controlador.buscarVaga("01").toString();
		String infoVagaEsperado = "Codigo: 01 | Titulo: Desenvolvedor Java Junior | Descricao: Desenvolvimento de aplicações | Requisitos: Java, Spring Boot, Git | Salario: 2.500,00 | Cidade: São Paulo | Empresa: Microsoft | Estado: Aberta";
		
		assertTrue(resultadoAlteracaoSalario);
		assertEquals(infoVagaEsperado, infoVaga);
	}
	
	@Test
	public void testAlterarCidadeVagaComoRecrutador() {
		controlador.cadastrarRecrutador("Carlos", 19, "11122233345", "carlos2000@gmail.com", "desenvolvedor123", "Microsoft");
		controlador.login("carlos2000@gmail.com", "desenvolvedor123", TipoUsuario.RECRUTADOR);
		
		controlador.cadastrarVaga("01", "Desenvolvedor Java Junior", "Desenvolvimento de aplicações", "Java, Spring Boot, Git", 3000.00, "São Paulo");
		
		boolean resultadoAlteracaoSalario = controlador.alterarCidadeVaga("01","Patos");
		
		String infoVaga = controlador.buscarVaga("01").toString();
		String infoVagaEsperado = "Codigo: 01 | Titulo: Desenvolvedor Java Junior | Descricao: Desenvolvimento de aplicações | Requisitos: Java, Spring Boot, Git | Salario: 3.000,00 | Cidade: Patos | Empresa: Microsoft | Estado: Aberta";
		
		assertTrue(resultadoAlteracaoSalario);
		assertEquals(infoVagaEsperado, infoVaga);
	}
	
	@Test
	public void testTentarAbrirVagaJaAbertaComoRecrutador() {
		controlador.cadastrarRecrutador("Marcos", 20, "66677788890", "Marcos2020@gmail.com", "desenvolvedorknex", "KNEX");
		controlador.login("Marcos2020@gmail.com", "desenvolvedorknex", TipoUsuario.RECRUTADOR);
		
		controlador.cadastrarVaga("01", "Desenvolvedor Java Junior", "Desenvolvimento de aplicações", "Java, Spring Boot, Git", 3000.00, "São Paulo");

		boolean resultado = controlador.abrirVaga("01");
		
		assertFalse(resultado);
	}
	
	@Test
	public void testFecharVagaComoRecrutador() {
		controlador.cadastrarRecrutador("Marcos", 20, "66677788890", "Marcos2020@gmail.com", "desenvolvedorknex", "KNEX");
		controlador.login("Marcos2020@gmail.com", "desenvolvedorknex", TipoUsuario.RECRUTADOR);
		
		controlador.cadastrarVaga("01", "Desenvolvedor Java Junior", "Desenvolvimento de aplicações", "Java, Spring Boot, Git", 3000.00, "São Paulo");

		boolean resultado = controlador.fecharVaga("01");
		
		assertTrue(resultado);
	}
	
	@Test
	public void testAbrirVagaFechadaComoRecrutador() {
		controlador.cadastrarRecrutador("Marcos", 20, "66677788890", "Marcos2020@gmail.com", "desenvolvedorknex", "KNEX");
		controlador.login("Marcos2020@gmail.com", "desenvolvedorknex", TipoUsuario.RECRUTADOR);
		
		controlador.cadastrarVaga("01", "Desenvolvedor Java Junior", "Desenvolvimento de aplicações", "Java, Spring Boot, Git", 3000.00, "São Paulo");

		controlador.fecharVaga("01");
		
		boolean resultado = controlador.abrirVaga("01");
		
		assertTrue(resultado);
	}
	@Test
	public void testRegistrarCandidatura() {
		controlador.cadastrarRecrutador("Marcos", 20, "66677788890", "Marcos2020@gmail.com", "desenvolvedorknex", "KNEX");
		controlador.login("Marcos2020@gmail.com", "desenvolvedorknex", TipoUsuario.RECRUTADOR);
		
		controlador.cadastrarVaga("01", "Desenvolvedor Java Junior", "Desenvolvimento de aplicações", "Java, Spring Boot, Git", 3000.00, "São Paulo");
		
		controlador.cadastrarCandidato("Marcos", 20, "66677788890", "Marcos2020@gmail.com", "desenvolvedorknex");
		controlador.login("Marcos2020@gmail.com","desenvolvedorknex", TipoUsuario.CANDIDATO);
		
		boolean resultadoRegistroCandidatura = controlador.registrarCandidatura("01");
		
		String exibicaoCandidaturas = controlador.verCandidaturasPorVaga("01");
		String exibicaoCandidaturasEsperado = "1# [Desenvolvedor Java Junior] Candidatura de: [Candidato] Nome: Marcos | Email: Marcos2020@gmail.com\nStatus da cadidatura: Em análise";

		
		assertTrue(resultadoRegistroCandidatura);
		assertEquals(exibicaoCandidaturasEsperado,exibicaoCandidaturas);
	}
	
	@Test
	public void testCadastrarCurriculoComoCandidato() {
		controlador.cadastrarCandidato("Jonnas",19,"55511133300","jonnas1000@gmail.com","desenvolvedorJunior");
		controlador.login("jonnas1000@gmail.com","desenvolvedorJunior",TipoUsuario.CANDIDATO);
		

	    Set<String> formacoes = new HashSet<String>();
	    formacoes.add("Ciência da Computação");
	    formacoes.add("Curso de Java");

	    String experiencia = "Estágio como desenvolvedor Java por 1 ano";

	    Set<String> habilidades = new HashSet<String>();
	    habilidades.add("Java");
	    habilidades.add("Git");
	    habilidades.add("SQL");
	    habilidades.add("Spring Boot");

	    Set<String> idiomas = new HashSet<String>();
	    idiomas.add("Português");
	    idiomas.add("Inglês");

	    boolean resultado = controlador.cadastrarCurriculo(formacoes,experiencia,habilidades,idiomas);
		
	    assertTrue(resultado);
	}
	
	@Test
	public void exibirCurriculoCandidato() {
		controlador.cadastrarCandidato("Jonnas",19,"55511133300","jonnas1000@gmail.com","desenvolvedorJunior");
		controlador.login("jonnas1000@gmail.com","desenvolvedorJunior",TipoUsuario.CANDIDATO);
		

	    Set<String> formacoes = new HashSet<String>();
	    formacoes.add("Ciência da Computação");
	    formacoes.add("Curso de Java");

	    String experiencia = "Estágio como desenvolvedor Java por 1 ano";

	    Set<String> habilidades = new HashSet<String>();
	    habilidades.add("Java");
	    habilidades.add("Git");
	    habilidades.add("SQL");
	    habilidades.add("Spring Boot");

	    Set<String> idiomas = new HashSet<String>();
	    idiomas.add("Português");
	    idiomas.add("Inglês");

	    controlador.cadastrarCurriculo(formacoes,experiencia,habilidades,idiomas);
		
	    String resultado = controlador.exibirCurriculo();
	    String esperado = """
	            ==================================================
	            |                  CURRICULO                     |
	            ==================================================
	            | Nome: Jonnas
	            | Idade: 19
	            | Email: jonnas1000@gmail.com
	            ----------------------------------------
	            | Experiencia: Estágio como desenvolvedor
	            |\t\t\tJava por 1 ano
	            | Formações: Ciência da Computação
	            |\t\t\tCurso de Java
	            | Habilidades: Java, Git, Spring Boot
	            |\t\t\tSQL
	            | Idiomas: Inglês, Português
	            ========================================""";;
	    
	    assertEquals(esperado,resultado);
	}
	
	@Test
	public void testAdicionarExperienciaCurriculo() {
		controlador.cadastrarCandidato("Jonnas",19,"55511133300","jonnas1000@gmail.com","desenvolvedorJunior");
		controlador.login("jonnas1000@gmail.com","desenvolvedorJunior",TipoUsuario.CANDIDATO);
		

	    Set<String> formacoes = new HashSet<String>();
	    formacoes.add("Ciência da Computação");
	    formacoes.add("Curso de Java");

	    String experiencia = "Estágio como desenvolvedor Java por 1 ano";

	    Set<String> habilidades = new HashSet<String>();
	    habilidades.add("Java");
	    habilidades.add("Git");
	    habilidades.add("SQL");
	    habilidades.add("Spring Boot");

	    Set<String> idiomas = new HashSet<String>();
	    idiomas.add("Português");
	    idiomas.add("Inglês");

	    controlador.cadastrarCurriculo(formacoes,experiencia,habilidades,idiomas);
	    
	    String experienciaNova = "Desenvolvedor Java Junior na empresa Google " + 
	            "Período: Janeiro de 2025 a Dezembro de 2025 " +
	            "Desenvolvimento e manutenção de aplicações";
	    
	    boolean resultadoAdicao = controlador.editarExperiencia(experienciaNova);
	    
	    String infoCurriculo = controlador.exibirCurriculo();
	    String infoCurriculoEsperado = """
	            ==================================================
	            |                  CURRICULO                     |
	            ==================================================
	            | Nome: Jonnas
	            | Idade: 19
	            | Email: jonnas1000@gmail.com
	            ----------------------------------------
	            | Experiencia: Estágio como desenvolvedor
	            |			Java por 1 ano
	            |			Desenvolvedor Java Junior
	            |			na empresa Google Período:
	            |			Janeiro de 2025 a Dezembro
	            |			de 2025 Desenvolvimento e
	            |			manutenção de aplicações
	            | Formações: Ciência da Computação
	            |			Curso de Java
	            | Habilidades: Java, Git, Spring Boot
	            |			SQL
	            | Idiomas: Inglês, Português
	            ========================================""";
	    
	    assertTrue(resultadoAdicao);
	    assertEquals(infoCurriculoEsperado,infoCurriculo);
	}
	
	@Test
	public void testAdicionarFormacaoCurriculo() {
		controlador.cadastrarCandidato("Jonnas",19,"55511133300","jonnas1000@gmail.com","desenvolvedorJunior");
		controlador.login("jonnas1000@gmail.com","desenvolvedorJunior",TipoUsuario.CANDIDATO);
		

	    Set<String> formacoes = new HashSet<String>();
	    formacoes.add("Ciência da Computação");
	    formacoes.add("Curso de Java");

	    String experiencia = "Estágio como desenvolvedor Java por 1 ano";

	    Set<String> habilidades = new HashSet<String>();
	    habilidades.add("Java");
	    habilidades.add("Git");
	    habilidades.add("SQL");
	    habilidades.add("Spring Boot");

	    Set<String> idiomas = new HashSet<String>();
	    idiomas.add("Português");
	    idiomas.add("Inglês");

	    controlador.cadastrarCurriculo(formacoes,experiencia,habilidades,idiomas);
	    
	    String formacaoNova = "Curso de Banco de Dados - Udemy";
	    
	    boolean resultadoAdicao = controlador.adicionarFormacao(formacaoNova);
	    
	    String infoCurriculo = controlador.exibirCurriculo();
	    String infoCurriculoEsperado = """
	            ==================================================
	            |                  CURRICULO                     |
	            ==================================================
	            | Nome: Jonnas
	            | Idade: 19
	            | Email: jonnas1000@gmail.com
	            ----------------------------------------
	            | Experiencia: Estágio como desenvolvedor
	            |\t\t\tJava por 1 ano
	            | Formações: Curso de Banco de Dados - Udemy
	            |			Ciência da Computação
	            |			Curso de Java
	            | Habilidades: Java, Git, Spring Boot
	            |\t\t\tSQL
	            | Idiomas: Inglês, Português
	            ========================================""";;
	    
	    assertTrue(resultadoAdicao);
	    assertEquals(infoCurriculoEsperado,infoCurriculo);
	}
	
	@Test
	public void testAdicionarHabilidadeurriculo() {
		controlador.cadastrarCandidato("Jonnas",19,"55511133300","jonnas1000@gmail.com","desenvolvedorJunior");
		controlador.login("jonnas1000@gmail.com","desenvolvedorJunior",TipoUsuario.CANDIDATO);
		

	    Set<String> formacoes = new HashSet<String>();
	    formacoes.add("Ciência da Computação");
	    formacoes.add("Curso de Java");

	    String experiencia = "Estágio como desenvolvedor Java por 1 ano";

	    Set<String> habilidades = new HashSet<String>();
	    habilidades.add("Java");
	    habilidades.add("Git");
	    habilidades.add("SQL");
	    habilidades.add("Spring Boot");

	    Set<String> idiomas = new HashSet<String>();
	    idiomas.add("Português");
	    idiomas.add("Inglês");

	    controlador.cadastrarCurriculo(formacoes,experiencia,habilidades,idiomas);
	    
	    String HabilidadeNova = "Resolução de problemas";
	    
	    boolean resultadoAdicao = controlador.adicionarHabilidade(HabilidadeNova);
	    
	    String infoCurriculo = controlador.exibirCurriculo();
	    String infoCurriculoEsperado = """
	            ==================================================
	            |                  CURRICULO                     |
	            ==================================================
	            | Nome: Jonnas
	            | Idade: 19
	            | Email: jonnas1000@gmail.com
	            ----------------------------------------
	            | Experiencia: Estágio como desenvolvedor
	            |\t\t\tJava por 1 ano
	            | Formações: Ciência da Computação
	            |			Curso de Java
	            | Habilidades: Java, Git, Spring Boot
	            |\t\t\tResolução de problemas
	            |\t\t\tSQL
	            | Idiomas: Inglês, Português
	            ========================================""";;
	    
	    assertTrue(resultadoAdicao);
	    assertEquals(infoCurriculoEsperado,infoCurriculo);
	}
	
	@Test
	public void testAdicionarIdiomaCurriculo() {
		controlador.cadastrarCandidato("Jonnas",19,"55511133300","jonnas1000@gmail.com","desenvolvedorJunior");
		controlador.login("jonnas1000@gmail.com","desenvolvedorJunior",TipoUsuario.CANDIDATO);
		

	    Set<String> formacoes = new HashSet<String>();
	    formacoes.add("Ciência da Computação");
	    formacoes.add("Curso de Java");

	    String experiencia = "Estágio como desenvolvedor Java por 1 ano";

	    Set<String> habilidades = new HashSet<String>();
	    habilidades.add("Java");
	    habilidades.add("Git");
	    habilidades.add("SQL");
	    habilidades.add("Spring Boot");

	    Set<String> idiomas = new HashSet<String>();
	    idiomas.add("Português");
	    idiomas.add("Inglês");

	    controlador.cadastrarCurriculo(formacoes,experiencia,habilidades,idiomas);
	    
	    String idiomaNovo = "Francês";
	    
	    boolean resultadoAdicao = controlador.adicionarIdioma(idiomaNovo);
	    
	    String infoCurriculo = controlador.exibirCurriculo();
	    String infoCurriculoEsperado = """
	            ==================================================
	            |                  CURRICULO                     |
	            ==================================================
	            | Nome: Jonnas
	            | Idade: 19
	            | Email: jonnas1000@gmail.com
	            ----------------------------------------
	            | Experiencia: Estágio como desenvolvedor
	            |\t\t\tJava por 1 ano
	            | Formações: Ciência da Computação
	            |			Curso de Java
	            | Habilidades: Java, Git, Spring Boot
	            |\t\t\tSQL
	            | Idiomas: Inglês, Português, Francês
	            ========================================""";;
	    
	    assertTrue(resultadoAdicao);
	    assertEquals(infoCurriculoEsperado,infoCurriculo);
	}
	
	@Test
	public void testEditarFormacoesCurriculo() {
		controlador.cadastrarCandidato("Jonnas",19,"55511133300","jonnas1000@gmail.com","desenvolvedorJunior");
		controlador.login("jonnas1000@gmail.com","desenvolvedorJunior",TipoUsuario.CANDIDATO);
		

	    Set<String> formacoes = new HashSet<String>();
	    formacoes.add("Ciência da Computação");
	    formacoes.add("Curso de Java");

	    String experiencia = "Estágio como desenvolvedor Java por 1 ano";

	    Set<String> habilidades = new HashSet<String>();
	    habilidades.add("Java");
	    habilidades.add("Git");
	    habilidades.add("SQL");
	    habilidades.add("Spring Boot");

	    Set<String> idiomas = new HashSet<String>();
	    idiomas.add("Português");
	    idiomas.add("Inglês");

	    controlador.cadastrarCurriculo(formacoes,experiencia,habilidades,idiomas);
	    
	    String FormacaoAntiga = "Ciência da Computação";
	    
	    String FormacaoAtualizada = "ADS - Análise e Desenvolvimento de Sistemas";
	    
	    boolean resultadoEdicao = controlador.editarFormacao(FormacaoAntiga, FormacaoAtualizada);
	    
	    String infoCurriculo = controlador.exibirCurriculo();
	    String infoCurriculoEsperado = """
	            ==================================================
	            |                  CURRICULO                     |
	            ==================================================
	            | Nome: Jonnas
	            | Idade: 19
	            | Email: jonnas1000@gmail.com
	            ----------------------------------------
	            | Experiencia: Estágio como desenvolvedor
	            |\t\t\tJava por 1 ano
	            | Formações: ADS - Análise e Desenvolvimento de Sistemas
	            |			Curso de Java
	            | Habilidades: Java, Git, Spring Boot
	            |\t\t\tSQL
	            | Idiomas: Inglês, Português
	            ========================================""";;
	    
	    assertTrue(resultadoEdicao);
	    assertEquals(infoCurriculoEsperado,infoCurriculo);
	}
	
	@Test
	public void testEditarHabilidadesCurriculo() {
		controlador.cadastrarCandidato("Jonnas",19,"55511133300","jonnas1000@gmail.com","desenvolvedorJunior");
		controlador.login("jonnas1000@gmail.com","desenvolvedorJunior",TipoUsuario.CANDIDATO);
		

	    Set<String> formacoes = new HashSet<String>();
	    formacoes.add("Ciência da Computação");
	    formacoes.add("Curso de Java");

	    String experiencia = "Estágio como desenvolvedor Java por 1 ano";

	    Set<String> habilidades = new HashSet<String>();
	    habilidades.add("Java");
	    habilidades.add("Git");
	    habilidades.add("SQL");
	    habilidades.add("Spring Boot");

	    Set<String> idiomas = new HashSet<String>();
	    idiomas.add("Português");
	    idiomas.add("Inglês");

	    controlador.cadastrarCurriculo(formacoes,experiencia,habilidades,idiomas);
	    
	    String habilidadeAntiga = "Git";
	    
	    String habilidadeAtualizada = "Git Hub";
	    
	    boolean resultadoEdicao = controlador.editarHabilidade(habilidadeAntiga, habilidadeAtualizada);
	    
	    String infoCurriculo = controlador.exibirCurriculo();
	    String infoCurriculoEsperado = """
	            ==================================================
	            |                  CURRICULO                     |
	            ==================================================
	            | Nome: Jonnas
	            | Idade: 19
	            | Email: jonnas1000@gmail.com
	            ----------------------------------------
	            | Experiencia: Estágio como desenvolvedor
	            |\t\t\tJava por 1 ano
	            | Formações: Ciência da Computação
	            |			Curso de Java
	            | Habilidades: Java, Spring Boot, Git Hub 
	            |\t\t\tSQL
	            | Idiomas: Inglês, Português
	            ========================================""";;
	    
	    assertTrue(resultadoEdicao);
	    assertEquals(infoCurriculoEsperado,infoCurriculo);
	}
	
	@Test
	public void testEditarIdiomasCurriculo() {
		controlador.cadastrarCandidato("Jonnas",19,"55511133300","jonnas1000@gmail.com","desenvolvedorJunior");
		controlador.login("jonnas1000@gmail.com","desenvolvedorJunior",TipoUsuario.CANDIDATO);
		

	    Set<String> formacoes = new HashSet<String>();
	    formacoes.add("Ciência da Computação");
	    formacoes.add("Curso de Java");

	    String experiencia = "Estágio como desenvolvedor Java por 1 ano";

	    Set<String> habilidades = new HashSet<String>();
	    habilidades.add("Java");
	    habilidades.add("Git");
	    habilidades.add("SQL");
	    habilidades.add("Spring Boot");

	    Set<String> idiomas = new HashSet<String>();
	    idiomas.add("Português");
	    idiomas.add("Inglês");

	    controlador.cadastrarCurriculo(formacoes,experiencia,habilidades,idiomas);
	    
	    String idiomaAntigo = "Inglês";
	    
	    String idiomaNovo = "Francês";
	    
	    boolean resultadoEdicao = controlador.editarIdioma(idiomaAntigo, idiomaNovo);
	    
	    String infoCurriculo = controlador.exibirCurriculo();
	    String infoCurriculoEsperado = """
	            ==================================================
	            |                  CURRICULO                     |
	            ==================================================
	            | Nome: Jonnas
	            | Idade: 19
	            | Email: jonnas1000@gmail.com
	            ----------------------------------------
	            | Experiencia: Estágio como desenvolvedor
	            |\t\t\tJava por 1 ano
	            | Formações: Ciência da Computação
	            |			Curso de Java
	            | Habilidades: Java, Git, Spring Boot
	            |\t\t\tSQL
	            | Idiomas: Português, Francês
	            ========================================""";;
	    
	    assertTrue(resultadoEdicao);
	    assertEquals(infoCurriculoEsperado,infoCurriculo);
	}
}
