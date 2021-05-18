package pl.writech.week6.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.writech.week6.service.EmailSender;

@Component
@Aspect
public class EmailAspect {

    private EmailSender emailSender;

    @Autowired
    public EmailAspect(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    @After("@annotation(SendEmail)")
    private void sendEmail(){
        emailSender.sendEmail();
    }
}
