package com.liferay.portlet;


import com.liferay.mail.kernel.model.MailMessage;
import com.liferay.mail.kernel.service.MailServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;

import javax.mail.internet.InternetAddress;

public class MailUtil {
	
	private static final Log _log = LogFactoryUtil.getLog(studentPortlet.class);
	
	public static void SendMail(String fromMail, String toMail, String subject, String message) {
            
        MailMessage msg = new MailMessage();

        try {		
			msg.setFrom (new InternetAddress(fromMail));
			msg.setTo(InternetAddress.parse(toMail));
            
            msg.setSubject(subject);
			msg.setBody(message);			
            
            MailServiceUtil.sendEmail(msg);
        } 
        catch (Exception e) {
        	System.out.println(e);
  		  _log.error(e, e);  		  
        }
    }
}