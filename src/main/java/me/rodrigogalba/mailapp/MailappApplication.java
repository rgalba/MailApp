package me.rodrigogalba.mailapp;

import me.rodrigogalba.mailapp.service.EmailService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MailappApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailappApplication.class, args);
	}

	@Bean
    public CommandLineRunner init(EmailService emailService) {
        return (args) -> {
            emailService.sendSimpleMessage(
                    "noreply@mailapp.com",
                    "user@email.com",
                    "User created with success!",
                    "lorem ypsum.");
        };
	}
}
