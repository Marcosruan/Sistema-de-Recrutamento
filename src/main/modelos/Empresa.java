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
    public boolean podeVisualizar() {
        return false;
    }

    @Override
    public boolean podeEditar() {
        return false;
    }

    @Override
    public boolean podeRemover() {
        return false;
    }
}
