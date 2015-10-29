/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.control;

import br.com.estube.portalcommunication.model.Compra;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Jampierre
 */
public class ControleEmail {

    /**
     * 1 => Matricula OBS: não terar consulta... deverar ser implementado uma
     * chamada a uma função para envio de email de nova matricula
     */
    /**
     * Pagamento não realizado ou falta de pagamento
     *
     * @param dataInicio
     * @param dataFim
     * @return list
     */
    public static List<Compra> pesquisa1(Date dataInicio, Date dataFim) {
        String hql = "Select cp.statustransacao, cp.data, cp.valor, cr.nome as curso, al.nome as Aluno, al.email, cp.url "
                + "From compra as cp, aluno as al, curso as cr "
                + "Where cp.statustransacao = 0 "
                + "and cp.data Between :dataInicio and :dataFim "
                + "and cp.idcurso = cr.id "
                + "and cp.idaluno = al.id;";

//        Query query = session.createQuery(hql);
//        query.setParameter("dataInicio", dataInicio);
//        query.setParameter("dataFim", dataFim);
//        List<Aluno> list = query.list();
//        return list;
        return null;
    }

    /**
     * 2 => Fez o curso, fez a prova, foi aprovado e pagou pelo certificado
     * digital (status 9)
     *
     * @param dataInicio
     * @param dataFim
     * @return list
     */
    public static List<Compra> pesquisa2(Date dataInicio, Date dataFim) {
        String hql = "Select cp.id as IDCp, al.id as IDAl, cr.nome as Curso, al.nome as Aluno, al.email as Email, "
                + "al.telefone as Fone, av.data as 'Data Aprovação', av.resultado as Resultado, pg.url, pg.tipo "
                + "From compra as cp, curso as cr, aluno as al, avaliacao as av, pagamento as pg "
                + "Where cp.statustransacao = 9 "
                + "and cp.valor = 0 "
                + "and pg.data Between :dataInicio and :dataFim "
                + "and av.resultado = 'A' "
                + "and pg.tipo = 'C' "
                + "and cp.idcurso = cr.id "
                + "and cp.idaluno = al.id "
                + "and cp.id = av.idcompra "
                + "and cp.id = pg.idcompra "
                + "group by cp.id;";

//        Query query = session.createQuery(hql);
//        query.setParameter("dataInicio", dataInicio);
//        query.setParameter("dataFim", dataFim);
//        List<Aluno> list = query.list();
//        return list;
        return null;
    }

    /**
     * 3 => Fez o curso, fez a prova, clicou no link certificado, clicou no
     * pagseguro mas ainda não pagou o certificado (status 4)
     *
     * @param dataInicio
     * @param dataFim
     * @return list
     */
    public static List<Compra> pesquisa3(Date dataInicio, Date dataFim) {
        String hql = "Select cp.id as IDCp, al.id as IDAl, cr.nome as Curso, al.nome as Aluno, al.email as Email, "
                + "al.telefone as Fone, av.data as 'Data Aprovação', av.resultado as Resultado, pg.url, pg.tipo "
                + "From compra as cp, curso as cr, aluno as al, avaliacao as av, pagamento as pg "
                + "Where cp.statustransacao = 4 "
                + "and cp.valor = 0 "
                + "and pg.data Between :dataInicio and :dataFim "
                + "and av.resultado = 'A' "
                + "and pg.tipo = 'C' "
                + "and cp.idcurso = cr.id "
                + "and cp.idaluno = al.id "
                + "and cp.id = av.idcompra "
                + "and cp.id = pg.idcompra "
                + "group by cp.id;";
//        Query query = session.createQuery(hql);
//        query.setParameter("dataInicio", dataInicio);
//        query.setParameter("dataFim", dataFim);
//        List<Aluno> list = query.list();
//        return list;
        return null;
    }

