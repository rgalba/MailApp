package me.rodrigogalba.mailapp.service;

import me.rodrigogalba.mailapp.messaging.MailMessagingConfig;
import me.rodrigogalba.mailapp.messaging.UserMailMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MailMessageListener {

    private static final Logger log = LoggerFactory.getLogger(MailMessageListener.class);

    @Autowired
    EmailService emailService;

    @RabbitListener(queues = MailMessagingConfig.MAIL_MESSAGE_QUEUE)
    public void receiveMessage(final UserMailMessage userMailMessage) {
        log.info("Mail message to be sent: {}", userMailMessage.toString());
        emailService.sendMessage(userMailMessage);
    }
}
