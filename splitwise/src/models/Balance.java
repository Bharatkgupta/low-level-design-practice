package models;

public class Balance {
    private String primaryUserId;
    private String secondaryUserId;
    private double balance;

    public Balance(String pUser, String sUser, double balance) {
        this.balance = balance;
        this.primaryUserId = pUser;
        this.secondaryUserId = sUser;
    }

    public String getPrimaryUserID() {
        return this.primaryUserId;
    }

    public String getSecondaryUserID() {
        return this.secondaryUserId;
    }

    public double getBalance() {
        return this.balance;
    }

    public String toString() {
        return String.format("%s lent %d to %s.", primaryUserId, balance, secondaryUserId);
    }
}
