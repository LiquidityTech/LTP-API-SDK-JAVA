package rapdix.websocket.model.request;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class MarkPriceSubscribeRequest {
    private String event;
    private List<SubscribeArg> arg;

    @Data
    @Builder
    public static class SubscribeArg {
        private String channel;
        private String instId;
    }
} 