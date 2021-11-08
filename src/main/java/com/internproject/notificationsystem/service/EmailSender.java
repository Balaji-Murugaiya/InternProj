package com.internproject.notificationsystem.service;

import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.jasypt.util.text.TextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.persistence.SecondaryTable;
import javax.servlet.http.HttpSession;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailSender {

    @Autowired
    Configuration configuration ;

    @Autowired
    JavaMailSender javaMailSender  ;



    public void sendEmail(String emailID ,GeoIP geoIP , String encodedSessionID ) throws MailException , MessagingException, IOException ,TemplateException
    {
        String from = "balaji17027@ece.ssn.edu.in" ;
        EmailDetails emailDetails = new EmailDetails(emailID, geoIP, encodedSessionID) ;
        MimeMessage mimeMessage = javaMailSender.createMimeMessage() ;
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage , true , "UTF-8") ;
        String text = getEmailContent(emailDetails) ;
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setTo(emailID);
        mimeMessageHelper.setSubject("Login has taken place");
        mimeMessageHelper.setText(text,true);
        javaMailSender.send(mimeMessage);

    }
    String getEmailContent(EmailDetails emailDetails) throws IOException , TemplateException
    {
        StringWriter stringWriter = new StringWriter();
        Map<String, Object> model = new HashMap<>();
        model.put("emailDetails",emailDetails) ;
        configuration.getTemplate("email.ftlh").process(model,stringWriter);
        return stringWriter.getBuffer().toString() ;
    }
}
