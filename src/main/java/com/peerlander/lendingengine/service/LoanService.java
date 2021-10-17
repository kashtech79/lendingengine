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

@Component
public class LoanService {

    private LoanApplicationRepository loanApplicationRepository;
    private UserRepository userRepository;
    private LoanRepository loanRepository;

    @Autowired

    public LoanService(LoanApplicationRepository loanApplicationRepository, UserRepository userRepository, LoanRepository loanRepository, LoanService loanService) {
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



}
