package rapdix.websocket.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CancelOrdersRequest {
    private String id;
    @Builder.Default
    private String action = "cancel_orders";
    private CancelOrdersArgs args;

    @Data
    @Builder
    public static class CancelOrdersArgs {
        private String exchangeType;
    }
} 