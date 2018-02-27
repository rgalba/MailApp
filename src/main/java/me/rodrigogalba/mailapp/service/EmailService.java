package me.rodrigogalba.mailapp.service;

import me.rodrigogalba.mailapp.messaging.UserMailMessage;
import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendSimpleMessage(String from,
            String to, String subject, String text);

    void sendMessage(UserMailMessage customMessage);
}
