package rapdix.websocket.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebSocketRequest {
    private String action;
    private Object args;

    @Data
    @Builder
    public static class WebSocketLoginArgs {
        private String apiKey;
        private String timestamp;
        private String sign;
    }

    @Data
    @Builder
    public static class SubscribeArgs {
        private String channel;
        private String symbol;
        private String interval;
        private String level;
    }
} 