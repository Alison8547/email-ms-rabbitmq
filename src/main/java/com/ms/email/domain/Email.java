package com.ms.email.domain;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_email")
public class Email implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEmail;

    private UUID idUser;

    private String emailFrom;

    private String emailTo;

    private String subject;

    private String text;

    private LocalDateTime sendDataEmail;

    private StatusEmail statusEmail;
}
