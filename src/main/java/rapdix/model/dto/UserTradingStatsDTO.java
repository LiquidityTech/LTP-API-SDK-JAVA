package rapdix.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author cookieyuan
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserTradingStatsDTO {
    private String exchange;
    private String businessType;
    private String executedAmount;
}
