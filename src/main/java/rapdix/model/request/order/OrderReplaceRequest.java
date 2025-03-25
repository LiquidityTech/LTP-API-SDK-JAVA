package rapdix.model.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OrderReplaceRequest {
    private String orderId;
    private String replaceQty;
    private String replacePrice;
}
