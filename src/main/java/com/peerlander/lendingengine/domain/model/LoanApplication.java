package com.peerlander.lendingengine.domain.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Duration;
import java.util.Objects;

@Entity
public final class LoanApplication {

    @Id
    @GeneratedValue
    private long id;
    private int amount;
    @ManyToOne
    private User borrower;
    private int repaymentTermInDays;
    private double interestRate;

    public LoanApplication(int amount, User borrower, int repaymentTermInDays, double interestRate) {
        this.amount = amount;
        this.borrower = borrower;
        this.repaymentTermInDays = repaymentTermInDays;
        this.interestRate = interestRate;
    }

    public LoanApplication() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public User getBorrower() {
        return borrower;
    }

    public int getRepaymentTermInDays() {
        return repaymentTermInDays;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanApplication that = (LoanApplication) o;
        return id == that.id && amount == that.amount && repaymentTermInDays == that.repaymentTermInDays && Double.compare(that.interestRate, interestRate) == 0 && Objects.equals(borrower, that.borrower);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, amount, borrower, repaymentTermInDays, interestRate);
    }

    @Override
    public String toString() {
        return "LoanApplication{" +
                "id=" + id +
                ", amount=" + amount +
                ", borrower=" + borrower +
                ", repaymentTermInDays=" + repaymentTermInDays +
                ", interestRate=" + interestRate +
                '}';
    }
}
