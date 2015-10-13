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
@Table(name = "curso")
public class Curso extends ModelBase{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Column(name = "acessos")
    private Long acessos;
    
    @Column(name = "ativo")
    private int ativo;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "percentual")
    private float percentual;
    
    @Column(name = "valor")
    private Double valor;
    
    @Column(name = "diasAcesso")
    private Long diasAcesso;
    
    @Column(name = "cargahoraria")
    private Long cargahoraria;
    
    @Column(name = "certificadogratuito")
    private int certificadogratuito;

    public Long getAcessos() {
        return acessos;
    }

    public void setAcessos(Long acessos) {
        this.acessos = acessos;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPercentual() {
        return percentual;
    }

    public void setPercentual(float percentual) {
        this.percentual = percentual;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Long getDiasAcesso() {
        return diasAcesso;
    }

    public void setDiasAcesso(Long diasAcesso) {
        this.diasAcesso = diasAcesso;
    }

    public Long getCargahoraria() {
        return cargahoraria;
    }

    public void setCargahoraria(Long cargahoraria) {
        this.cargahoraria = cargahoraria;
    }

    public int getCertificadogratuito() {
        return certificadogratuito;
    }

    public void setCertificadogratuito(int certificadogratuito) {
        this.certificadogratuito = certificadogratuito;
    }
}
