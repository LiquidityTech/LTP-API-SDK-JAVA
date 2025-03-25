package rapdix.model.vo.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderCancelVO {
    /**
     * Order number
     */
    private String orderId;
    /**
     * Client order number
     */
    @Builder.Default
    private String clientOrderId = "";
    /**
     * Order state
     */
    private String orderState;
}
