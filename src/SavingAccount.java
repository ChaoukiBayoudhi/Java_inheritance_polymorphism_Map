import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.Scanner;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
public class SavingAccount extends Account{
    private static final double SOLD_MIN=10;
    private double interestRate;
    //no args constructor
    //public SavingAccount(){
     //   super();//call the mother class constructor
    //}
    //all args constructor
    public SavingAccount(String RIB, double sold,double interestRate){
        super(RIB, sold);
        this.interestRate = interestRate;
    }
    public double getInterest(){
        return sold*(1+interestRate);
    }
    @Override
    public boolean withdraw(double amount){
        if (amount<=0 ||sold-amount<SOLD_MIN)
            return false;
        sold-=amount;
        return true;
    }
    @Override
    public void getAccount(){
        super.getAccount();
        Scanner sc=new Scanner(System.in);
        System.out.print("interest rate = ");
        interestRate= sc.nextDouble();
    }
}
