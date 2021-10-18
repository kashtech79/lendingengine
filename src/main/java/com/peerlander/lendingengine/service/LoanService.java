package com.peerlander.lendingengine.service;

import com.peerlander.lendingengine.domain.exception.LoadApplicationNotFoundException;
import com.peerlander.lendingengine.domain.exception.UserNotFoundException;
import com.peerlander.lendingengine.domain.model.Loan;
import com.peerlander.lendingengine.domain.model.LoanApplication;
import com.peerlander.lendingengine.domain.model.User;
import com.peerlander.lendingengine.domain.repository.LoanApplicationRepository;
import com.peerlander.lendingengine.domain.repository.LoanRepository;
import com.peerlander.lendingengine.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoanService {

    private final LoanApplicationRepository loanApplicationRepository;
    private final UserRepository userRepository;
    private final LoanRepository loanRepository;

    @Autowired

    public LoanService(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository, LoanRepository loanRepository) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.userRepository = userRepository;
        this.loanRepository = loanRepository;
    }

    public void acception(long loanApplicationId, long lenderId){
        User lender = userRepository.findById(lenderId).orElseThrow(()->new UserNotFoundException(lenderId));
        LoanApplication loanApplication = loanApplicationRepository.findById(loanApplicationId)
                .orElseThrow(()-> new LoadApplicationNotFoundException(loanApplicationId));
        loanRepository.save(new Loan(lender, loanApplication));
    }

    public List<Loan> getLoans(){
        return loanRepository.findAll();
    }


}
