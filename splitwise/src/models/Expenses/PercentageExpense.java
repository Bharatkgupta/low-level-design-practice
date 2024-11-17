package models.Expenses;

import java.util.List;

import models.Balance;
import models.Expense;

public class PercentageExpense implements Expense {
    private PartsExpense partsExpense;

    public PercentageExpense() {
        partsExpense = new PartsExpense();
    }

    public void addAmount(double amount) {
        partsExpense.addAmount(amount);
    }

    public void addLender(String lenderId, double lendedAmount) {
        partsExpense.addLender(lenderId, lendedAmount);
    }

    public void addBorrower(String borrowerId, Integer percentage) {
        partsExpense.addBorrower(borrowerId, percentage);
    }

    public boolean createSplit() {
        if(partsExpense.getTotalParts() != 100) {
            return false;
        }

        return partsExpense.createSplit();
    }

    public List<Balance> getSplit() {
        return partsExpense.getSplit();
    }
}
