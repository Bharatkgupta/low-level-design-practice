package services;

import java.util.HashMap;
import java.util.Map;

import models.Expense;

public class SplitService {
    private static SplitService service;
    private Map<String, Map<String, Double>> balances;
    private SplitService() {
        balances = new HashMap<String,Map<String,Double>>();
    }

    public static SplitService getSplitService() {
        if(service == null) {
            synchronized(SplitService.class) {
                if (service == null) {
                    service = new SplitService();
                }
            } 
        }
        return service;
    }

    public void UpdateSplit(Expense expense) {
        for(var balance : expense.getSplit()) {
            if(balances.getOrDefault(balance.getPrimaryUserID(), null) == null) {
                balances.put(balance.getPrimaryUserID(), new HashMap<>());
            }

            if(balances.get(balance.getPrimaryUserID()).getOrDefault(balance.getSecondaryUserID(), null) == null) {
                balances.get(balance.getPrimaryUserID()).put(balance.getSecondaryUserID(), 0.0);
            }

            double oldAmount = balances.get(balance.getPrimaryUserID()).get(balance.getSecondaryUserID());

            balances.get(balance.getPrimaryUserID()).put(balance.getSecondaryUserID(), oldAmount+balance.getBalance());

            if(balances.getOrDefault(balance.getSecondaryUserID(), null) == null) {
                balances.put(balance.getSecondaryUserID(), new HashMap<>());
            }

            if(balances.get(balance.getSecondaryUserID()).getOrDefault(balance.getPrimaryUserID(), null) == null) {
                balances.get(balance.getSecondaryUserID()).put(balance.getPrimaryUserID(), 0.0);
            }

            oldAmount = balances.get(balance.getSecondaryUserID()).get(balance.getPrimaryUserID());

            balances.get(balance.getSecondaryUserID()).put(balance.getPrimaryUserID(), oldAmount-balance.getBalance());
        }
    }

    public void getBalances(String userId1, String userId2) {
        if(balances.getOrDefault(userId1, null) == null) {
            System.err.println(String.format("No Balances between %s and %s", userId1, userId2));
            return;
        }

        if(balances.get(userId1).getOrDefault(userId2, null) == null) {
            System.err.println(String.format("No Balances between %s and %s", userId1, userId2));
            return;
        }

        double amount = balances.get(userId1).get(userId2);

        if(amount == 0) {
            System.err.println(String.format("%s and %s are all settled Up!!", userId1, userId2));
        } else if(amount > 0) {
            System.err.println(String.format("%s lent %s, %f", userId1, userId2, amount));
        } else {
            System.err.println(String.format("%s owes %s, %f", userId1, userId2, Math.abs(amount)));
        }
    }
}
