package rapdix.model.vo.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderReplaceVO {
    /**
     * Order number
     */
    private String orderId;

    /**
     * Order state
     */
    private String orderState;
}
