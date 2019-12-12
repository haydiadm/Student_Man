/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer;

import javax.ejb.Stateless;
import com.sendgrid.*;
import java.io.IOException;
/**
 *
 
 */
@Stateless
public class mailer implements mailerLocal {

    private final static String SEND_GRID_API_KEY = "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"; 
    @Override
    public void sendEmail(String to, String from, String subject, String body) {
        Email email_from = new Email(from);
        
        Email email_to = new Email(to);
        Content content = new Content("text/plain", body);
        Mail mail = new Mail(email_from, subject, email_to, content);

        SendGrid sg = new SendGrid(SEND_GRID_API_KEY);
        Request request = new Request();
        try {
          request.setMethod(Method.POST);
          request.setEndpoint("mail/send");
          request.setBody(mail.build());
          Response response = sg.api(request);
          System.out.println(response.getStatusCode());
          System.out.println(response.getBody());
          System.out.println(response.getHeaders());
        } catch (IOException ex) {
          
        }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
