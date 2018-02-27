package me.rodrigogalba.mailapp.service;

import me.rodrigogalba.mailapp.messaging.UserMailMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    public JavaMailSender emailSender;

    @Deprecated
    @Override
    public void sendSimpleMessage(String sender,
            String recipient, String subject, String text) {
        String template = "This is the test email template for your email:\n%s\n";

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setSubject(subject);
        message.setText(String.format(template, sender));
        message.setFrom(sender);
        emailSender.send(message);
    }

    @Override
    public void sendMessage(UserMailMessage messageDetails) {
        String recipient = messageDetails.getRecipient();
        List<String> bccRecipients = messageDetails.getBccRecipients();
        String sender = messageDetails.getSender();
        String subject = messageDetails.getSubject();
        String text = messageDetails.getBody();

        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(recipient);
        message.setBcc(bccRecipients.toArray(new String[0]));
        message.setSubject(subject);
        message.setText(text);
        message.setFrom(sender);

        emailSender.send(message);
    }

}
