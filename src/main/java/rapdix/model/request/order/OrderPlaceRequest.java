package rapdix.model.request.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OrderPlaceRequest {
    private String clientOrderId;
    private String sym;
    private String side;
    private String orderType;
    private String timeInForce;
    private String orderQty;
    private String limitPrice;
    private String quoteOrderQty;
    private String reduceOnly;
    private String positionSide;
    private String tpTriggerPrice;
    private String tpTriggerType;
    private String tpPrice;
    private String slTriggerPrice;
    private String slTriggerType;
    private String slPrice;
}
