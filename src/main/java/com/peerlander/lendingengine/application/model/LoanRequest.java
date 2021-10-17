package com.peerlander.lendingengine.application.model;

import javax.persistence.Entity;
import java.time.Duration;
import java.util.Objects;

public class LoanRequest {

    private int amount;
    private long borrowerId;
    private int daysToRepay;
    private double interestRate;


    public LoanRequest(int amount, long borrowerId, Duration repaymentTerm, int daysToRepay, double interestRate) {
        this.amount = amount;
        this.borrowerId = borrowerId;
        this.daysToRepay = daysToRepay;
        this.interestRate = interestRate;
    }

    public int getAmount() {
        return amount;
    }

    public long getBorrowerId() {
        return borrowerId;
    }

    public int getDaysToRepay() {
        return daysToRepay;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanRequest that = (LoanRequest) o;
        return amount == that.amount && borrowerId == that.borrowerId && daysToRepay == that.daysToRepay && Double.compare(that.interestRate, interestRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, borrowerId, daysToRepay, interestRate);
    }

    @Override
    public String toString() {
        return "LoanRequest{" +
                "amount=" + amount +
                ", borrowerId=" + borrowerId +
                ", daysToRepay=" + daysToRepay +
                ", interestRate=" + interestRate +
                '}';
    }
}
