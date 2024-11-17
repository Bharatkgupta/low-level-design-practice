package services;

import java.util.List;
import java.util.ArrayList;

import models.Expense;

public class ExpenseStore {
    private static ExpenseStore store;
    private List<Expense> expenses;
    private ExpenseStore() {
        expenses = new ArrayList<>();
    };

    public static ExpenseStore getExpenseStore() {
        if(store == null) {
            synchronized(ExpenseStore.class) {
                if (store == null) {
                    store = new ExpenseStore();
                }
            } 
        }
        return store;
    }

    public boolean addExpense(Expense expense) {
        if(!expense.createSplit()) {
           return false; 
        }
        
        SplitService service = SplitService.getSplitService();
        service.UpdateSplit(expense);
        
        expenses.add(expense);
        return true;
    }
}
