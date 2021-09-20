package com.sampleprojeto.config.validacao;

public class ErrosRequest {

    private String campo;
    private String erro;

    public ErrosRequest(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }
}
