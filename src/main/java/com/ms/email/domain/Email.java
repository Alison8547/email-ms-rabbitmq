package com.ms.email.domain;

import com.ms.email.enums.StatusEmail;
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

    @Column(name = "id_user")
    private UUID idUser;

    @Column(name = "email_from")
    private String emailFrom;

    @Column(name = "email_to")
    private String emailTo;

    @Column(name = "subject")
    private String subject;

    @Column(columnDefinition = "TEXT", name = "id_user")
    private String text;

    @Column(name = "send_data_email")
    private LocalDateTime sendDataEmail;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "status_email")
    private StatusEmail statusEmail;
}
