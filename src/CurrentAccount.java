import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@SuperBuilder
public class CurrentAccount extends  Account{
    private static final double SOLD_MIN=-900;

    @Override
    public boolean withdraw(double amount){
        if(amount<=0 || amount>Math.abs(sold+SOLD_MIN))
            return false;
        sold -= amount;
        return true;
    }

}
