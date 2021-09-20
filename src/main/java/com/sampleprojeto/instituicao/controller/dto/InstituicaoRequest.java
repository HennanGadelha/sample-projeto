package com.sampleprojeto.instituicao.controller.dto;

import com.sampleprojeto.instituicao.model.Instituicao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class InstituicaoRequest {

    @NotNull @NotBlank @NotEmpty
    private String nome;

    @Deprecated
    public InstituicaoRequest(){}

    public InstituicaoRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public Instituicao toModel(){
        return new Instituicao(this.nome);
    }
}
