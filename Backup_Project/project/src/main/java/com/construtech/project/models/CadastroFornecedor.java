package com.construtech.project.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CadastroFornecedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  //  private String cidadeEvento;
  //  private String cidadePrestacaoServico;
    private String nomeEvento;
    private String descricaoEvento;
    private String dataEvento;
    private String horaEvento;
    private String localEvento;
    private String tipoEvento;
    private String nomeEmpresa;
    private String contato;
    private String email;
    private String localEmpresa;
    private String servicoOferecido;

 
    public CadastroFornecedor() {

    }

    public CadastroFornecedor(String cidadeEvento, String cidadePrestacaoServico, String nomeEvento, String descricaoEvento,
            String dataEvento, String horaEvento, String localEvento, String tipoEvento, String nomeEmpresa, String contato,
            String email, String localEmpresa, String servicoOferecido) {
  //      this.cidadeEvento = cidadeEvento;
     //   this.cidadePrestacaoServico = cidadePrestacaoServico;
        this.nomeEvento = nomeEvento;
        this.descricaoEvento = descricaoEvento;
        this.dataEvento = dataEvento;
        this.horaEvento = horaEvento;
        this.localEvento = localEvento;
        this.tipoEvento = tipoEvento;
        this.nomeEmpresa = nomeEmpresa;
        this.contato = contato;
        this.email = email;
        this.localEmpresa = localEmpresa;
        this.servicoOferecido = servicoOferecido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   // public String getCidadeEvento() {
   //     return cidadeEvento;
  //  }

 //   public void setCidadeEvento(String cidadeEvento) {
 //       this.cidadeEvento = cidadeEvento;
 //   }

  //  public String getCidadePrestacaoServico() {
 //       return cidadePrestacaoServico;
 //   }

 //   public void setCidadePrestacaoServico(String cidadePrestacaoServico) {
 //       this.cidadePrestacaoServico = cidadePrestacaoServico;
 //   }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public String getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(String horaEvento) {
        this.horaEvento = horaEvento;
    }

    public String getLocalEvento() {
        return localEvento;
    }

    public void setLocalEvento(String localEvento) {
        this.localEvento = localEvento;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocalEmpresa() {
        return localEmpresa;
    }

    public void setLocalEmpresa(String localEmpresa) {
        this.localEmpresa = localEmpresa;
    }

    public String getServicoOferecido() {
        return servicoOferecido;
    }

    public void setServicoOferecido(String servicoOferecido) {
        this.servicoOferecido = servicoOferecido;
    }
}
