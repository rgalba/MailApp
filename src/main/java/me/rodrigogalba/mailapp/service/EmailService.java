package me.rodrigogalba.mailapp.service;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    void sendSimpleMessage(String from,
            String to, String subject, String text);
}
