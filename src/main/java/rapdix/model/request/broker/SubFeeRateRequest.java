package rapdix.model.request.broker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class SubFeeRateRequest {
    private String exchange;
    private String instType;
}
