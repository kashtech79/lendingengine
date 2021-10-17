package com.peerlander.lendingengine.domain.exception;

public class LoadApplicationNotFoundException extends RuntimeException{
    public LoadApplicationNotFoundException(long loanApplicationId) {
        super("Loan application with id: " + loanApplicationId + "was not found");
    }
}
