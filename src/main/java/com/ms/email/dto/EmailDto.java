package com.ms.email.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class EmailDto {

    private UUID idUser;
    private String emailTo;
    private String subject;
    private String text;
}
