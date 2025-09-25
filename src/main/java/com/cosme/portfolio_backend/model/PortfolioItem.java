package com.cosme.portfolio_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data//gera os getters e setters automaticamente
@Entity//indica que é uma entidade do banco de dados
public class PortfolioItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//indica que o valor é gerado automaticamente
    private Long id;
    private String title; //Sistema de controle de estoque
    private String description;//Sistema desenvolvido em Java com Spring Boot e MySQL
    private String imageUrl;//https://linkdaimagem.com/imagem.jpg
    private String link;//https://linkdosite.com
}
