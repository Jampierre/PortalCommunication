/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Jampierre
 */
@Entity
@Table(name = "compra")
public class Compra extends ModelBase{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Column(name = "acessos")
    private Long acessos;
    
    @Column(name = "data")
    private Date data;
    
    @OneToOne
    @JoinColumn(name="idaluno")
    private Aluno aluno;
    
    @OneToOne
    @JoinColumn(name="idcurso")
    private Curso curso;
    
    @Column(name = "diasAcesso")
    private Long diasAcessos;
    
    @Column(name = "statustransacao")
    private Integer statustransacao;
    
    @Column(name = "uuid")
    private String uuid;
    
    @Column(name = "url")
    private String url;
    
    @Column(name = "acessoslimite")
    private Long acessoslimite;
    
    @Column(name = "valor")
    private Double valor;
    
    @Column(name = "parcial")
    private Boolean parcial;
    
    @Column(name = "aceitartermo")
    private Long aceitartermo;
    
    @Column(name = "codigo")
    private Long codigo;
    
    @Column(name = "certificadogratuito")
    private Boolean certificadogratuito;

    public Long getAcessos() {
        return acessos;
    }

    public void setAcessos(Long acessos) {
        this.acessos = acessos;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Long getDiasAcessos() {
        return diasAcessos;
    }

    public void setDiasAcessos(Long diasAcessos) {
        this.diasAcessos = diasAcessos;
    }

    public Integer getStatustransacao() {
        return statustransacao;
    }

    public void setStatustransacao(Integer statustransacao) {
        this.statustransacao = statustransacao;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Long getAcessoslimite() {
        return acessoslimite;
    }

    public void setAcessoslimite(Long acessoslimite) {
        this.acessoslimite = acessoslimite;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Boolean getParcial() {
        return parcial;
    }

    public void setParcial(Boolean parcial) {
        this.parcial = parcial;
    }

    public Long getAceitartermo() {
        return aceitartermo;
    }

    public void setAceitartermo(Long aceitartermo) {
        this.aceitartermo = aceitartermo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Boolean getCertificadogratuito() {
        return certificadogratuito;
    }

    public void setCertificadogratuito(Boolean certificadogratuito) {
        this.certificadogratuito = certificadogratuito;
    }
}
