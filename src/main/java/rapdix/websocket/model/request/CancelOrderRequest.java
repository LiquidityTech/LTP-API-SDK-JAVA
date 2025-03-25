package rapdix.websocket.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CancelOrderRequest {
    private String id;
    @Builder.Default
    private String action = "cancel_order";
    private CancelOrderArgs args;

    @Data
    @Builder
    public static class CancelOrderArgs {
        private String orderId;
        private String clientOrderId;
    }
} 