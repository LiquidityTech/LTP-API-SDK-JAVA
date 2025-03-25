package rapdix.model.websocket;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WebSocketRequest {
    private String action;
    private WebSocketLoginArgs args;

    @Data
    @Builder
    public static class WebSocketLoginArgs {
        private String apiKey;
        private String timestamp;
        private String sign;
    }
} 