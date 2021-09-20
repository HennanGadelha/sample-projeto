package com.sampleprojeto.instituicao.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Instituicao {

    @Id
    private String id;
    private String nome;

    @Deprecated
    public Instituicao(){}

    public Instituicao(String nome) {
        this.id = UUID.randomUUID().toString();
        this.nome = nome;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
