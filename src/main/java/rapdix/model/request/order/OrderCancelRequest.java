package rapdix.model.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@AllArgsConstructor
@Builder
public class OrderCancelRequest {
    private String orderId;
    private String clientOrderId;
}
