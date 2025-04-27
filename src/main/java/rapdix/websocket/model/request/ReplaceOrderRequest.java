package rapdix.websocket.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReplaceOrderRequest {
    private String id;
    @Builder.Default
    private String action = "replace_order";
    private CancelOrderRequest.CancelOrderArgs args;

    @Data
    @Builder
    public static class ReplaceOrderArgs {
        private String orderId;
        private String replaceQty;
        private String replacePrice;
    }
}
