package com.construtech.project.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Avaliacao {
    @Id
    private String cpf;
    private String sexo;
    private String idade;
    private String escolha;
    private String indicacao;



    public Avaliacao() {

    }

    public Avaliacao(String cpf, String sexo, String idade, String escolha, String indicacao) {
        this.cpf = cpf;
        this.sexo = sexo;
        this.idade = idade;
        this.escolha = escolha;
        this.indicacao = indicacao;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEscolha() {
        return escolha;
    }

    public void setEscolha(String escolha) {
        this.escolha = escolha;
    }

    public String getIndicacao() {
        return indicacao;
    }

    public void setIndicacao(String indicacao) {
        this.indicacao = indicacao;
    }

    public Object getStatusCode() {
        return null;
    }
}
