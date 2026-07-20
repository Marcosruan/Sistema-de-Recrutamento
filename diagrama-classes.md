# Diagrama de classes — Sistema de vagas de emprego

Este diagrama descreve a modelagem de classes do sistema: usuários (candidatos e
recrutadores), currículos, vagas, candidaturas e o núcleo do sistema.

> Renderizado automaticamente em plataformas com suporte a Mermaid
> (GitHub, GitLab, Azure DevOps, Notion, Obsidian, VS Code com extensão Mermaid).
> Para editar/visualizar avulso, use https://mermaid.live e cole o bloco abaixo.

```mermaid
classDiagram
  class Usuario {
    <<abstract>>
    -nome String
    -email String
    -senha String
    +autenticar(email, senha) boolean
    +alterarSenha(novaSenha) void
    +getNome() String
    +setNome(nome) void
    +getEmail() String
    +setEmail(email) void
    +getSenha() String
    +setSenha(senha) void
  }
  class Candidato {
    -curriculo Curriculo
    -candidaturas ArrayList~Candidatura~
    +cadastrarCurriculo(curriculo) void
    +editarCurriculo() void
    +candidatarVaga(vaga) void
    +cancelarCandidatura(vaga) void
    +visualizarCandidaturas() void
    +getCurriculo() Curriculo
  }
  class Recrutador {
    -empresa Empresa
    -vagasCriadas ArrayList~Vaga~
    +cadastrarVaga(vaga) void
    +editarVaga(vaga) void
    +removerVaga(vaga) void
    +listarVagas() void
    +visualizarCandidatos(vaga) void
  }
  class Curriculo {
    -formacao String
    -experiencia String
    -habilidades HashSet~String~
    -cursos ArrayList~String~
    -idiomas ArrayList~String~
    +adicionarHabilidade(habilidade) void
    +removerHabilidade(habilidade) void
    +adicionarCurso(curso) void
    +removerCurso(curso) void
    +adicionarIdioma(idioma) void
    +removerIdioma(idioma) void
    +editarFormacao(formacao) void
    +editarExperiencia(experiencia) void
    +exibirCurriculo() void
  }
  class Vaga {
    -titulo String
    -descricao String
    -requisitos String
    -salario double
    -cidade String
    -aberta boolean
    -recrutador Recrutador
    +abrirVaga() void
    +fecharVaga() void
    +editarTitulo(titulo) void
    +editarDescricao(descricao) void
    +editarRequisitos(requisitos) void
    +editarSalario(salario) void
    +editarCidade(cidade) void
    +exibirDetalhes() void
  }
  class Candidatura {
    -candidato Candidato
    -vaga Vaga
    -status StatusCandidatura
    +alterarStatus(status) void
    +getStatus() StatusCandidatura
    +exibirCandidatura() void
  }
  class Empresa {
    -nome String
    -descricao String
    -cidade String
    -setor String
    +editarNome(nome) void
    +editarDescricao(descricao) void
    +editarCidade(cidade) void
    +editarSetor(setor) void
    +exibirEmpresa() void
  }
  class Sistema {
    -usuarios ArrayList~Usuario~
    -vagas ArrayList~Vaga~
    -usuarioLogado Usuario
    +cadastrarUsuario() void
    +login() boolean
    +logout() void
    +buscarUsuario(email) Usuario
    +buscarVaga(titulo) Vaga
    +listarVagas() void
    +menuPrincipal() void
    +menuCandidato() void
    +menuRecrutador() void
  }
  class Menu {
    +exibirMenuInicial() void
    +exibirMenuCandidato() void
    +exibirMenuRecrutador() void
    +lerOpcao() int
  }
  class StatusCandidatura {
    <<enumeration>>
    EM_ANALISE
    ENTREVISTA
    APROVADO
    REPROVADO
  }

  Usuario <|-- Candidato
  Usuario <|-- Recrutador
  Candidato "1" o-- "1" Curriculo
  Candidato "1" --> "*" Candidatura
  Recrutador "1" o-- "1" Empresa
  Recrutador "1" --> "*" Vaga
  Vaga "*" --> "1" Recrutador
  Candidatura --> Candidato
  Candidatura --> Vaga
  Candidatura --> StatusCandidatura
  Sistema "1" --> "*" Usuario
  Sistema "1" --> "*" Vaga
  Sistema --> Menu
```
