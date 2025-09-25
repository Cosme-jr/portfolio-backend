package com.cosme.portfolio_backend.repository;

import com.cosme.portfolio_backend.model.ResumeItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<ResumeItem, Long> {
}
