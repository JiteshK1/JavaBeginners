package immutable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {

    static int lastCustomerId = 10_000_000;
    private final String customerName;
    private final int customerId;

    private final List<BankAccount> bankAccounts = new ArrayList<>();

    BankCustomer(String customerName, double savingAmount, double checkingAmount) {
        this.customerName = customerName;
        customerId = lastCustomerId++;
        bankAccounts.add(new BankAccount(BankAccount.BankType.SAVING, savingAmount));
        bankAccounts.add(new BankAccount(BankAccount.BankType.CHECKING, checkingAmount));
    }

    public String getName() {
        return customerName;
    }

    public List<BankAccount> getBankAccounts() {
        return List.copyOf(bankAccounts);
    }

    public String getCustomerId() {
        return "%015d".formatted(customerId);
    }

    public BankAccount getAccount(BankAccount.BankType type) {
        for (BankAccount a : bankAccounts) {
            if (a.getBankType() == type) {
                return a;
            }
        }
        return null;
    }

    public List<BankAccount> getAccounts() {
        return new ArrayList<>(bankAccounts);
    }

    @Override
    public String toString() {
        String[] accountStrings = new String[bankAccounts.size()];
        Arrays.setAll(accountStrings, i -> bankAccounts.get(i).toString());
        return "Customer: %s (id:%015d)%n\t%s%n".formatted(customerName, customerId,
                String.join("\n\t", accountStrings));
    }
}
