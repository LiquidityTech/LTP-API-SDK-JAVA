package rapdix.model.vo.rules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FundingRateVO {
    private String fundingRate;
    private String fundingTime;
    private String sym;
    private String nextFundingTime;
}
