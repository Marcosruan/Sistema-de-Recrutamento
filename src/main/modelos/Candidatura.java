package main.modelos;

import java.util.Objects;
import main.modelos.enums.StatusCandidatura;
import main.modelos.usuario.Candidato;

public class Candidatura {
	
    private static int contadorId = 0;
    
    private int id;
    private StatusCandidatura status;
    private Candidato candidato;
    private Vaga vaga;

    public Candidatura(Candidato candidato, Vaga vaga) {
        contadorId++; 
        this.id = contadorId;
        this.status = StatusCandidatura.EM_ANALISE;
        this.candidato = candidato;
        this.vaga = vaga;
    }

    public int getId() {
        return id;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public Vaga getVaga() {
        return vaga;
    }

    public void setVaga(Vaga vaga) {
        this.vaga = vaga;
    }

    public StatusCandidatura alterarStatus(StatusCandidatura novoStatus) {
        this.status = novoStatus;
        return this.status;
    }
	
    public StatusCandidatura getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidatura que = (Candidatura) o;
        return Objects.equals(candidato, que.candidato) && Objects.equals(vaga, que.vaga);
    }

    @Override
    public int hashCode() {
        return Objects.hash(candidato, vaga);
    }

    @Override
    public String toString() {
        return (id) + "# [" + vaga.getTitulo() + "] Candidatura de: " + candidato.toSummaryString() + "\nStatus da cadidatura: " + status.getTexto();
    }
	
}
