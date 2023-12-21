package com.construtech.project.models; // Substitua pelo seu pacote real

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeGrupo;
    private String localDestino;

    @ElementCollection
    @CollectionTable(name = "grupo_interesses", joinColumns = @JoinColumn(name = "grupo_id"))
    @Column(name = "interesse")
    private List<String> interesses;

    private double orcamentoEstimado;
    private Date dataPartida;
    private Date dataRetorno;

    // Construtores, getters e setters

    // Exemplo de getters e setters para id, nomeGrupo, localDestino, etc.

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeGrupo() {
        return nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getLocalDestino() {
        return localDestino;
    }

    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }

    public List<String> getInteresses() {
        return interesses;
    }

    public void setInteresses(List<String> interesses) {
        this.interesses = interesses;
    }

    public double getOrcamentoEstimado() {
        return orcamentoEstimado;
    }

    public void setOrcamentoEstimado(double orcamentoEstimado) {
        this.orcamentoEstimado = orcamentoEstimado;
    }

    public Date getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(Date dataPartida) {
        this.dataPartida = dataPartida;
    }

    public Date getDataRetorno() {
        return dataRetorno;
    }

    public void setDataRetorno(Date dataRetorno) {
        this.dataRetorno = dataRetorno;
    }
}
