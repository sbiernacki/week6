package pl.writech.week6.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailSenderImpl implements EmailSender {

    private final Logger logger = LoggerFactory.getLogger(getClass());


    private JavaMailSender emailSender;

    @Autowired
    public EmailSenderImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("noreply@writech.pl");
        message.setTo("admin@writech.pl");
        message.setSubject("Baza filmów zaktualizowana");
        message.setText("Dodaleś nowy produkt do listy filmów!");
        logger.info(message.toString());
        emailSender.send(message);
    }
}
