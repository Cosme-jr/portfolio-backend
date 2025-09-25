package com.cosme.portfolio_backend.repository;

import com.cosme.portfolio_backend.model.ContactRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactRequest, Long> {

}
