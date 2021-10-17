package com.peerlander.lendingengine.domain.repository;

import com.peerlander.lendingengine.domain.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
