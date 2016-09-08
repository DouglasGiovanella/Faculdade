package com.example.dougl.appbook;

/**
 * Created by dougl on 02/09/2016.
 */
public class Usuario {

    private String nome, email, senha, pergunta, resposta;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }


    public String getDados(){
        String delimitador = "&";
        return nome+delimitador+senha+delimitador+email+delimitador+pergunta+delimitador
                +resposta;
    }

}
