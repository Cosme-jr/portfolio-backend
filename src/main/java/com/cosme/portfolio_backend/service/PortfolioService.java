package com.cosme.portfolio_backend.service;

import com.cosme.portfolio_backend.model.PortfolioItem;
import com.cosme.portfolio_backend.repository.PortfolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PortfolioService {
    @Autowired
    private PortfolioRepository portfolioRepository;

    public List<PortfolioItem> getAllPortfolioItems() {
        return portfolioRepository.findAll(); //Recupera todos os itens do portfólio do banco de dados
    }
    public PortfolioItem addPortfolioItem(PortfolioItem item) {
        return portfolioRepository.save(item); //Adiciona um novo item ao portfólio no banco de dados
    }
}
