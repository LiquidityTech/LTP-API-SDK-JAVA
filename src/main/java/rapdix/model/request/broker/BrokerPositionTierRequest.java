package rapdix.model.request.broker;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class BrokerPositionTierRequest {
    private String sym;
}
