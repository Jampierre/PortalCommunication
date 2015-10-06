/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.control;

import br.com.estube.portalcommunication.persistence.Filtro;
import br.com.estube.portalcommunication.persistence.Persistencia;
import br.com.estube.portalcommunication.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jampierre
 */
public class ControleUsuario {

    

    public ControleUsuario() {}
    
    public static Usuario logarUsuario(String email, String senha) throws Exception{
        System.out.println("ENTROU Logar Usuario");
        Usuario usuario = buscarUsuario(email);
        if(usuario == null)
            throw new Exception("Não foi possivel encontrar o usuário com os dados informados");
        if(usuario.getAtivo() != 0)
            throw new Exception("Este usuário não está ativo");
        if(!usuario.getSenha().equals(senha))
            throw new Exception("Senha incorreta");
        return usuario;
    }
    
    private static Usuario buscarUsuario(String email) throws Exception {
        List<Filtro> filtros = new ArrayList<>();
        filtros.add(new Filtro("email", email));
        
        Persistencia persistencia = new Persistencia();
        Usuario usuario = (Usuario) persistencia.abrirSession().buscarObjeto(Usuario.class, filtros);
        persistencia.fecharSessao();
        return usuario;
    }
}
