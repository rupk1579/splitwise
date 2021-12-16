package service;

import model.Expense;
import model.User;

public class ExactSplit extends Split {
   private double amount;

    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
