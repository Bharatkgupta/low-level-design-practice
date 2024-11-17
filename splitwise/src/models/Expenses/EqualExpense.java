package models.Expenses;

import java.util.List;
import java.util.Map;

import models.Balance;
import models.Expense;

public class EqualExpense implements Expense {
    private double amount;
    private Map<String, Double> lenders;
    private List<String> borrowerIds;
    private List<Balance> balances;

    public EqualExpense() {
        amount = 0;
    };

    public void addAmount(double amount) {
        this.amount += amount;
    }

    public void addLender(String lenderId, double lendedAmount) {
        lenders.put(lenderId, lenders.getOrDefault(lenderId, 0.0));
    }

    public void addBorrower(String borrowerId) {
        borrowerIds.add(borrowerId);
    }

    public boolean createSplit() {
        double totalLended = 0;

        for (var lender : lenders.entrySet()) {
            totalLended += lender.getValue();
        }

        if (amount != totalLended) {
            return false;
        }

        // double amountPerPerson = amount / borrowerIds.size();

        // build balances here
        return true;
    }

    public List<Balance> getSplit() {
        return balances;
    }
}
