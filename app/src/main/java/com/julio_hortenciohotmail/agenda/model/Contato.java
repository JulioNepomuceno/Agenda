package com.julio_hortenciohotmail.agenda.model;

import java.io.Serializable;

/**
 * Created by julio on 06/12/17.
 */

public class Contato  implements Serializable
{
    private Long id;
    private String nome;
    private String telefone;
    private String celular;
    private String email;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }


    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Nome: " +getNome() +"\n" +"Telefone: "+ getTelefone()+"\n" + "Celular: "+getCelular() + "\n" +"Email: "+ getEmail();

    }


}
