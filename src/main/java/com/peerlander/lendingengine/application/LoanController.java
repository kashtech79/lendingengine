package com.peerlander.lendingengine.application;

import com.peerlander.lendingengine.application.model.LoanRequest;
import com.peerlander.lendingengine.domain.model.LoanApplication;
import com.peerlander.lendingengine.domain.model.User;
import com.peerlander.lendingengine.domain.repository.LoanApplicationRepository;
import com.peerlander.lendingengine.domain.repository.UserRepository;
import com.peerlander.lendingengine.service.LoanApplicationAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoanController {

    private final LoanApplicationRepository loanApplicationRepository;
    private final UserRepository userRepository;
    private final LoanApplicationAdapter loanApplicationAdapter;

    public LoanController(LoanApplicationRepository loanApplicationRepository,
                          UserRepository userRepository,
                          LoanApplicationAdapter loanApplicationAdapter) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.userRepository = userRepository;
        this.loanApplicationAdapter = loanApplicationAdapter;
    }


    @PostMapping(value = "/loan/request")
    public void requestLoan(@RequestBody final LoanRequest loanRequest){
        LoanApplication loanApplication = loanApplicationAdapter.transform(loanRequest);
        loanApplicationRepository.save(loanApplicationAdapter.transform(loanRequest));

    }

    @GetMapping("/loan/requests")
        public List<LoanApplication> findAllLoanApplications(){
            return loanApplicationRepository.findAll();
        }

    @GetMapping(value = "/users")
    public List<User> findUsers(){
        return userRepository.findAll();
    }
}
