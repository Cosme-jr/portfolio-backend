package com.cosme.portfolio_backend.repository;

import com.cosme.portfolio_backend.model.PortfolioItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PortfolioRepository extends JpaRepository<PortfolioItem, Long> {
}
