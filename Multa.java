package com.example.rafae_000.exerciciomulta;

/**
 * Created by rafae_000 on 27/10/2016.
 */
public class Multa {
    private String cnh;
    private String placa;
    private String proprietario;
    private String infracao;
    private String gravidade;
    private String pontos;
    private String valor;
    private String dataInfracao;

    public Multa(){}

    public Multa(String cnh,String placa, String proprietario, String infracao,String gravidade, String pontos, String valor, String dataInfracao){

    }

    public String getPontos() {
        return pontos;
    }

    public void setPontos(String pontos) {
        this.pontos = pontos;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getProprietario() {
        return proprietario;
    }

    public void setProprietario(String proprietario) {
        this.proprietario = proprietario;
    }

    public String getInfracao() {
        return infracao;
    }

    public void setInfracao(String infracao) {
        this.infracao = infracao;
    }

    public String getGravidade() {
        return gravidade;
    }

    public void setGravidade(String gravidade) {
        this.gravidade = gravidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public String getDataInfracao() {
        return dataInfracao;
    }

    public void setDataInfracao(String dataInfracao) {
        this.dataInfracao = dataInfracao;
    }
}
