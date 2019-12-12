/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mailer;

import javax.ejb.Local;

/**
 *

 */
@Local
public interface mailerLocal {

    void sendEmail(String to, String from, String subject, String body);
    
}
