package com.cosme.portfolio_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data//gera os getters e setters automaticamente
@Entity
public class ContactRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name is required")
    private String name;

    @Email(message = "Email invalid")
    @NotEmpty(message = "Email is required")
    private String email;

    @NotEmpty(message = "Message is required")
    private String message;
}
