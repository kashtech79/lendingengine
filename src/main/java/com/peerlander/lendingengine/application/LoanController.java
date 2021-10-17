package com.peerlander.lendingengine.application;

import com.peerlander.lendingengine.application.model.LoanRequest;
import com.peerlander.lendingengine.domain.model.LoanApplication;
import com.peerlander.lendingengine.domain.model.User;
import com.peerlander.lendingengine.domain.repository.LoanApplicationRepository;
import com.peerlander.lendingengine.domain.repository.UserRepository;
import com.peerlander.lendingengine.service.LoanApplicationAdapter;
import com.peerlander.lendingengine.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoanController {

    private final LoanApplicationRepository loanApplicationRepository;
    private final UserRepository userRepository;
    private final LoanApplicationAdapter loanApplicationAdapter;
    private final LoanService loanService;

    public LoanController(LoanApplicationRepository loanApplicationRepository,
                          UserRepository userRepository,
                          LoanApplicationAdapter loanApplicationAdapter, LoanService loanService) {
        this.loanApplicationRepository = loanApplicationRepository;
        this.userRepository = userRepository;
        this.loanApplicationAdapter = loanApplicationAdapter;
        this.loanService = loanService;
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

    @PostMapping(value = "/loan/accept/{lenderId}/{loanApplicationId}")
    public void acceptLoan(@PathVariable String lenderId,
                           @PathVariable String loanApplicationId){
        loanService.acception(Long.parseLong(loanApplicationId), Long.parseLong(lenderId));
    }
}
