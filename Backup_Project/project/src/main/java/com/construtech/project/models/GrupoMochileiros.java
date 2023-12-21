// GrupoMochileiros.java
package com.construtech.project.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class GrupoMochileiros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeGrupo;
    private String localDestino;
    @ElementCollection
@CollectionTable(name = "grupo_mochileiros_participantes", joinColumns = @JoinColumn(name = "grupo_id"))
@Column(name = "participante")
@JoinColumn(name = "grupo_mochileiros_id") // Adicione esta linha
private List<String> Cadastro;  // Lista de nomes dos participantes


    public GrupoMochileiros() {
    }

    @ElementCollection
    @CollectionTable(name = "grupo_mochileiros_participantes", joinColumns = @JoinColumn(name = "grupo_id"))
    @Column(name = "participante")
    private List<String> participantes = new ArrayList<>();  // Inicializa a lista para evitar NullPointerException

    // Construtores, getters e setters

    public void adicionarParticipante(String nomeUsuario) {
        this.participantes.add(nomeUsuario);
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeGrupo() {
        return this.nomeGrupo;
    }

    public void setNomeGrupo(String nomeGrupo) {
        this.nomeGrupo = nomeGrupo;
    }

    public String getLocalDestino() {
        return this.localDestino;
    }

    public void setLocalDestino(String localDestino) {
        this.localDestino = localDestino;
    }

    public List<String> getParticipantes() {
        return this.participantes;
    }

    public void setParticipantes(List<String> participantes) {
        this.participantes = participantes;
    }
    
    // Outros métodos conforme necessário
}
