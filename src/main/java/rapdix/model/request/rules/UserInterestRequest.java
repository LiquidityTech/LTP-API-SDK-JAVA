package rapdix.model.request.rules;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class UserInterestRequest {
    private String exchangeType;
}
