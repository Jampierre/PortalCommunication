/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.access;

import javax.faces.application.NavigationHandler;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author Jampierre
 */
public class ControleAcesso implements PhaseListener{

    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
        UserBeam usuarioSessao = (UserBeam) context.getApplication().evaluateExpressionGet(context, "#{userSessionData}", UserBeam.class);

        if (/*usuarioSessao.getFornecedor() == null && */!context.getViewRoot().getViewId().contains("login.xhtml")
                /*&& !context.getViewRoot().getViewId().contains("alterar_senha.xhtml")
                && !context.getViewRoot().getViewId().contains("esqueceu_senha.xhtml")*/) {
            NavigationHandler nh = context.getApplication().getNavigationHandler();
            nh.handleNavigation(context, null, ControleNavegacao.Redirecionar(ControleNavegacao.LOGIN));
        }
    }

    @Override
    public void beforePhase(PhaseEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
    
}
