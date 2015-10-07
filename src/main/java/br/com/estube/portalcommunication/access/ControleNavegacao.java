/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.access;

/**
 *
 * @author Jampierre
 */
public class ControleNavegacao {
    public static final String HOME = "home";
    public static final String LOGIN = "login";
//    public static final String MANUTENCAO_PRODUTO = "manutencao_produto";

    private ControleNavegacao() {
    }

    public static String Redirecionar(String pagina) {
        return pagina + "?faces-redirect=true";
    }
}
