package model;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Expense {
    private String expenseId;
    private ExpenseType expenseType;
    private Map<String,Double> users;//Equivalent to List<Split>
    private String expenseName;
    private Date createdDate;
    private double amount;
    private User paidBy;


    public Expense(ExpenseType expenseType, Map<String,Double> users, String expenseName,double amount,User paidBy) {
        this.amount = amount;
        this.expenseType = expenseType;
        this.users = users;
        this.expenseName = expenseName;
        this.expenseId = UUID.randomUUID().toString();
        this.paidBy = paidBy;
        this.createdDate = new Date();
    }

    public String getExpenseId() {
        return expenseId;
    }

    public ExpenseType getExpenseType() {
        return expenseType;
    }

    public Map<String,Double> getUsers() {
        return users;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public double getAmount() {
        return amount;
    }

    public User getPaidBy() {
        return paidBy;
    }
}