    /**
     * 4 => Fez o curso, fes a prova, foi aprovado e não clucou no link
     * certificado (O registro está apenas em Avaliação)
     *
     * @param dataInicio
     * @param dataFim
     * @return list
     */
    public static List<Compra> pesquisa4(Date dataInicio, Date dataFim) {
        String hql = "Select cp.id as Compra, cr.nome as Curso, al.nome as Aluno, al.email as 'E-mail', av.data as 'Data Aprovação', "
                + "av.resultado as Resultado, cp.codigo "
                + "From compra as cp, curso as cr, aluno as al, avaliacao as av "
                + "where "
                + "cp.statustransacao = 4 "
                + "and cp.valor = 0 "
                + "and cp.codigo is null "
                + "and av.data Between :dataInicio and :dataFim "
                + "and av.resultado = 'A' "
                + "and cp.idcurso = cr.id "
                + "and cp.idaluno = al.id "
                + "and cp.id = av.idcompra "
                + "and cp.id not in "
                + "( "
                + "	Select idcompra From pagamento "
                + ") "
                + "group by cp.id "
                + "order by cp.idaluno;";
//        Query query = session.createQuery(hql);
//        query.setParameter("dataInicio", dataInicio);
//        query.setParameter("dataFim", dataFim);
//        List<Aluno> list = query.list();
//        return list;
        return null;
    }

    /**
     * 75 => Fez a matricula, ainda não iniciou os estudos(10 dias e 0 acesso)
     *
     * @param dataInicio
     * @param dataFim
     * @return list
     */
    public static List<Compra> pesquisa5(Date dataInicio, Date dataFim) {
        String hql = "Select cp.id as Compra, cp.data as Data, cr.nome as Curso, cr.valor as Valor, al.nome as Aluno, al.email as 'E-mail' "
                + "From compra as cp, curso as cr, aluno as al "
                + "where "
                + "cp.data Between :dataInicio and :dataFim "
                + "and to_days(now()) >= (to_days(cp.data) + 10) "
                + "and (cp.statustransacao = 3 or cp.statustransacao = 4) "
                + "and cp.acessoslimite = 0 "
                + "and cp.id not in "
                + "( "
                + "	select idcompra from avaliacao "
                + ") "
                + "and cp.idcurso = cr.id "
                + "and cp.idaluno = al.id;";
//        Query query = session.createQuery(hql);
//        query.setParameter("dataInicio", dataInicio);
//        query.setParameter("dataFim", dataFim);
//        List<Aluno> list = query.list();
//        return list;
        return null;
    }

    /**
     * 6P => Expirou o prazo do curso, NÃO teve acessos, (NÃO fez o curso) não
     * fez avaliação e não emitiu o certificado CURSOS PAGOS
     *
     * @param dataInicio
     * @param dataFim
     * @return list
     */
    public static List<Compra> pesquisa6P(Date dataInicio, Date dataFim) {
        String hql = "Select cp.id as Compra, cp.data as Data, cr.nome as Curso, cr.valor as Valor, al.nome as Aluno, al.email as 'E-mail' "
                + "From compra as cp, curso as cr, aluno as al "
                + "where "
                + "cp.data Between :dataInicio and :dataFim "
                + "and to_days(now()) >= (to_days(cp.data) + 30) "
                + "and (cp.statustransacao = 3 or cp.statustransacao = 4) "
                + "and cp.acessoslimite = 0 "
                + "and cp.valor <> 0 "
                + "and cp.id not in "
                + "( "
                + "	select idcompra from avaliacao "
                + ") "
                + "and cp.idcurso = cr.id "
                + "and cp.idaluno = al.id;";
//        Query query = session.createQuery(hql);
//        query.setParameter("dataInicio", dataInicio);
//        query.setParameter("dataFim", dataFim);
//        List<Aluno> list = query.list();
//        return list;
        return null;
    }

    /**
     * 6G => Expirou o prazo do curso, NÃO teve acessos, (NÃO fez o curso) não
     * fez avaliação e não emitiu o certificado CURSOS GRATUITOS
     *
     * @param dataInicio
     * @param dataFim
     * @return list
     */
    public static List<Compra> pesquisa6G(Date dataInicio, Date dataFim) {
        String hql = "Select cp.id as Compra, cp.data as Data, cr.nome as Curso, cr.valor as Valor, al.nome as Aluno, al.email as 'E-mail' "
                + "From compra as cp, curso as cr, aluno as al "
                + "where "
                + "cp.data Between :dataInicio and :dataFim "
                + "and to_days(now()) >= (to_days(cp.data) + 30) "
                + "and (cp.statustransacao = 3 or cp.statustransacao = 4) "
                + "and cp.acessoslimite = 0 "
                + "and cp.valor = 0 "
                + "and cp.id not in "
                + "( "
                + "	select idcompra from avaliacao "
                + ") "
                + "and cp.idcurso = cr.id "
                + "and cp.idaluno = al.id;";
//        Query query = session.createQuery(hql);
//        query.setParameter("dataInicio", dataInicio);
//        query.setParameter("dataFim", dataFim);
//        List<Aluno> list = query.list();
//        return list;
        return null;
    }

