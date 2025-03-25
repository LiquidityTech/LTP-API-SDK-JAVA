package rapdix.model.request.rules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class FundingRateRequest {
    private String sym;
}
