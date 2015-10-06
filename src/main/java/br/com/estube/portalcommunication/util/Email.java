/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.util;

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

    public Email() {
        email = new HtmlEmail();
//        email = new SimpleEmail();
        configure();
    }
    
    private void configure(){
        /**
         * Servidor SMTP da Google
         */
        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setDebug(true); // Apenas para teste
        email.setAuthenticator(new DefaultAuthenticator("mysupplier.teste@gmail.com", "mysupplier"));
        email.setSSLOnConnect(true);
    }
    
    /**
     * @param from
     * @param subject
     * @param msg
     * @param to
     * @param name
     */
    public void enviarEmailUtil(String from, String subject, String msg, String to, String name){
        try {
            
            email.setFrom(from);
            email.setSubject(subject);
//            email.setMsg(msg + " ");
            email.addTo(to);
            email.addReplyTo("mysupplier.teste@gmail.com");
            
//            URL url = new URL("http://www.apache.org/images/asf_logo_wide.gif");
//        String cid = email.embed(url, "Apache logo");

        // set the html message
//        email.setHtmlMsg("<html>The apache logo - <img src=\"cid:"+cid+"\"></html>");
            
            email.setHtmlMsg("<html>\n" +
"	<head>\n" +
"		<title></title>\n" +
"		<style type=\"text/css\">\n" +
"		</style>\n" +
"		<style type=\"text/css\">\n" +
"		</style>\n" +
"		<style type=\"text/css\">\n" +
"		</style>\n" +
"		<style type=\"text/css\">\n" +
"		</style>\n" +
"		<style type=\"text/css\">\n" +
"		</style>\n" +
"	</head>\n" +
"	<body>\n" +
"		<h3>\n" +
"			Prezado "+ name +" ,</h3>\n" +
"		<p>\n" +
"			Segue o link para altere&ccedil;&atilde;o de senha do email: "+ to +".</p>\n" +
"		<p style=\"text-align: center;\">\n" +
"			<a href=\""+msg+"\" target=\"_parent\"><img alt=\"Link\" src=\"http://deputadomarciomarinho.com.br/site/wp-content/uploads/2013/09/botao_entrar.png\" style=\"width: 150px; height: 90px;\" /></a></p>\n" +
"		<p style=\"color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 12.8px; line-height: normal; widows: 1; background-color: rgb(255, 255, 255); text-align: center;\">\n" +
"			<span style=\"font-family: Arial; font-size: small; text-align: -webkit-center;\">Essa &eacute; uma mensagem autom&aacute;tica. Por favor, n&atilde;o responda a esse e-mail.</span></p>\n" +
"		<p style=\"color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 12.8px; line-height: normal; widows: 1; background-color: rgb(255, 255, 255); text-align: center;\">\n" +
"			<span style=\"font-family: Arial; font-size: small;\">&copy; 2015 My Supplier, Todos direitos reservados.</span></p>\n" +
"		<p style=\"color: rgb(34, 34, 34); font-family: arial, sans-serif; font-size: 12.8px; line-height: normal; widows: 1; background-color: rgb(255, 255, 255);\">\n" +
"			&nbsp;</p>\n" +
"	</body>\n" +
"</html>");
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
