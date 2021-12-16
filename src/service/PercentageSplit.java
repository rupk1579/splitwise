package service;

import model.Expense;
import model.User;

public class PercentageSplit extends Split {
    private int percentage;

    public PercentageSplit(User user, int percentage) {
        super(user);
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }
}