    /**
     * 7P => Expirou o prazo do curso, teve acessos, (fez o curso) Mas não fez a
     * avaliação e não emitiu o certificado CURSOS PAGOS
     *
     * @param dataInicio
     * @param dataFim
     * @return list
     */
    public static List<Compra> pesquisa7P(Date dataInicio, Date dataFim) {
        String hql = "Select cp.id as Compra, cp.data as Data, cr.nome as Curso, cr.valor as Valor, al.nome as Aluno, al.email as 'E-mail' "
                + "From compra as cp, curso as cr, aluno as al "
                + "where "
                + "cp.data Between :dataInicio and :dataFim "
                + "and to_days(now()) >= (to_days(cp.data) + 30) "
                + "and (cp.statustransacao = 3 or cp.statustransacao = 4) "
                + "and cp.acessoslimite > 0 "
                + "and cp.valor <> 0 "
                + "and cp.id not in "
                + "( "
                + "	select idcompra from avaliacao "
                + ") "
                + "and cp.idcurso = cr.id "
                + "and cp.idaluno = al.id;";
//        Query query = session.createQuery(hql);
//        query.setParameter("dataInicio", dataInicio);
//        query.setParameter("dataFim", dataFim);
//        List<Aluno> list = query.list();
//        return list;
        return null;
    }

    /**
     * 7G => Expirou o prazo do curso, teve acessos, (fez o curso) Mas não fez a
     * avaliação e não emitiu o certificado CURSOS GRATUITOS
     *
     * @param dataInicio
     * @param dataFim
     * @return
     */
    public static List<Compra> pesquisa7G(Date dataInicio, Date dataFim) {
        String hql = "Select cp.id as Compra, cp.data as Data, cr.nome as Curso, cr.valor as Valor, al.nome as Aluno, al.email as 'E-mail' "
                + "From compra as cp, curso as cr, aluno as al "
                + "where "
                + "cp.data Between :dataInicio and :dataFim "
                + "and to_days(now()) >= (to_days(cp.data) + 30) "
                + "and (cp.statustransacao = 3 or cp.statustransacao = 4) "
                + "and cp.acessoslimite > 0 "
                + "and cp.valor = 0 "
                + "and cp.id not in "
                + "( "
                + "	select idcompra from avaliacao "
                + ") "
                + "and cp.idcurso = cr.id "
                + "and cp.idaluno = al.id;";
//        Query query = session.createQuery(hql);
//        query.setParameter("dataInicio", dataInicio);
//        query.setParameter("dataFim", dataFim);
//        List<Aluno> list = query.list();
//        return list;
        return null;
    }

    /**
     * 8 => Ficou reprovado nas 3 avaliações
     *
     * @param dataInicio
     * @param dataFim
     * @return list
     */
    public static List<Compra> pesquisa8(Date dataInicio, Date dataFim) {
        String hql = "Select cp.id as Compra, cp.data as Data, cr.nome as Curso, cr.valor as Valor, al.nome as Aluno, al.email as 'E-mail' "
                + "From avaliacao as av, compra as cp, aluno as al, curso as cr "
                + "where "
                + "av.resultado = 'R' "
                + "and av.idcompra = cp.id "
                + "and cp.idcurso = cr.id "
                + "and cp.idaluno = al.id "
                + "cp.data Between :dataInicio and :dataFim "
                + "Group by av.idcompra "
                + "Having count(resultado) = 3;";
//        Query query = session.createQuery(hql);
//        query.setParameter("dataInicio", dataInicio);
//        query.setParameter("dataFim", dataFim);
//        List<Aluno> list = query.list();
//        return list;
        return null;
    }
}
