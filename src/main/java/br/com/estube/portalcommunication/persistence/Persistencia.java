/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.persistence;

import br.com.estube.portalcommunication.util.HibernateUtil;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Jampierre
 */
public class Persistencia {
    public Session session;

    public Persistencia salvarObjeto(Object object) {
        session.save(object);
        return this;
    }

    public Persistencia atualizarObjeto(Object object) {
        session.update(object);
        return this;
    }

    public Persistencia excluirObjeto(Object object) {
        session.delete(object);
        return this;
    }

    public Object buscarObjeto(Class<?> tipo, List<Filtro> filtros) throws Exception {
        Criteria criteria = session.createCriteria(tipo);

        for (int index = 0; index < filtros.size(); index++) {
            criteria.add(Restrictions.eq(filtros.get(index).getCampo(), filtros.get(index).getValor()));
        }

        Object objectoDesconhecido = criteria.uniqueResult();
        return objectoDesconhecido;
    }

    public List<?> buscarLista(Class<?> tipo, List<Filtro> filtros) throws Exception {
        Criteria criteria = session.createCriteria(tipo);

        for (int index = 0; index < filtros.size(); index++) {
            criteria.add(Restrictions.eq(filtros.get(index).getCampo(), filtros.get(index).getValor()));
        }

        List<?> listaDesconhecida = (List<?>) criteria.list();
        Hibernate.initialize(listaDesconhecida);

        for (int contador = 0; contador < listaDesconhecida.size(); contador++) {
            Hibernate.initialize(listaDesconhecida.get(contador));
        }

        return listaDesconhecida;
    }

    public List<?> buscarLista(Class<?> tipo) throws Exception {
        List<?> listaDesconhecida = (List<?>) session.createCriteria(tipo).list();
        Hibernate.initialize(listaDesconhecida);

        for (int contador = 0; contador < listaDesconhecida.size(); contador++) {
            Hibernate.initialize(listaDesconhecida.get(contador));
        }

        return listaDesconhecida;
    }

    public Persistencia inicializarObjetoProxy(Object objeto) {
        Hibernate.initialize(objeto);
        
        return this;
    }

    public Persistencia inicializarListaObjectoProxy(List<?> listaObjetos) {
        for (Object objeto : listaObjetos) {
            Hibernate.initialize(objeto);
        }
        
        return this;
    }

    public Persistencia abrirSession() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return this;
    }

    public Persistencia fecharSessao() {
        session.close();
        return this;
    }

    public Persistencia commitarSessao() {
        try {
            session.flush();
            session.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return this;
    }
}
