package com.doodle.backend.domain;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
@Setter
@Entity
@Table(name="message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="senderName")
    private String senderName;

    @Column(name="message")
    private String message;

    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private Date timestamp;

    private Status status;

    public Message(String senderName, String message, Status status) {
        this.senderName = senderName;
        this.message = message;
        this.status = status;
    }
}
