package rapdix.model.vo.rules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author axia
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoanTierVO {
    private String exchangeType;

    private String tier;

    private String coin;

    private String minSize;

    private String maxSize;
    /**
     * Maintenance of margin rates
     */
    private String mmRate;

    private String maxLeverage;
}
