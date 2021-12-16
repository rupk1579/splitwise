package service;

import model.User;

import java.util.HashMap;
import java.util.Map;

public class BalanceDisplay {


    public void displayBalance(User user){
        Map<String,Double> balances = User.getBalances().containsKey(user.getUserId())
        ? User.getBalances().get(user.getUserId()): new HashMap<>();
        for(Map.Entry<String,Double> balance : balances.entrySet()){
            System.out.println("User:"+user.getName() +" owes "+ balance.getKey() + " amount of->"+balance.getValue());
        }

    }
}
