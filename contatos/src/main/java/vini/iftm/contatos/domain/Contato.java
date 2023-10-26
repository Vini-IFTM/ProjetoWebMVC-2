package vini.iftm.contatos.domain;

import lombok.Data;

@Data
public class Contato {

    private String nome;
    private String email;
    private String senha;
    private String numero;

    public Contato() {
        
    }
    public Contato(String nome, String email, String senha, String numero) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.numero = numero;
    }

    
    
}