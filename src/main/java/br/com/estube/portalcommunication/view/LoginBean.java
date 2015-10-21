/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.view;

import br.com.estube.portalcommunication.access.ControleNavegacao;
import br.com.estube.portalcommunication.control.ControleUsuario;
import br.com.estube.portalcommunication.access.UserBeam;
import br.com.estube.portalcommunication.model.Aluno;
import br.com.estube.portalcommunication.model.Compra;
import br.com.estube.portalcommunication.model.Curso;
import br.com.estube.portalcommunication.model.Usuario;
import br.com.estube.portalcommunication.util.Email;
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
    public void init() {
        usuario = new Usuario();
        userSessionData = new UserBeam();
    }

    public String login() {
        try {
            usuario = ControleUsuario.logarUsuario(usuario.getEmail(), usuario.getSenha());
            this.userSessionData.setUsuario(usuario);

            Email email = new Email();
            Compra c = new Compra();
            c.setUrl("https://pagseguro.uol.com.br/v2/checkout/payment.html?code=A9CC1959A9A9B83554590F94734F63E9");
            c.setAluno(new Aluno());
            c.getAluno().setNome("Jampierre V. Rocha");
            c.getAluno().setEmail("r.jampierre@gmail.com");
            c.setCurso(new Curso());
            c.getCurso().setNome("Diagrama de Classes com UML - Básico");
            c.getCurso().setDiasAcesso(new Long(120));
            System.out.println("Criou o Usuario");
//            email.novaMatriculaDeCurso(c);
//            email.pesquisa1(c);
//            email.pesquisa2(c);
            email.pesquisa3(c);

            return ControleNavegacao.Redirecionar(ControleNavegacao.HOME);
        } catch (Exception e) {
            e.printStackTrace();
            Menssagens.error(e.getMessage());
            return null;
        }
    }

    public UserBeam getUserSessionData() {
        return userSessionData;
    }

    public void setUserSessionData(UserBeam userSessionData) {
        this.userSessionData = userSessionData;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
