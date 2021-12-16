package service;

import model.Expense;
import model.User;

import java.util.HashMap;
import java.util.Map;

public class SplitManagement {

    public void updateUserProfile(Expense expense){
        Map<String,Double> users = expense.getUsers();
        User paidBy = expense.getPaidBy();//U1

        for(Map.Entry<String,Double> user :users.entrySet()){//U2
            double amountToSplit = user.getValue();
            Map<String,Double> balanceOwesByUser = User.getBalances().containsKey(user.getKey()) ? User.getBalances().get(user.getKey()): new HashMap<>();
            Map<String,Double> balanceOwesByPaidUser =User.getBalances().containsKey(paidBy.getUserId()) ? User.getBalances().get(paidBy.getUserId()):new HashMap<>();
            if(balanceOwesByUser.containsKey(paidBy.getUserId())){
                double oldAmount = balanceOwesByUser.get(paidBy.getUserId());
                balanceOwesByUser.put(paidBy.getUserId(),oldAmount+amountToSplit);

            }else{
                if(balanceOwesByPaidUser.containsKey(user.getKey())){
                    double paidByUserAmount = balanceOwesByPaidUser.get(user.getKey());
                    if(paidByUserAmount-amountToSplit >0){
                        balanceOwesByPaidUser.put(user.getKey() ,paidByUserAmount-amountToSplit);
                        balanceOwesByUser.remove(paidBy.getUserId());
                    }
                    else if(paidByUserAmount-amountToSplit<0){
                        balanceOwesByUser.put(paidBy.getUserId(),amountToSplit-paidByUserAmount);
                        balanceOwesByPaidUser.remove(user.getKey());
                    }
                    else{
                        balanceOwesByPaidUser.remove(paidBy.getUserId());
                        balanceOwesByPaidUser.remove(user.getKey());
                    }
                }
                else{
                    balanceOwesByUser.put(paidBy.getUserId(),amountToSplit);
                }
            }
            User.getBalances().put(user.getKey(),balanceOwesByUser);
            User.getBalances().put(paidBy.getUserId(),balanceOwesByPaidUser);
        }
    }
}
