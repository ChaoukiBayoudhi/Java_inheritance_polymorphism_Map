import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.management.ConstructorParameters;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@ConstructorParameters({"RIB","sold"}) //à revoir
@ToString
//@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(of="RIB")
@SuperBuilder
public class Account {
    //@EqualsAndHashCode.Include
    private String RIB;
    protected double sold;
    private LocalDate creationDate=LocalDate.now();
    private AccountStatus status=AccountStatus.Active;

    public Account(String RIB, double sold) {
        this.RIB = RIB;
        this.sold = sold;
    }
    public boolean deposit(double amount) {
        if(amount<=0)
            return false;
        sold += amount;
        return true;
    }
    public boolean withdraw(double amount) {
        if(amount<=0 || amount>sold)
            return false;
        sold -= amount;
        return true;
    }
    public boolean transfer(Account beneficialAccount, double amount) {
        boolean result=this.withdraw(amount);
        if(result)
            beneficialAccount.deposit(amount);
        return result;
    }
    public void getAccount(){
        Scanner sc=new Scanner(System.in);
        System.out.print("RIB = ");
        RIB=sc.next();
        System.out.print("sold = ");
        sold=sc.nextDouble();
        DateTimeFormatter format= DateTimeFormatter.ofPattern("yyyy-MM-dd");
        System.out.print("creation Date (yyy-MM-dd = ");
        creationDate=LocalDate.parse(sc.next(),format);
        //System.out.print("status = ");
        //status=AccountStatus.valueOf(sc.next());
    }
}
