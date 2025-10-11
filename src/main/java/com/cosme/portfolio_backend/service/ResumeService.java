package com.cosme.portfolio_backend.service;

import com.cosme.portfolio_backend.model.ResumeItem;
import com.cosme.portfolio_backend.repository.ResumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeService {

    @Autowired
    private ResumeRepository resumeRepository;

    public List<ResumeItem> getAllResumeItems() {
        return resumeRepository.findAll(); //Recupera todos os itens do currículo do banco de dados
    }
    public  ResumeItem addResumeItem(ResumeItem item) {
        return resumeRepository.save(item); //Adiciona um novo item ao currículo no banco de dados
    }
}
