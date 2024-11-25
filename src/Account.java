import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Account {
    private String RIB;
    private double sold;
    private LocalDate creationDate;
    private CompteStatus status;
}
