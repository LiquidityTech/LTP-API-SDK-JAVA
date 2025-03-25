package rapdix.model.vo.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderPlaceVO {
    /**
     * Order number
     */
    private String orderId;
    /**
     * Client order number
     */
    private String clientOrderId;
}
