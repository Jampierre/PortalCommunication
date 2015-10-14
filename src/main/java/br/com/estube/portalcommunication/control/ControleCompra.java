/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.control;

import br.com.estube.portalcommunication.model.Compra;
import br.com.estube.portalcommunication.persistence.Persistencia;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jampierre
 */
public class ControleCompra {

    public static List<Compra> logTest5() {
        List<Compra> compras = new ArrayList<>();
        Persistencia presistencia = new Persistencia();
        
        try {
            compras = (List<Compra>) presistencia.abrirSession().buscarLista(Compra.class);
        } catch (Exception ex) {
            Logger.getLogger(ControleCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
        presistencia.fecharSessao();
        return compras;
    }
}
