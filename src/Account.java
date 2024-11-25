import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.management.ConstructorParameters;
import java.time.LocalDate;
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
}
