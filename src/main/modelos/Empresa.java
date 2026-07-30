package main.modelos;


import main.modelos.interfaces.ControleAcesso;
import main.modelos.usuario.Usuario;

public class Empresa implements ControleAcesso {
    String nome;
    String descricao;
    String cidade;
    String setor;

    public Empresa(String nome, String descricao, String cidade, String setor) {
        this.nome = nome;
        this.descricao = descricao;
        this.cidade = cidade;
        this.setor = setor;
    }

    public void exibirInfoPublica(){

    }

    @Override
    public boolean podeVisualizarUsuario(Usuario usuario) {
        return false;
    }

    @Override
    public boolean podeEditar(Usuario usuario) {
        return false;
    }

    @Override
    public boolean podeRemover(Usuario usuario) {
        return false;
    }
}
