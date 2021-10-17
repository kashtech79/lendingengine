package com.peerlander.lendingengine.domain.repository;

import com.peerlander.lendingengine.application.model.LoanRequest;
import com.peerlander.lendingengine.domain.model.LoanApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
}
