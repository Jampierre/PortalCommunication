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
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Jampierre
 */
@ManagedBean(name = "pesquisaCompraBean")
@ViewScoped
//@RequestScoped
public class PesquisaCompraBean implements Serializable{
    private List<Compra> compras;
    private Compra compraSelecionada;
    private List<Compra>filtroCompras;
    
    private BarChartModel statusTransacao;
    
//    @ManagedProperty("#{logDao}")
//    private LogCompraDAO dao;
//    private ControleCompra controle = new ControleCompra();
    
    @PostConstruct
    public void init(){
        compras = new ArrayList<>();
        compras = ControleCompra.logTest5();
        createAnimatedModels();
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

    public Compra getCompraSelecionada() {
        return compraSelecionada;
    }

    public void setCompraSelecionada(Compra compraSelecionada) {
        this.compraSelecionada = compraSelecionada;
    }
    
    public List<Integer> getStatus(){
        Integer[] status;
        status = new Integer[10];
        for(int i = 0; i < 10; i++)
            status[i] = i;
        return Arrays.asList(status);
    }

    public BarChartModel getStatusTransacao() {
        return statusTransacao;
    }

    public void setStatusTransacao(BarChartModel statusTransacao) {
        this.statusTransacao = statusTransacao;
    }

    private void createAnimatedModels() {
        statusTransacao = initBarModel();
        statusTransacao.setTitle("Status de Transação");
        statusTransacao.setAnimate(true);
        statusTransacao.setLegendPosition("ne");
    }
    
    private BarChartModel initBarModel(){
        BarChartModel model = new BarChartModel();
        
        ChartSeries status0 = new ChartSeries();
        status0.setLabel("0");
        
        ChartSeries status1 = new ChartSeries();
        status1.setLabel("1");
        
        ChartSeries status2 = new ChartSeries();
        status2.setLabel("2");
        
        ChartSeries status3 = new ChartSeries();
        status3.setLabel("3");
        
        ChartSeries status4 = new ChartSeries();
        status4.setLabel("4");
        
        ChartSeries status5 = new ChartSeries();
        status5.setLabel("5");
        
        ChartSeries status6 = new ChartSeries();
        status6.setLabel("6");
        
        ChartSeries status7 = new ChartSeries();
        status7.setLabel("7");
        
        ChartSeries status8 = new ChartSeries();
        status8.setLabel("8");
        
        ChartSeries status9 = new ChartSeries();
        status9.setLabel("9");
        
        return model;
    }
}
