/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.view;

import br.com.estube.portalcommunication.control.ControleUsuario;
import br.com.estube.portalcommunication.access.UserBeam;
import br.com.estube.portalcommunication.model.Usuario;
import br.com.estube.portalcommunication.util.Menssagens;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

/**
 *
 * @author Jampierre
 */
@ManagedBean(name = "loginBean")
public class LoginBean {
    @ManagedProperty(value = "#{userSessionData}")
    private UserBeam userSessionData;
//    private String email;
//    private String senha;
    
    private Usuario usuario;
    
    @PostConstruct
    public void init(){
        usuario = new Usuario();
        userSessionData = new UserBeam();
    }
    
    public String login(){
        try{
            usuario = ControleUsuario.logarUsuario(usuario.getEmail(), usuario.getSenha());
            this.userSessionData.setUsuario(usuario);
//            Menssagens.fatal();
            return "/home.xhtml";
//            return ControleNavegacao.Redirecionar(ControleNavegacao.HOME);
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public UserBeam getUserSessionData() {
        return userSessionData;
    }

    public void setUserSessionData(UserBeam userSessionData) {
        this.userSessionData = userSessionData;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getSenha() {
//        return senha;
//    }
//
//    public void setSenha(String senha) {
//        this.senha = senha;
//    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
}
