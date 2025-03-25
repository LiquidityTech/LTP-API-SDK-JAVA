package rapdix.websocket.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlaceOrderRequest {
    private String id;
    @Builder.Default
    private String action = "place_order";
    private OrderArgs args;

    @Data
    @Builder
    public static class OrderArgs {
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
} 