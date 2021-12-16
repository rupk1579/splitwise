import model.Expense;
import model.ExpenseType;
import model.User;
import service.BalanceDisplay;
import service.SplitManagement;

import java.util.*;

public class MainExpenseClass {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        User user1 = new User("Rupa","rupak1234@gmail.com","23456789","Rupa");
        User user2 = new User("Chirag","1234@gmail.com","23456789","Chirag");
        User user3 = new User("Yasheel","1234@gmail.com","23456789","Yasheel");
        User user4 = new User("Vrinda","12345@gmail.com","23456789","Vrinda");
        User user5 = new User("Sourabh","1234@gmail.com","23456789","Sourabh");
        Map<String,Double> userMap = new HashMap<>();
        userMap.put(user2.getUserId(),20.00);
        userMap.put(user3.getUserId(),20.00);
        userMap.put(user4.getUserId(),20.00);
        userMap.put(user5.getUserId(),20.00);
        Expense expense = new Expense(ExpenseType.EQUAL,userMap,"Shimla Trip",100.00,user1);
        SplitManagement splitManagement =  new SplitManagement();
        splitManagement.updateUserProfile(expense);

        Map<String,Double> userMap1 = new HashMap<>();
        userMap1.put(user1.getUserId(),100.00);
        userMap1.put(user3.getUserId(),200.00);
        userMap1.put(user4.getUserId(),100.00);
        userMap1.put(user5.getUserId(),20.00);

        Expense expense1 = new Expense(ExpenseType.EXACT,userMap1,"Shimla Trip Food",500,user2);
        splitManagement.updateUserProfile(expense1);
        BalanceDisplay balanceDisplay = new BalanceDisplay();
        System.out.println("Display Balance of users");
        balanceDisplay.displayBalance(user1);
        balanceDisplay.displayBalance(user2);
        balanceDisplay.displayBalance(user3);
        balanceDisplay.displayBalance(user4);
        balanceDisplay.displayBalance(user5);

    }
}
