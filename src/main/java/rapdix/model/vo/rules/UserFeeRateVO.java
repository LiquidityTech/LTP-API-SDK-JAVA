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
public class UserFeeRateVO {
    private String exchangeType;
    private String businessType;
    private String takerFeeRate;
    private String makerFeeRate;
    private String level;
}
