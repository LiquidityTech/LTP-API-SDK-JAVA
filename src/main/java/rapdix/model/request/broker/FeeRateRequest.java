package rapdix.model.request.broker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class FeeRateRequest {
    private String exchange;
    private String instType;
    private String portfolioIds;

}
