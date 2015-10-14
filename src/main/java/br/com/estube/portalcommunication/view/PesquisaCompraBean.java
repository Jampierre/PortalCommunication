/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.view;

import br.com.estube.portalcommunication.control.ControleCompra;
import br.com.estube.portalcommunication.model.Compra;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Jampierre
 */
@ManagedBean(name = "pesquisaCompraBean")
@ViewScoped
//@RequestScoped
public class PesquisaCompraBean implements Serializable{
    private List<Compra> compras;
    private Compra aux;
    private Compra compraSelecionada;
    private List<Compra>filtroCompras;
    
//    @ManagedProperty("#{logDao}")
//    private LogCompraDAO dao;
//    private ControleCompra controle = new ControleCompra();
    
    @PostConstruct
    public void init(){
        compras = new ArrayList<>();
        aux = new Compra();
        compras = ControleCompra.logTest5();
    }
    
    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public List<Compra> getFiltroCompras() {
        return filtroCompras;
    }

    public void setFiltroCompras(List<Compra> filtroCompras) {
        this.filtroCompras = filtroCompras;
    }

    public Compra getAux() {
        return aux;
    }

    public void setAux(Compra aux) {
        this.aux = aux;
    }
    
    public Compra getCompraSelecionada() {
        return compraSelecionada;
    }

    public void setCompraSelecionada(Compra compraSelecionada) {
        System.out.println("ENTROU SET");
        this.compraSelecionada = compraSelecionada;
    }
}
