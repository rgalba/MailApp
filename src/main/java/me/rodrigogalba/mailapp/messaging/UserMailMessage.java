package me.rodrigogalba.mailapp.messaging;

public class UserMailMessage {
    private String body;

    public UserMailMessage() {}

    public UserMailMessage(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    @Override
    public String toString() {
        return "UserMailMessage{" +
                "body='" + body + '\'' +
                '}';
    }
}