package rapdix.websocket.model.response;

import lombok.Data;
import java.util.List;

@Data
public class MarkPriceSubscribeResponse {
    private String event;
    private String code;
    private String message;
    private List<SubscribeArg> arg;

    @Data
    public static class SubscribeArg {
        private String channel;
        private String instId;
    }
} 