package com.construtech.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = Denuncia.TABLE_NAME)
public class Denuncia {
    public static final String TABLE_NAME = "denuncia";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String nomeDenunciante;
    private String email;
    private String tipoDenuncia;
    private String descricao;   
    private String situacao;
    private String resposta;


    public Denuncia() {
    }


    public Denuncia(Long id, String nomeDenunciante, String email, String tipoDenuncia, String descricao, String situacao, String resposta) {
        this.id = id;
        this.nomeDenunciante = nomeDenunciante;
        this.email = email;
        this.tipoDenuncia = tipoDenuncia;
        this.descricao = descricao;
        this.situacao = situacao;
        this.resposta = resposta;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeDenunciante() {
        return this.nomeDenunciante;
    }

    public void setNomeDenunciante(String nomeDenunciante) {
        this.nomeDenunciante = nomeDenunciante;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoDenuncia() {
        return this.tipoDenuncia;
    }

    public void setTipoDenuncia(String tipoDenuncia) {
        this.tipoDenuncia = tipoDenuncia;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getResposta() {
        return this.resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
    
    
}
