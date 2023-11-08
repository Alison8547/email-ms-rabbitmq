package com.ms.email.service;

import com.ms.email.domain.Email;
import org.springframework.transaction.annotation.Transactional;

public interface EmailService {

    @Transactional
    Email sendEmail(Email email);
}
