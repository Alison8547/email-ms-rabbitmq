package com.ms.email.service;

import com.ms.email.domain.Email;
import com.ms.email.enums.StatusEmail;
import com.ms.email.repository.EmailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final EmailRepository emailRepository;
    private final JavaMailSender mailSender;

    @Value(value = "${spring.mail.username}")
    private String emailFrom;


    @Override
    public Email sendEmail(Email email) {
        email.setSendDataEmail(LocalDateTime.now());
        email.setEmailFrom(emailFrom);

        try {


            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(email.getEmailTo());
            message.setSubject(email.getSubject());
            message.setText(email.getText());
            mailSender.send(message);

            email.setStatusEmail(StatusEmail.SEND);

        } catch (MailException e) {
            email.setStatusEmail(StatusEmail.ERROR);

        } finally {
            return emailRepository.save(email);
        }


    }
}
