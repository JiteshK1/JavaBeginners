package List;

import java.util.ArrayList;

public class Bank {
    private  String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches=new ArrayList<Branch>();
    }

    public  boolean addBranch(String branchName){
        if (findBranch(branchName)!=null){
            return false;
        }
        branches.add(new Branch(branchName));
        return true;

    }
    public  boolean addCustomer(String branchName,String cname,double transaction){
           if (findBranch(branchName)!=null){
               findBranch(branchName).newCustomer(cname,transaction);
               return true;
           }
return false;
    }
    public  boolean addCustomerTransaction(String branchName,String cname,double transaction){
        if (findBranch(branchName)!=null){
            findBranch(branchName).addCustomerTransaction(cname,transaction);
            return true;
        }
        return false;

    }

   public Branch findBranch(String branchName){
       for (Branch b:
               branches
            ) {
           if (b.getName().compareTo(branchName) == 0){
               return  b;
           }

       }
       return null;

   }
    public boolean listCustomers(String nameOfBranch, boolean printTransactions) {
        Branch tempBranch = findBranch(nameOfBranch);
        if(tempBranch != null && printTransactions) {
            System.out.println("Customer details for branch " + tempBranch.getName());
            for(int i=0; i<tempBranch.getCustomers().size(); i++) {
                System.out.println("Customer: " + tempBranch.getCustomers().get(i).getName() + "[" + (i+1) + "]");
                System.out.println("Transactions");
                for(int j=0; j<tempBranch.getCustomers().get(i).getTransactions().size(); j++) {
                    System.out.println("[" + (j+1) + "]  Amount " + tempBranch.getCustomers().get(i).getTransactions().get(j));
                }
            }
            return true;
        } else if(tempBranch != null) {
            System.out.println("Customer details for branch " + tempBranch.getName());
            for(int i=0; i<tempBranch.getCustomers().size(); i++) {
                System.out.println("Customer: " + tempBranch.getCustomers().get(i).getName() + "[" + (i+1) + "]");
            }
            return true;
        } else {
            return false;
        }
    }
}
