package com.cosme.portfolio_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data//gera os getters e setters automaticamente
@Entity//indica que é uma entidade do banco de dados
public class ResumeItem {
    @Id//indica que é a chave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//indica que o valor é gerado automaticamente
    private Long id;
    private String title; //Tecnologo em analise e desenvolvimento de sistemas
    private String description;//Formado pela Uniasselvi
    private String date;//2023-2025
}
