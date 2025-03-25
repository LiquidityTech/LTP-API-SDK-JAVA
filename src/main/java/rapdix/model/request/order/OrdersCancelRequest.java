package rapdix.model.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class OrdersCancelRequest {
    private String exchangeType;
    private String sym;
}
