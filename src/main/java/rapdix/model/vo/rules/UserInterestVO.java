package rapdix.model.vo.rules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserInterestVO {

    /**
     * user level
     */
    private Integer level;
    /**
     * stock exchange
     */
    private String exchangeType;
    /**
     * coin
     */
    private String coin;
    /**
     * hourly interest rate
     */
    private String hourInterestRate;
    /**
     * borrowing limit
     */
    private String loanLimit;
    /**
     * updateTime
     */
    private Long updateTime;

}
