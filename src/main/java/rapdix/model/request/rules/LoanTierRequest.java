package rapdix.model.request.rules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class LoanTierRequest {
    private String exchangeType;
    private String coin;
}
