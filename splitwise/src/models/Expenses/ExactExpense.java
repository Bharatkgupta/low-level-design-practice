package models.Expenses;

import java.util.List;
import java.util.Map;

import models.Balance;
import models.Expense;

public class ExactExpense implements Expense {
    private double amount;
    private Map<String, Double> lenders;
    private Map<String, Double> borrowers;
    private List<Balance> balances;

    public ExactExpense() {
        amount = 0;
    };

    public void addAmount(double amount) {
        this.amount += amount;
    }

    public void addLender(String lenderId, double lendedAmount) {
        lenders.put(lenderId, lenders.getOrDefault(lenderId, 0.0));
    }

    public void addBorrower(String borrowerId, double borrowedAmount) {
        borrowers.put(borrowerId, borrowers.getOrDefault(borrowerId, 0.0));
    }

    public boolean createSplit() {
        double totalLended = 0, totalBorrowed = 0;

        for (var lender : lenders.entrySet()) {
            totalLended += lender.getValue();
        }

        for (var borrower : borrowers.entrySet()) {
            totalBorrowed += borrower.getValue();
        }

        if (amount != totalLended || amount != totalBorrowed) {
            return false;
        }

        for (var lender : lenders.entrySet()) {
            for (var borrower : borrowers.entrySet()) {
                if (lender.getKey() == borrower.getKey()) {
                    if (lender.getValue() == borrower.getValue()) {
                        lenders.remove(lender.getKey());
                        borrowers.remove(borrower.getKey());
                    } else if (lender.getValue() > borrower.getValue()) {
                        lenders.replace(lender.getKey(), lender.getValue() - borrower.getValue());
                        borrowers.remove(borrower.getKey());
                    } else {
                        borrowers.replace(borrower.getKey(), borrower.getValue() - lender.getValue());
                        lenders.remove(lender.getKey());
                    }
                }
            }
        }

        // build balances here
        return true;
    }

    public List<Balance> getSplit() {
        return balances;
    }
}
