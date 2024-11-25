import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<String,Account> accounts = new HashMap<String,Account>();

    public void addAccount(Account account){
        if(accounts.containsKey(account.getRIB()))
            System.out.println("an account with same RIB already exists.");
        else {
            accounts.put(account.getRIB(), account);
            System.out.println("The account with RIB " + account.getRIB() + " was successfully created.");
        }
    }
    public void removeAccount(String RIB){
        if(accounts.isEmpty())
            System.out.println("There are no accounts.");
        else {
            Account a1 = accounts.remove(RIB);
            if (a1 == null)
                System.out.println("the account with RIB " + RIB + " was not found");
            else
                System.out.println("The account with RIB " + RIB + " was successfully removed");
        }
    }
    public Account findAccount(String RIB){
        return accounts.get(RIB);
    }

    public List<Account> getOverdrawnAccounts(){
        List<Account> overdrawnAccounts = new ArrayList<>();
        for (Map.Entry<String,Account> entry : accounts.entrySet()){
            if(entry.getValue().getSold()<0)
                overdrawnAccounts.add(entry.getValue());

        }
        return overdrawnAccounts;
    }
    public boolean transfer(String RIB1, String RIB2,double amount){

    }
    public  List<Account> getSavingAccounts(){

    }
}
