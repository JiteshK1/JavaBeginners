package immutable;

import immutable.ShallowDeep.Transaction;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {
      enum BankType{CHECKING,SAVING}

   private  final BankType bankType;
    private  Double balance;

    private final Map<Long, Transaction> transactions = new LinkedHashMap<>();

    public Map<Long, String> getTransactions() {
           Map<Long,String> txMap= new LinkedHashMap<>();
               for(var tx: transactions.entrySet()){
                   txMap.put(tx.getKey(),tx.getValue().toString());
               }
               return txMap;
    }
    BankAccount(BankType bankType, Double balance) {
        this.bankType = bankType;
        this.balance = balance;
    }

    public BankType getBankType() {
        return bankType;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "%s Rs.%.2f".formatted(bankType, balance);
    }

    void commitTransactions(int routingNumber,long transactionId,String customerId,double amount){
        balance+=amount;
        transactions.put(transactionId,new Transaction(routingNumber,transactionId,Integer.parseInt(customerId),amount));
    }
}

