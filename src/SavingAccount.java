import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

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
}
