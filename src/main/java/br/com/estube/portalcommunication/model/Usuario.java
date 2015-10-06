/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Jampierre
 */
@Entity
@Table(name = "usuario")
public class Usuario extends ModelBase{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    
    @Column(name = "ativo")
    private int ativo;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "senha")
    private String senha;

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
