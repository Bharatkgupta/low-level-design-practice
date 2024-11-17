package models.Expenses;

import java.util.List;
import java.util.Map;

import models.Balance;
import models.Expense;

public class PartsExpense implements Expense {
    private double amount;
    private Map<String, Double> lenders;
    private Map<String, Integer> borrowers;
    private List<Balance> balances;

    public PartsExpense() {
        amount = 0;
    };

    public void addAmount(double amount) {
        this.amount += amount;
    }

    public void addLender(String lenderId, double lendedAmount) {
        lenders.put(lenderId, lenders.getOrDefault(lenderId, 0.0));
    }

    public void addBorrower(String borrowerId, Integer parts) {
        borrowers.put(borrowerId, parts);
    }

    public Integer getTotalParts() {
        Integer totalParts = 0;

        for(var borrower : borrowers.entrySet()) {
            totalParts += borrower.getValue();
        }
        return totalParts;
    }

    public boolean createSplit() {
        double totalLended = 0;

        for (var lender : lenders.entrySet()) {
            totalLended += lender.getValue();
        }

        if (amount != totalLended) {
            return false;
        }

        // Integer totalParts = getTotalParts();

        // double amountPerPart = amount / totalParts;

        // build balances here
        return true;
    }

    public List<Balance> getSplit() {
        return balances;
    }
}
