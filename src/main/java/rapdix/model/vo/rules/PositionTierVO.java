package rapdix.model.vo.rules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PositionTierVO {
    private String sym;

    /**
     * Current Level Position Limit Starting Value
     */
    private String minNotionalValue;

    /**
     * Position Limit
     */
    private String maxNotionalValue;

    /**
     * Maximum bar multiplier
     */
    private String maxLeverage;

    /**
     * Maintenance of margin rates
     */
    private String mmRate;

    /**
     * Risk limit bracket
     */
    private String riskLevel;
}
