package immutable;

public class BankMain {
    public static void main(String[] args) {
        Bank bank = new Bank(3214567);
        bank.addCustomer("Joe", 500.00,
                10000.00);
        BankCustomer joe = bank.getCustomer("000000010000000");
        System.out.println(joe);
        if (bank.doTransaction(joe.getCustomerId(), BankAccount.BankType.CHECKING,
                35)) {
            System.out.println(joe);
        }
        if (bank.doTransaction(joe.getCustomerId(), BankAccount.BankType.CHECKING,
                -535)) {
            System.out.println(joe);
        }
        BankAccount checking = joe.getAccount(BankAccount.BankType.CHECKING);
        var transactions = checking.getTransactions();
        transactions.forEach((k, v) -> System.out.println(k + ": " + v));
        joe.getAccount(BankAccount.BankType.CHECKING).getTransactions().clear();
        System.out.println("------------------");
        joe.getAccount(BankAccount.BankType.CHECKING).getTransactions()
                .forEach((k, v) -> System.out.println(k + ": " + v));

    }

}
