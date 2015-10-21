/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.util;

import br.com.estube.portalcommunication.model.Aluno;
import br.com.estube.portalcommunication.model.Compra;
import br.com.estube.portalcommunication.model.Curso;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

/**
 *
 * @author Jampierre
 */
public class Email {

    HtmlEmail email;

    private final String systemEmail = "estube.teste@gmail.com";

    public Email() {
        email = new HtmlEmail();
        configure();
    }

    private void configure() {
        /**
         * Servidor SMTP da Google
         */
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setDebug(true); // Apenas para teste
        email.setAuthenticator(new DefaultAuthenticator(systemEmail, "estube32"));
        email.setSSLOnConnect(true);
    }

    /**
     * 0 =>
     * Email para novo Aluno matriculado
     *
     * @param compra
     */
    public void novaMatriculaDeCurso(Compra compra) {
        System.out.println("novaMatriculaDeCurso");
        try {
            email.setFrom(systemEmail);
            email.setSubject("Parabéns por se matricular em um novo Curso!");
            email.addTo(compra.getAluno().getEmail());

            email.setHtmlMsg("<html>\n" +
"	<head>\n" +
"		<title></title>\n" +
"		<style type=\"text/css\">\n" +
"		</style>\n" +
"	</head>\n" +
"	<body>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<span style=\"font-size:9px;\"><span style=\"color:#a9a9a9;\"><span style=\"font-family: Verdana, Helvetica, sans-serif; background-color: rgb(254, 254, 254);\">E-mail exclusivo para voc&ecirc;!</span></span></span></p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<a href=\"http://www.estube.com.br\" target=\"_blank\"><img alt=\"EsTube Logo\" src=\"http://www.estube.com.br/frontend/templates/estube/images/logoImgNome.jpg\" style=\"width: 360px; height: 120px;\" /></a></p>\n" +
"		<p>\n" +
"			Parab&eacute;ns "+ compra.getAluno().getNome() +" por se matricular no curso de "+ compra.getCurso().getNome() +". A EStube agradece pela confian&ccedil;a depositada. Esperamos que aproveite o curso e que fa&ccedil;a uso tamb&eacute;m de outros servi&ccedil;os disponibilizados pelo nosso site.</p>\n" +
"		<p>\n" +
"			<strong>Dados da sua matr&iacute;cula:</strong></p>\n" +
"		<p>\n" +
"			Nome: "+ compra.getAluno().getNome() +"</p>\n" +
"		<p>\n" +
"			Curso: "+ compra.getCurso().getNome() +"</p>\n" +
"		<p>\n" +
"			Prazo para realizar o curso: "+ compra.getCurso().getDiasAcesso() +"</p>\n" +
"		<p>\n" +
"			&nbsp;</p>\n" +
"		<p>\n" +
"			&nbsp;</p>\n" +
"		<p>\n" +
"			&nbsp;</p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			<img alt=\"\" src=\"https://ci3.googleusercontent.com/proxy/BskpQQOswEcEktlcWHTJ1GXqrB9aFVLijUYlXi-wmYLZuNmb9EXeeReH-d3DFfp9dXd7-ZKXAP0d6pmDLqyZut7X3x5SOIxKAHPOuFAkp08FDquIHn0r_kfgoizesg=s0-d-e1-ft#https://statici.icloud.com/emailimages/v4/common/footer_gradient_web.png\" style=\"width: 700px; height: 42px;\" /></p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69); text-align: center;\">\n" +
"			<a href=\"https://www.linkedin.com/company/estube\"><img alt=\"\" src=\"https://econsultancy.com/assets/redesign/mailers/linkedin-icon-4809b1d5c719d6c540f1faba52e5317f.png\" style=\"width: 35px; height: 35px;\" /></a><a href=\"https://www.facebook.com/Estube?fref=ts\" target=\"_blank\"><img alt=\"\" src=\"http://vignette3.wikia.nocookie.net/callofduty/images/3/3f/Facebook_icon.png/revision/20120119193552\" style=\"width: 30px; height: 30px; margin-top: 3px; margin-bottom: 3px;\" /></a><a href=\"https://twitter.com/estubebr\" target=\"_blank\"><img alt=\"\" src=\"http://www.myiconfinder.com/uploads/iconsets/624dc72b6deef6abddf29031c1ac7224.png\" style=\"width: 34px; height: 34px; margin-left: 1px; margin-right: 1px;\" /></a><a href=\"https://www.youtube.com/user/PortalEstube\" target=\"_blank\"><img alt=\"\" src=\"http://sixpackshortcutsbrasil.com.br/wp-content/uploads/2015/06/youtube_icon.png\" style=\"width: 30px; height: 30px; margin-top: 3px; margin-bottom: 3px;\" /></a><a href=\"http://www.estube.com.br/blog/\" target=\"_blank\"><img alt=\"\" src=\"http://www.icbi-superinvestor.com/appdata/page/super-investor-conference-2011/ICBI_BLOG_-_White.png\" style=\"width: 31px; height: 31px; margin: 2px 3px;\" /></a></p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			<b>Endere&ccedil;o:</b></p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			Rua Cabo Ailson Sim&otilde;es, n.&ordm; 222 - sala 305&nbsp;</p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			Ed. Cristo Rei - Centro - Vila Velha - ES -&nbsp;</p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			CEP 29100-302</p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<b style=\"color: rgb(69, 69, 69); font-family: Helvetica; font-size: 12px; text-align: center;\">Copyright &copy; 2015 Todos os direitos reservados.</b></p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<span style=\"font-size:10px;\"><span style=\"color: rgb(68, 68, 68); font-family: Verdana, Helvetica, sans-serif; text-align: right; background-color: rgb(254, 254, 254);\">N&atilde;o deseja receber nossos emails?&nbsp;</span><a href=\"http://chaordicmail.livrariasaraiva.com.br/lv2/optout/b69FJ7V5XGh1wTssm4UdIbM4qsJXst1WdNFjT6FzMjZEuQ3tdBxAqQ-G4qkjvPyqWLMAZC_GnhK0uQN6Uleaoukbh24ukdzAcL7MwgFiFjfBI6aAMy5DZTkyzJooHMIBiNV10MKaWqmrvQp3cfkVl1mdSRI27IjvpFttNMCeyRtuld6qmZqjFTndZrElZi1HoItDeWBcBaQEpB0jpMN3V9_zJQOYATfwBm7_9BJDMX5DQx7kGFl28mOn0rn1_1bp0wgLh0hVmblSrzz65qp2ikjlJtq6rhxtuwSMchOkPNtjpATsegNlBobhWcWh5U6jIbixMW7oZqi5aKDeyHdkKk8yS4pq81wHByaV2ZDkejg\" style=\"color: rgb(68, 68, 68); border: 0px; outline: none; font-family: Verdana, Helvetica, sans-serif; font-size: 11px; margin: 0px; padding: 0px; line-height: 1.3;\" target=\"_blank\">Descadastre-se</a><span style=\"color: rgb(68, 68, 68); font-family: Verdana, Helvetica, sans-serif; text-align: right; background-color: rgb(254, 254, 254);\">.</span></span></p>\n" +
"	</body>\n" +
"</html>");
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 1 => Pagamentos não realizados ou falta de pagamento
     */
    public void pesquisa1(Compra compra){
        System.out.println("pesquisa1");
        try {
            email.setFrom(systemEmail);
            email.setSubject("Não esqueca de efetuar o pagamento");
            email.addTo(compra.getAluno().getEmail());

            email.setHtmlMsg("<html>\n" +
"	<head>\n" +
"		<title></title>\n" +
"		<style type=\"text/css\">\n" +
"		</style>\n" +
"		<style type=\"text/css\">\n" +
"		</style>\n" +
"	</head>\n" +
"	<body>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<span style=\"font-size:9px;\"><span style=\"color:#a9a9a9;\"><span style=\"font-family: Verdana, Helvetica, sans-serif; background-color: rgb(254, 254, 254);\">E-mail exclusivo para voc&ecirc;!</span></span></span></p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<a href=\"http://www.estube.com.br\" target=\"_blank\"><img alt=\"EsTube Logo\" src=\"http://www.estube.com.br/frontend/templates/estube/images/logoImgNome.jpg\" style=\"width: 360px; height: 120px;\" /></a></p>\n" +
"		<p>\n" +
"			Ol&aacute; "+ compra.getAluno().getNome() +", gostariamos de lembra-lo do seu d&eacute;bito referente ao curso de "+ compra.getCurso().getNome() +". Para efetuar o pagamento, basta clicar no seguinte link</p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<a href=\""+ compra.getUrl() +"\" target=\"_blank\"><img alt=\"link\" src=\"http://www.planandprepare.org/couples/sg_userfiles/paypal_icon.png\" style=\"width: 200px; height: 90px;\" /></a></p>\n" +
"		<p>\n" +
"			<span style=\"font-size:10px;\">link: "+ compra.getUrl() +"</span></p>\n" +
"		<p>\n" +
"			Desde j&aacute; agradecemos. Atenciosamente EStube.</p>\n" +
"		<p>\n" +
"			&nbsp;</p>\n" +
"		<p>\n" +
"			&nbsp;</p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			<img alt=\"\" src=\"https://ci3.googleusercontent.com/proxy/BskpQQOswEcEktlcWHTJ1GXqrB9aFVLijUYlXi-wmYLZuNmb9EXeeReH-d3DFfp9dXd7-ZKXAP0d6pmDLqyZut7X3x5SOIxKAHPOuFAkp08FDquIHn0r_kfgoizesg=s0-d-e1-ft#https://statici.icloud.com/emailimages/v4/common/footer_gradient_web.png\" style=\"width: 700px; height: 42px;\" /></p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69); text-align: center;\">\n" +
"			<a href=\"https://www.linkedin.com/company/estube\"><img alt=\"\" src=\"https://econsultancy.com/assets/redesign/mailers/linkedin-icon-4809b1d5c719d6c540f1faba52e5317f.png\" style=\"width: 35px; height: 35px;\" /></a><a href=\"https://www.facebook.com/Estube?fref=ts\" target=\"_blank\"><img alt=\"\" src=\"http://vignette3.wikia.nocookie.net/callofduty/images/3/3f/Facebook_icon.png/revision/20120119193552\" style=\"width: 30px; height: 30px; margin-top: 3px; margin-bottom: 3px;\" /></a><a href=\"https://twitter.com/estubebr\" target=\"_blank\"><img alt=\"\" src=\"http://www.myiconfinder.com/uploads/iconsets/624dc72b6deef6abddf29031c1ac7224.png\" style=\"width: 34px; height: 34px; margin-left: 1px; margin-right: 1px;\" /></a><a href=\"https://www.youtube.com/user/PortalEstube\" target=\"_blank\"><img alt=\"\" src=\"http://sixpackshortcutsbrasil.com.br/wp-content/uploads/2015/06/youtube_icon.png\" style=\"width: 30px; height: 30px; margin-top: 3px; margin-bottom: 3px;\" /></a><a href=\"http://www.estube.com.br/blog/\" target=\"_blank\"><img alt=\"\" src=\"http://www.icbi-superinvestor.com/appdata/page/super-investor-conference-2011/ICBI_BLOG_-_White.png\" style=\"width: 31px; height: 31px; margin: 2px 3px;\" /></a></p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			<b>Endere&ccedil;o:</b></p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			Rua Cabo Ailson Sim&otilde;es, n.&ordm; 222 - sala 305&nbsp;</p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			Ed. Cristo Rei - Centro - Vila Velha - ES -&nbsp;</p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			CEP 29100-302</p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<b style=\"color: rgb(69, 69, 69); font-family: Helvetica; font-size: 12px; text-align: center;\">Copyright &copy; 2015 Todos os direitos reservados.</b></p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<span style=\"font-size:10px;\"><span style=\"color: rgb(68, 68, 68); font-family: Verdana, Helvetica, sans-serif; text-align: right; background-color: rgb(254, 254, 254);\">N&atilde;o deseja receber nossos emails?&nbsp;</span><a href=\"http://chaordicmail.livrariasaraiva.com.br/lv2/optout/b69FJ7V5XGh1wTssm4UdIbM4qsJXst1WdNFjT6FzMjZEuQ3tdBxAqQ-G4qkjvPyqWLMAZC_GnhK0uQN6Uleaoukbh24ukdzAcL7MwgFiFjfBI6aAMy5DZTkyzJooHMIBiNV10MKaWqmrvQp3cfkVl1mdSRI27IjvpFttNMCeyRtuld6qmZqjFTndZrElZi1HoItDeWBcBaQEpB0jpMN3V9_zJQOYATfwBm7_9BJDMX5DQx7kGFl28mOn0rn1_1bp0wgLh0hVmblSrzz65qp2ikjlJtq6rhxtuwSMchOkPNtjpATsegNlBobhWcWh5U6jIbixMW7oZqi5aKDeyHdkKk8yS4pq81wHByaV2ZDkejg\" style=\"color: rgb(68, 68, 68); border: 0px; outline: none; font-family: Verdana, Helvetica, sans-serif; font-size: 11px; margin: 0px; padding: 0px; line-height: 1.3;\" target=\"_blank\">Descadastre-se</a><span style=\"color: rgb(68, 68, 68); font-family: Verdana, Helvetica, sans-serif; text-align: right; background-color: rgb(254, 254, 254);\">.</span></span></p>\n" +
"	</body>\n" +
"</html>");
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 2 => Fez o curso, fez a prova, foi aprovado e pagou pelo certificado digital
     */
    public void pesquisa2(Compra compra){
        System.out.println("pesquisa2");
        try {
            email.setFrom(systemEmail);
            email.setSubject("Parabéns pela aprovação");
            email.addTo(compra.getAluno().getEmail());

            email.setHtmlMsg("<html>\n" +
"	<head>\n" +
"		<title></title>\n" +
"		<style type=\"text/css\">\n" +
"		</style>\n" +
"		<style type=\"text/css\">\n" +
"		</style>\n" +
"	</head>\n" +
"	<body>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<span style=\"font-size:9px;\"><span style=\"color:#a9a9a9;\"><span style=\"font-family: Verdana, Helvetica, sans-serif; background-color: rgb(254, 254, 254);\">E-mail exclusivo para voc&ecirc;!</span></span></span></p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<a href=\"http://www.estube.com.br\" target=\"_blank\"><img alt=\"EsTube Logo\" src=\"http://www.estube.com.br/frontend/templates/estube/images/logoImgNome.jpg\" style=\"width: 360px; height: 120px;\" /></a></p>\n" +
"		<p>\n" +
"			Parab&eacute;ns "+ compra.getAluno().getNome() +"! Voc&ecirc; concluiu o curso de "+ compra.getCurso().getNome() +" fornecido pelo EStube, obtendo um rendimento de "+ compra.getCurso().getPercentual() +".&nbsp;</p>\n" +
"		<p>\n" +
"			&nbsp;</p>\n" +
"		<p>\n" +
"			&nbsp;</p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			<img alt=\"\" src=\"https://ci3.googleusercontent.com/proxy/BskpQQOswEcEktlcWHTJ1GXqrB9aFVLijUYlXi-wmYLZuNmb9EXeeReH-d3DFfp9dXd7-ZKXAP0d6pmDLqyZut7X3x5SOIxKAHPOuFAkp08FDquIHn0r_kfgoizesg=s0-d-e1-ft#https://statici.icloud.com/emailimages/v4/common/footer_gradient_web.png\" style=\"width: 700px; height: 42px;\" /></p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69); text-align: center;\">\n" +
"			<a href=\"https://www.linkedin.com/company/estube\"><img alt=\"\" src=\"https://econsultancy.com/assets/redesign/mailers/linkedin-icon-4809b1d5c719d6c540f1faba52e5317f.png\" style=\"width: 35px; height: 35px;\" /></a><a href=\"https://www.facebook.com/Estube?fref=ts\" target=\"_blank\"><img alt=\"\" src=\"http://vignette3.wikia.nocookie.net/callofduty/images/3/3f/Facebook_icon.png/revision/20120119193552\" style=\"width: 30px; height: 30px; margin-top: 3px; margin-bottom: 3px;\" /></a><a href=\"https://twitter.com/estubebr\" target=\"_blank\"><img alt=\"\" src=\"http://www.myiconfinder.com/uploads/iconsets/624dc72b6deef6abddf29031c1ac7224.png\" style=\"width: 34px; height: 34px; margin-left: 1px; margin-right: 1px;\" /></a><a href=\"https://www.youtube.com/user/PortalEstube\" target=\"_blank\"><img alt=\"\" src=\"http://sixpackshortcutsbrasil.com.br/wp-content/uploads/2015/06/youtube_icon.png\" style=\"width: 30px; height: 30px; margin-top: 3px; margin-bottom: 3px;\" /></a><a href=\"http://www.estube.com.br/blog/\" target=\"_blank\"><img alt=\"\" src=\"http://www.icbi-superinvestor.com/appdata/page/super-investor-conference-2011/ICBI_BLOG_-_White.png\" style=\"width: 31px; height: 31px; margin: 2px 3px;\" /></a></p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			<b>Endere&ccedil;o:</b></p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			Rua Cabo Ailson Sim&otilde;es, n.&ordm; 222 - sala 305&nbsp;</p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			Ed. Cristo Rei - Centro - Vila Velha - ES -&nbsp;</p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			CEP 29100-302</p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<b style=\"color: rgb(69, 69, 69); font-family: Helvetica; font-size: 12px; text-align: center;\">Copyright &copy; 2015 Todos os direitos reservados.</b></p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<span style=\"font-size:10px;\"><span style=\"color: rgb(68, 68, 68); font-family: Verdana, Helvetica, sans-serif; text-align: right; background-color: rgb(254, 254, 254);\">N&atilde;o deseja receber nossos emails?&nbsp;</span><a href=\"http://chaordicmail.livrariasaraiva.com.br/lv2/optout/b69FJ7V5XGh1wTssm4UdIbM4qsJXst1WdNFjT6FzMjZEuQ3tdBxAqQ-G4qkjvPyqWLMAZC_GnhK0uQN6Uleaoukbh24ukdzAcL7MwgFiFjfBI6aAMy5DZTkyzJooHMIBiNV10MKaWqmrvQp3cfkVl1mdSRI27IjvpFttNMCeyRtuld6qmZqjFTndZrElZi1HoItDeWBcBaQEpB0jpMN3V9_zJQOYATfwBm7_9BJDMX5DQx7kGFl28mOn0rn1_1bp0wgLh0hVmblSrzz65qp2ikjlJtq6rhxtuwSMchOkPNtjpATsegNlBobhWcWh5U6jIbixMW7oZqi5aKDeyHdkKk8yS4pq81wHByaV2ZDkejg\" style=\"color: rgb(68, 68, 68); border: 0px; outline: none; font-family: Verdana, Helvetica, sans-serif; font-size: 11px; margin: 0px; padding: 0px; line-height: 1.3;\" target=\"_blank\">Descadastre-se</a><span style=\"color: rgb(68, 68, 68); font-family: Verdana, Helvetica, sans-serif; text-align: right; background-color: rgb(254, 254, 254);\">.</span></span></p>\n" +
"	</body>\n" +
"</html>");
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 3 => Fez o curso, fez a prova, clicou no link certificado, clicou no pagseguro mas ainda não pagou pelo certificado
     */
    public void pesquisa3(Compra compra){
        System.out.println("pesquisa3");
        try {
            email.setFrom(systemEmail);
            email.setSubject("Falta um passo para gerar seu certificado!");
            email.addTo(compra.getAluno().getEmail());

            email.setHtmlMsg("<html>\n" +
"	<head>\n" +
"		<title></title>\n" +
"		<style type=\"text/css\">\n" +
"		</style>\n" +
"		<style type=\"text/css\">\n" +
"		</style>\n" +
"	</head>\n" +
"	<body>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<span style=\"font-size:9px;\"><span style=\"color:#a9a9a9;\"><span style=\"font-family: Verdana, Helvetica, sans-serif; background-color: rgb(254, 254, 254);\">E-mail exclusivo para voc&ecirc;!</span></span></span></p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<a href=\"http://www.estube.com.br\" target=\"_blank\"><img alt=\"EsTube Logo\" src=\"http://www.estube.com.br/frontend/templates/estube/images/logoImgNome.jpg\" style=\"width: 360px; height: 120px;\" /></a></p>\n" +
"		<p>\n" +
"			Parab&eacute;ns "+ compra.getAluno().getNome() +" por ter concluido o curso de "+ compra.getCurso().getNome() +". Gostariamos de lembra-lo do pagamento referente ao Certificado de Conclus&atilde;o do curso de "+ compra.getCurso().getNome() +". Segue o link para o pagamento</p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<a href=\""+ compra.getUrl() +"\" target=\"_blank\"><img alt=\"link\" src=\"http://www.planandprepare.org/couples/sg_userfiles/paypal_icon.png\" style=\"width: 200px; height: 90px;\" /></a></p>\n" +
"		<p>\n" +
"			<span style=\"font-size:10px;\">link: "+ compra.getUrl() +"</span></p>\n" +
"		<p>\n" +
"			Agradecemos desde j&aacute;. Atenciosamente EStube.</p>\n" +
"		<p>\n" +
"			&nbsp;</p>\n" +
"		<p>\n" +
"			&nbsp;</p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			<img alt=\"\" src=\"https://ci3.googleusercontent.com/proxy/BskpQQOswEcEktlcWHTJ1GXqrB9aFVLijUYlXi-wmYLZuNmb9EXeeReH-d3DFfp9dXd7-ZKXAP0d6pmDLqyZut7X3x5SOIxKAHPOuFAkp08FDquIHn0r_kfgoizesg=s0-d-e1-ft#https://statici.icloud.com/emailimages/v4/common/footer_gradient_web.png\" style=\"width: 700px; height: 42px;\" /></p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69); text-align: center;\">\n" +
"			<a href=\"https://www.linkedin.com/company/estube\"><img alt=\"\" src=\"https://econsultancy.com/assets/redesign/mailers/linkedin-icon-4809b1d5c719d6c540f1faba52e5317f.png\" style=\"width: 35px; height: 35px;\" /></a><a href=\"https://www.facebook.com/Estube?fref=ts\" target=\"_blank\"><img alt=\"\" src=\"http://vignette3.wikia.nocookie.net/callofduty/images/3/3f/Facebook_icon.png/revision/20120119193552\" style=\"width: 30px; height: 30px; margin-top: 3px; margin-bottom: 3px;\" /></a><a href=\"https://twitter.com/estubebr\" target=\"_blank\"><img alt=\"\" src=\"http://www.myiconfinder.com/uploads/iconsets/624dc72b6deef6abddf29031c1ac7224.png\" style=\"width: 34px; height: 34px; margin-left: 1px; margin-right: 1px;\" /></a><a href=\"https://www.youtube.com/user/PortalEstube\" target=\"_blank\"><img alt=\"\" src=\"http://sixpackshortcutsbrasil.com.br/wp-content/uploads/2015/06/youtube_icon.png\" style=\"width: 30px; height: 30px; margin-top: 3px; margin-bottom: 3px;\" /></a><a href=\"http://www.estube.com.br/blog/\" target=\"_blank\"><img alt=\"\" src=\"http://www.icbi-superinvestor.com/appdata/page/super-investor-conference-2011/ICBI_BLOG_-_White.png\" style=\"width: 31px; height: 31px; margin: 2px 3px;\" /></a></p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			<b>Endere&ccedil;o:</b></p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			Rua Cabo Ailson Sim&otilde;es, n.&ordm; 222 - sala 305&nbsp;</p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			Ed. Cristo Rei - Centro - Vila Velha - ES -&nbsp;</p>\n" +
"		<p style=\"margin: 0px; font-size: 12px; line-height: normal; font-family: Helvetica; color: rgb(69, 69, 69);\">\n" +
"			CEP 29100-302</p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<b style=\"color: rgb(69, 69, 69); font-family: Helvetica; font-size: 12px; text-align: center;\">Copyright &copy; 2015 Todos os direitos reservados.</b></p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<span style=\"font-size:10px;\"><span style=\"color: rgb(68, 68, 68); font-family: Verdana, Helvetica, sans-serif; text-align: right; background-color: rgb(254, 254, 254);\">N&atilde;o deseja receber nossos emails?&nbsp;</span><a href=\"http://chaordicmail.livrariasaraiva.com.br/lv2/optout/b69FJ7V5XGh1wTssm4UdIbM4qsJXst1WdNFjT6FzMjZEuQ3tdBxAqQ-G4qkjvPyqWLMAZC_GnhK0uQN6Uleaoukbh24ukdzAcL7MwgFiFjfBI6aAMy5DZTkyzJooHMIBiNV10MKaWqmrvQp3cfkVl1mdSRI27IjvpFttNMCeyRtuld6qmZqjFTndZrElZi1HoItDeWBcBaQEpB0jpMN3V9_zJQOYATfwBm7_9BJDMX5DQx7kGFl28mOn0rn1_1bp0wgLh0hVmblSrzz65qp2ikjlJtq6rhxtuwSMchOkPNtjpATsegNlBobhWcWh5U6jIbixMW7oZqi5aKDeyHdkKk8yS4pq81wHByaV2ZDkejg\" style=\"color: rgb(68, 68, 68); border: 0px; outline: none; font-family: Verdana, Helvetica, sans-serif; font-size: 11px; margin: 0px; padding: 0px; line-height: 1.3;\" target=\"_blank\">Descadastre-se</a><span style=\"color: rgb(68, 68, 68); font-family: Verdana, Helvetica, sans-serif; text-align: right; background-color: rgb(254, 254, 254);\">.</span></span></p>\n" +
"	</body>\n" +
"</html>");
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 4 => Fez o curso, fez a prova, foi aprovado e não clicou no link certificado   --> O registro esta apenas em Avaliação
     */
    public void pesquisa4(Compra compra){
        try {
            email.setFrom(systemEmail);
            email.setSubject("Gere seu certificado agora!");
            email.addTo(compra.getAluno().getEmail());

            email.setHtmlMsg("");
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 5 => Fez a matrícula, ainda não iniciou os estudos (10 ou 20 dias e acesso 0) e nem fez a prova
     */
    public void pesquisa5(Compra compra){
        try {
            email.setFrom(systemEmail);
            email.setSubject("Não se esqueça de assistir as aulas do seu curso");
            email.addTo(compra.getAluno().getEmail());

            email.setHtmlMsg("");
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 6 => Expirou o prazo do curso, não teve acessos, não fez a avaliação
     */
    public void pesquisa6(Compra compra){
        try {
            email.setFrom(systemEmail);
            email.setSubject("Você tem mais 30 dias para concluir seu Curso");
            email.addTo(compra.getAluno().getEmail());

            email.setHtmlMsg("");
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 7 => Expirou o prazo do curso, teve acessos, mas não fez a avaliação
     */
    public void pesquisa7(Compra compra){
        try {
            email.setFrom(systemEmail);
            email.setSubject("Nova prazo para realizar o curso");
            email.addTo(compra.getAluno().getEmail());

            email.setHtmlMsg("");
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 8 => Ficou reprovado nas 3 avaliações
     */
    public void pesquisa8(Compra compra){
        try {
            email.setFrom(systemEmail);
            email.setSubject("Tente o curso navamente");
            email.addTo(compra.getAluno().getEmail());

            email.setHtmlMsg("");
            email.send();
        } catch (EmailException ex) {
            Logger.getLogger(Email.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public HtmlEmail getEmail() {
        return email;
    }

    public void setEmail(HtmlEmail email) {
        this.email = email;
    }
}
